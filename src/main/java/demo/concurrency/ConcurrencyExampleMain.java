package demo.concurrency;

public class ConcurrencyExampleMain {

    public static void main(String[] args) {
        SampleRunnable runnable1 = new SampleRunnable();
        //Thread t1 = new Thread(runnable1);
        //t1.start();
        //System.out.println(runnable1.getSum());

        SampleCallable callable1 = new SampleCallable();
        try {
            int returnedSum = callable1.call();
            System.out.println(returnedSum);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
