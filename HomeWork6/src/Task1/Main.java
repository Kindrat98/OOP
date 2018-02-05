package Task1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        RunnableFactorial myRun = new RunnableFactorial();
        List<Thread> threads = new ArrayList();
        for (int i = 0; i < 100; i += 1) {
            threads.add(new Thread(myRun));
        }
        for (int i = 0; i < 100 ; i += 1) {
            threads.get(i).start();
        }


    }
}
