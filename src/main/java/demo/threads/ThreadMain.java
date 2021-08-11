package demo.threads;

public class ThreadMain {

    public static void main(String[] args) {
        Thread t1 = new Thread( new SampleUsingRunnableInterface());
        t1.start();

        SampleUsingThreadClass t2 = new SampleUsingThreadClass();
        t2.start();
    }
}
