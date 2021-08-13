package demo.threads;

public class ThreadMain {

    public static void main(String[] args) {
        SampleUsingThreadClass t1 = new SampleUsingThreadClass();
        t1.start();

        SampleUsingRunnableInterface t2 = new SampleUsingRunnableInterface();
        Thread thread = new Thread(t2);
        thread.start();
    }
}
