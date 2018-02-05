package Task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rnd = new Random(System.currentTimeMillis());
        List<Integer> mySum = new ArrayList();
        long sum = 0;
        long sum2 = 0;
        long n = 20000000;
        int countThreds = 5;
        long[] mySum2 = new long[countThreds];
        int temp = (int)(n / countThreds);
        List<Thread> myThreads = new ArrayList();
        for (int i = 0; i < n ; i++) {
            mySum.add(rnd.nextInt(10));
            sum += mySum.get(i);
        }
        System.out.println(sum);


        for (int i = 0; i < countThreds; i++){
            myThreads.add(new Thread(new MyRunnable2(mySum, i*temp, (i +1)*temp, mySum2)));
        }
        for (int i = 0; i < countThreds; i++){
            myThreads.get(i).start();
        }

        for (int i = 0; i < countThreds; i++){
            try {
                myThreads.get(i).join();
            }
            catch (InterruptedException e){
                System.out.println(e.getMessage());
            }
        }
        for (long item: mySum2) {
            sum2 += item;
        }
        System.out.println(sum2);



    }
}
