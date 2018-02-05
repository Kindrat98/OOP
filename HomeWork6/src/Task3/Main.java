package Task3;

import java.util.Arrays;
import java.util.Random;

public class Main {
    static void sort(int[] array){
        int temp;
        for (int d = array.length/2; d >= 1; d /= 2)
            for (int i = d; i < array.length; i++)
                for (int j = i; j >= d && array[j-d] > array[j]; j -= d) {
                    temp = array[j];
                    array[j] = array[j-d];
                    array[j-d] = temp;
                }


        }
    public static void main(String[] args) {
        int[] array = new int[9000000];
        Random rnd = new Random(System.currentTimeMillis());
        for (int i = 0; i < array.length; i++) {
            array[i] = rnd.nextInt(1000);
        }
        int[] array2 = array.clone();
        int[] array3 = array.clone();
        long tSTART = System.currentTimeMillis();
        MultiThreadSorting.sort(array, 10);
        long tEnd = System.currentTimeMillis();
        System.out.println((tEnd - tSTART));
        tSTART = System.currentTimeMillis();
        sort(array2);
        tEnd = System.currentTimeMillis();
        System.out.println((tEnd - tSTART));
        tSTART = System.currentTimeMillis();
        Arrays.sort(array3);
        tEnd = System.currentTimeMillis();
        System.out.println((tEnd - tSTART));
    }
}
