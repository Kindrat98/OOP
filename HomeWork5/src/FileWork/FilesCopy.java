package FileWork;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FilesCopy {
    private static final int BUFFER_SIZE = 1024*1024;
    public static void fileCopy(String fileInput, String fileResult)throws IOException{
        System.out.println(fileInput);
        String fileName;
        if (fileInput.contains("\\")){
            int point = fileInput.lastIndexOf("\\");
            fileName = fileInput.substring(point +1);
        }
        else {
            fileName = fileInput;
        }
        System.out.println(fileName);

        int readByre = 0;
        byte[] buffer = new byte[BUFFER_SIZE];
        try (FileInputStream in = new FileInputStream(new File(fileInput));
                FileOutputStream out = new FileOutputStream(new File(fileResult + fileName))){
            for (; (readByre = in.read(buffer)) > 0;) {
                out.write(buffer, 0, readByre);
            }
        }
        catch (IOException e){
                    throw e;
        }
    }

    public static String createFolder(File oldFolder, String resultFolder){
        if(oldFolder.isDirectory()) {
            String folderName = oldFolder.getName();
            File newFolder = new File(resultFolder + "\\" + folderName);
            newFolder.mkdir();
            return folderName;
        }
        return null;
    }
    public static void filesCopy(String pathFrom, String pathTo)throws IOException{

        File from = new File(pathFrom);
        if(from.isFile()){
                fileCopy(from.getAbsolutePath(), pathTo);

        }
        else {
            String tempStringPath = createFolder(from, pathTo);;
            File[] fileArray = from.listFiles();
            int i = 0;
            for (File item:fileArray ) {

                createFolder(item, pathTo + tempStringPath);
                filesCopy(item.getAbsolutePath(), pathTo + "\\" + tempStringPath);

            }
        }
    }


}
