package FileWithSame;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConnectToOne {
    public static void read(String filePathFrom, List<String> result){
        try(Scanner in = new Scanner(new FileInputStream(filePathFrom))){
            while (in.hasNext()){
                result.add(in.next());
            }
        }
        catch (FileNotFoundException ex){
            System.out.println(ex.getMessage());
        }
    }

    public static void write(String filePathFrom, List<String> inputValues ){
        try(FileWriter result = new FileWriter(filePathFrom)){
            result.write(inputValues.toString());
            result.flush();
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) {
        List<String> file1 = new ArrayList();
        List<String> file2 = new ArrayList();
        List<String> result = new ArrayList();
        String path1 = "text1.txt";
        String path2 = "text2.txt";
        String path3 = "text3.txt";
        read(path1, file1);
        read(path2, file2);
        for (int i = 0; i < file2.size(); i++) {
            if(file2.contains(file2.get(i)))    {
                result.add(file2.get(i));
            }
        }
        write(path3, result);

    }
}
