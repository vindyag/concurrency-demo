package demo.concurrency;

import java.util.concurrent.Callable;

public class SampleCallable implements Callable<Integer> {

    private int sum = 0;

    @Override public Integer call() throws Exception {
        System.out.println("Inside run method");
        for (int i = 0; i < 10; i++) {
            sum += i;
        }
        return sum;
    }


}
