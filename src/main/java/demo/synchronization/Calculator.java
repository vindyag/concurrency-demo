package demo.synchronization;

import java.util.concurrent.TimeUnit;

public class Calculator {
    int cell1;
    int cell2;
    int cell3;

    synchronized int setAndGetSum(int val1, int val2, int val3) throws InterruptedException {
        System.out.println("Starting " + Thread.currentThread().getName());
        cell1 = val1;
        System.out.println(Thread.currentThread().getName() + " setting cell1 " + cell1);
        TimeUnit.MILLISECONDS.sleep(val1);

        cell2 = val2;
        TimeUnit.MILLISECONDS.sleep(val2);
        System.out.println(Thread.currentThread().getName() + " setting cell2 " + cell2);

        cell3 = val3;
        TimeUnit.MILLISECONDS.sleep(val3);
        System.out.println(Thread.currentThread().getName() + " setting cell3 " + cell3);

        int sum = cell1 + cell2 + cell3;
        System.out.println(Thread.currentThread().getName() + " calc sum " + sum);
        System.out.println(sum);

        System.out.println("Ending " + Thread.currentThread().getName());
        return sum;
    }
}
