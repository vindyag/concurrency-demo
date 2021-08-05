package demo.test;

public class Example {
    int cell1;
    int cell2;
    int cell3;

   synchronized int setAndGetSum(int val1, int val2, int val3) throws InterruptedException {
        cell1 = val1;
        System.out.println(Thread.currentThread().getName()+" setting cell1 "+cell1);
        Thread.sleep(val1);

        cell2 = val2;
        Thread.sleep(val2);
        System.out.println(Thread.currentThread().getName()+" setting cell2 "+cell2);

        cell3 = val3;
        Thread.sleep(val3);
        System.out.println(Thread.currentThread().getName()+" setting cell3 "+cell3);

        int sum = cell1 + cell2 + cell3;
        System.out.println(Thread.currentThread().getName()+" calc sum "+sum);
        System.out.println(sum);
        return sum;
    }
}
