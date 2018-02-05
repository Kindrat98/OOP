package Task4;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        String pathTo = "D:\\Нова папка\\";
        String pathFrom = "C:\\Users\\Ivan\\Desktop\\учоба\\дифури лекції";
        File directory = new File(pathFrom);
        File[] myDir = directory.listFiles();
        FileRunnable fileWork = new FileRunnable(myDir.length, myDir);
        FileRunnable.to(pathTo);
        Thread[] workers = new Thread[5];
        for (Thread temp: workers) {
            temp = new Thread(fileWork);
            temp.start();
        }


    }
}
