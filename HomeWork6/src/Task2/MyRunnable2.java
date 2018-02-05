package Task2;

import java.util.List;

public class MyRunnable2 implements Runnable {
    private List<Integer> partList;
    private int n1;
    private int n2;
    private long[] result;
    private static int count = 0;

    public MyRunnable2(List<Integer> partList, int n1, int n2, long[] result ) {
        this.partList = partList;
        this.n1 = n1;
        this.n2 = n2;
        this.result = result;

    }


    private long sum(){
        long sum = 0;
        for (int i = n1; i < n2; i++) {
            sum += partList.get(i);
        }
        return sum;
    }

    private static int getTreadInt(String input){
        return Integer.parseInt(input.substring(input.length() - 1 ));
    }

    @Override
    public void run() {
        result[getTreadInt(Thread.currentThread().getName())  ] = sum();
    }
}
