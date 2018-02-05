package Task2;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadFileCopy {
    private Path path;
    private String copyDirectory;
    private ExecutorService service;
    private int count = 0;
    private int STEP_SIZE;
    private int MAX_THREADS = 10;


    public MultiThreadFileCopy(String filePath, String copyDirectory) {
        path = Paths.get(filePath);
        this.copyDirectory = copyDirectory;
        try {
            STEP_SIZE = Files.readAllBytes(path).length / MAX_THREADS;
        } catch (IOException e) {
            e.printStackTrace();
        }
        service = Executors.newScheduledThreadPool(MAX_THREADS);
    }

    public void fileCopy() {
        try {
            byte[] bytes = Files.readAllBytes(path);
            if (Files.exists(Paths.get(copyDirectory + "\\" + path.getFileName()))) {
                Files.delete(Paths.get(copyDirectory + "\\" + path.getFileName()));
            }
            System.out.print("Coping [");
            for (int i = 0; i <= MAX_THREADS; i++) {
                if (count + STEP_SIZE > bytes.length) {
                    service.submit(new FileCopyHelper(Arrays.copyOfRange(bytes, count, bytes.length), path));
                    break;
                }
                if (count == 0) {
                    service.submit(new FileCopyHelper(Arrays.copyOfRange(bytes, count, STEP_SIZE), path));
                    count += STEP_SIZE;
                    continue;
                }
                service.submit(new FileCopyHelper(Arrays.copyOfRange(bytes, count, count += STEP_SIZE), path));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            service.shutdown();
            System.out.print("]");

        }
    }

    private class FileCopyHelper implements Runnable {
        private Path path;
        private byte[] bytes;
        private String workFile;


        public FileCopyHelper(byte[] bytes, Path path) {
            this.bytes = bytes;
            this.path = path;
            workFile = copyDirectory + "\\" + this.path.getFileName();

        }

        @Override
        public synchronized void run() {
            try (FileWriter writer = new FileWriter(workFile, true)) {
                System.out.print("#");
                writer.write(new String(bytes));
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}