package demo.concurrency;

import java.util.concurrent.Callable;

public class SampleRunnable implements Runnable {

    private int sum = 0;

    @Override public void run() {
        System.out.println("Inside run method");
        for (int i = 0; i < 100000; i++) {
            sum += i;
        }
        System.out.println("Sum: "+sum);

    }
}
