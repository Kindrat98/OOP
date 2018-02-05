package Task3;

public class MultiThreadSorting {
    static void sort(int[] array, int threadNumber){
        SingleThredSorting[] threadarray = new SingleThredSorting[threadNumber];
        for (int i = 0; i <threadarray.length ; i++) {
            int size = array.length / threadNumber;
            int begin = size*i;
            int end = (size * (i+1));
            if((array.length - end) < size) {
                end = array.length;
            }
            threadarray[i] = new SingleThredSorting(array, begin, end);
        }
        for (int i = 0; i < threadarray.length  ; i++) {
            try {
                threadarray[i].getThr().join();
            }
            catch (InterruptedException e){
                System.out.println(e);
            }
        }
        System.arraycopy(mergeArrays(array, threadarray), 0, array, 0, array.length);
    }

    private static int[] mergeArrays(int[] array, SingleThredSorting[] threadarray){
        int[] arr = new int[array.length];
        for (int i = 0; i < arr.length; i++){
            int min = Integer.MAX_VALUE;
            int k = -1;
            for (int j = 0; j < threadarray.length; j++) {
                if(!threadarray[j].isStop() && min > threadarray[j].peekElement()){
                    min = threadarray[j].peekElement();
                    k = j;
                }
            }
            if (k != -1){
                arr[i] = threadarray[k].pollElement();
            }
        }

        return arr;
    }
}
