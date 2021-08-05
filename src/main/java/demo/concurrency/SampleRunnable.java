package demo.concurrency;

import java.util.concurrent.Callable;

public class SampleRunnable implements Callable<Integer> {

    private int sum = 0;

    @Override public Integer call() throws Exception {
        System.out.println("uu");
        for (int i = 0; i < 100000; i++) {
            sum += i;
        }
        return sum;
    }


}
