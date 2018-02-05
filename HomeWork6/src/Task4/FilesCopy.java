package Task4;

import java.io.*;

public class FilesCopy {
    private static final int BUFFER_SIZE = 1024*1024;
    public static boolean fileCopy(File fileInput, String fileResult)throws IOException{
        String fileName = fileInput.getName();
        int readByre = 0;
        byte[] buffer = new byte[BUFFER_SIZE];
        try (FileInputStream in = new FileInputStream(fileInput);
                FileOutputStream out = new FileOutputStream(new File(fileResult + fileName))){
            for (; (readByre = in.read(buffer)) > 0;) {
                out.write(buffer, 0, readByre);
            }
        }
        catch (IOException e){
                    throw e;
        }
        return true;
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
                fileCopy(from, pathTo);

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
