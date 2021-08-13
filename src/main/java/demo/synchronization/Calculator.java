package demo.synchronization;

import java.util.concurrent.TimeUnit;

/**
 * This won't work without synchronized in setAndGetSum
 */
public class Calculator {
    int cell1;
    int cell2;
    int cell3;

   /* ThreadLocal<Integer> cell1 = new ThreadLocal();
    ThreadLocal<Integer> cell2 = new ThreadLocal();
    ThreadLocal<Integer> cell3 = new ThreadLocal();
*/
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

/*    synchronized int setAndGetSumWithThreadLocal(int val1, int val2, int val3) throws InterruptedException {
        System.out.println("Starting " + Thread.currentThread().getName());
        cell1.set(val1);
        System.out.println(Thread.currentThread().getName() + " setting cell1 " + cell1);
        TimeUnit.MILLISECONDS.sleep(val1);

        cell2.set(val2);
        TimeUnit.MILLISECONDS.sleep(val2);
        System.out.println(Thread.currentThread().getName() + " setting cell2 " + cell2);

        cell3.set(val3);
        TimeUnit.MILLISECONDS.sleep(val3);
        System.out.println(Thread.currentThread().getName() + " setting cell3 " + cell3);

        int sum = cell1.get() + cell2.get() + cell3.get();
        System.out.println(Thread.currentThread().getName() + " calc sum " + sum);
        System.out.println(sum);

        System.out.println("Ending " + Thread.currentThread().getName());
        return sum;
    }*/
}
