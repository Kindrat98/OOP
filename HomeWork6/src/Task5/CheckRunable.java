package Task5;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class CheckRunable implements Runnable {
    private SimpleDateFormat myTime;
    private File file;

    public CheckRunable(File file) {
        this.file = file;
        myTime = new SimpleDateFormat("HH:mm:ss");
    }

    @Override
    public void run() {
        int counter;
        int checkChalange = 0;
        while (fileCount()){
            ArrayList<Integer> r = new ArrayList();

            StringBuilder toScrean = new StringBuilder();
            File[] myFiels = file.listFiles();
            toScrean.append(myTime.format(new Date()));
            toScrean.append(System.lineSeparator());
            for (File temp: myFiels) {
                toScrean.append(temp.getName());
                toScrean.append(System.lineSeparator());
            }
            System.out.println(toScrean.toString());


            counter = myFiels.length;
            checkChalange = counter;
            //System.out.println("counter before" + counter);
            //System.out.println("clange before" + checkChalange);

            try {
                Thread.sleep(10000);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
            File[] myFielsToCheck = file.listFiles();
            counter = myFielsToCheck.length;
            //System.out.println("counter after" + counter);
            //System.out.println("chalenge after" + checkChalange);
            //System.out.println((checkChalange - counter));

            if((counter - checkChalange) !=0){
                System.out.println("Somsing changed");
            }
            else {
                System.out.println("Nothing");
            }

        }
    }

    private boolean fileCount(){
        if(file.isDirectory()){
            File[] checkArray = file.listFiles();
            if(checkArray.length > 0){
                return true;
            }
            else {
                System.out.println("It is empty, i want a rest");
                return false;
            }
        }
        else {
            System.out.println("It is not Direcrtory");
            return false;
        }
    }
}
