package Task5;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        String pathFile = "D:\\Нова папка\\";
        File toCheck = new File(pathFile);
        CheckRunable firstRun = new CheckRunable(toCheck);
        Thread concurent = new Thread(firstRun);
        concurent.start();
    }
}
