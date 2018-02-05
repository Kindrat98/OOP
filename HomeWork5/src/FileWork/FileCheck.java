package FileWork;

import java.io.File;
import java.io.FileFilter;

public class FileCheck implements FileFilter{
    private  String[] arrPosible;

    public FileCheck(String[] arrPosible) {

        this.arrPosible = arrPosible;
    }

    public  boolean check(String input){
        for (String item: arrPosible) {
            if(item.equalsIgnoreCase(input)){
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean accept(File pathname) {
       int pointIndex = pathname.getName().lastIndexOf(".");
       if (pointIndex == -1){
           return false;
       }
       String ext = pathname.getName().substring(pointIndex + 1);
       return check(ext);
    }
}
