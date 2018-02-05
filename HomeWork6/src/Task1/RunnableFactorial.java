package Task1;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class RunnableFactorial implements Runnable{
    private static void factorial(int n){
        List<BigInteger> cesh = new ArrayList();
        cesh.add(new BigInteger("1"));
        for (int i = 1; i <= n ; i++){
            cesh.add(new BigInteger("" + i).multiply(cesh.get(i - 1)));
        }
        System.out.println(cesh.get(n).toString());
    }

    private static int getTreadInt(String input){
        return Integer.parseInt(input.substring(input.length() - 1 ));
    }


    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        int n = getTreadInt(thread.getName());
        factorial(n);
    }
}
