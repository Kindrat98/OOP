package Task3;

public class SingleThredSorting implements Runnable {
    private int[] array;
    private int begin;
    private int end;
    private Thread thr;
    private int index;
    private boolean stop = false;

    public SingleThredSorting(int[] array, int begin, int end) {
        this.array = array;
        this.begin = begin;
        this.end = end;
        thr = new Thread(this);
        thr.start();
        this.index = begin;
    }

    Thread getThr(){
        return thr;
    }

    public int peekElement(){
        return array[index];
    }

    public int pollElement(){
        int temp = array[index];
        check();
        return temp;
    }

    public boolean isStop() {
        return stop;
    }

    @Override
    public void run() {
        {
            int temp;
            for (int d = end/2; d >= 1; d /= 2)
                for (int i = d; i < end; i++)
                    for (int j = i; j >= d && array[j-d] > array[j]; j -= d) {
                        temp = array[j];
                        array[j] = array[j-d];
                        array[j-d] = temp;
                    }
        }

    }

    public void check(){
        this.index ++;
        if(this.index >= this.end){
            this.stop = true;
        }
    }
}