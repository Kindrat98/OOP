package FileWork;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String pathFrom ="C:\\Users\\Ivan\\Desktop\\учоба\\БД";
        String pahhTo = "D:\\Нова папка\\";
        FilesCopy.filesCopy(pathFrom, pahhTo);

    }
}
