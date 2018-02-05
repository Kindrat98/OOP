package Task4;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class FileRunnable implements Runnable {
    private int countFiles;
    private File[] directory;
    private static String toResult;
    private int[] flags;

    @Override
    public void run() {
        while (check()){
            boolean copied;
            int position = generateInt();
            if((directory[position] !=null) && (flags[position] == 0)){
                try {
                    flags[position] = 1;
                    FilesCopy.fileCopy(directory[position], toResult);
                    System.out.println(1);
                    directory[position] = null;
                }
                catch (IOException e){
                    e.getMessage();
                }
            }
        }
    }

    public static void to(String Path){
        toResult = Path;
    }

    public FileRunnable(int countFiles, File[] directory) {
        this.countFiles = countFiles;
        this.directory = directory;
        this.flags = createChecking();


    }
    private boolean check(){
        for (int i = 0; i < countFiles ; i++) {
            if((flags[i] == 0) && (directory[i] != null )){
                return true;
            }
        }
        return false;
    }
    private int generateInt(){
        Random rnd = new Random();
        return rnd.nextInt(countFiles);
    }
    private int[] createChecking(){
        int[] filesFlags = new int[countFiles];
        for (int temp:filesFlags) {
            temp = 0;
        }
        return filesFlags;
    }

}

















