package Task3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;

public class FileSearcher {
    private Path path;
    private ExecutorService executorService;
    private String searchFileName;
    private Queue<Path> paths;

    public FileSearcher(String path, String searhcFileName) {
        this.path = Paths.get(path);
        this.searchFileName = searhcFileName;
        paths = new PriorityBlockingQueue<>();
        executorService = Executors.newFixedThreadPool(10);
    }

    public void search() {
        paths.add(path);
        while (!paths.isEmpty()) {
            try {
                for (Path p : Files.newDirectoryStream(paths.poll())) {
                    if (Files.isDirectory(p)) {
                        paths.add(p);
                        executorService.submit(new FileSearcherHelper(paths.poll()));
                    } else {
                        if (String.valueOf(p.getFileName()).equalsIgnoreCase(searchFileName)) {
                            System.out.println(p.getParent() + "\\" + p.getFileName());
                        }
                    }
                }
            } catch (IOException ignored) {
            }
        }
        executorService.shutdown();

    }

    private class FileSearcherHelper implements Runnable {
        private Path path;

        public FileSearcherHelper(Path path) {
            this.path = path;
        }

        @Override
        public synchronized void run() {
            try {
                for (Path p : Files.newDirectoryStream(path)) {
                    if (Files.isDirectory(p)) {
                        paths.add(p);
                    }else {
                        if (searchFileName.equalsIgnoreCase(String.valueOf(p.getFileName()))) {
                            System.out.println(p.getParent() + "\\" + p.getFileName());
                        }

                    }
                }
            } catch (IOException ignored) {
            }

        }
    }
}