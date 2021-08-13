package demo.synchronization;

import java.util.concurrent.TimeUnit;

/*
This won't work without synchronized,as there is no guarantee as to when, if ever,
the background thread will see the change in the value of stopRequested made by the main thread.
Each thread entering a synchronized method or block sees the effects of all previous
modifications that were guarded by the same lock.
 */
public class SynchronizedExample {

    private static boolean stopRequested;

    public static void main(String[] args) throws InterruptedException {

        Thread backgroundThread = new Thread(
            () -> {
                int i = 0;
                while (!isStopRequested())
                    i++;
            });
        backgroundThread.start();

        TimeUnit.MILLISECONDS.sleep(1000);

        System.out.println("starting to request to stop the Thread");
        stopRequested = true;
        System.out.println("request accepted to stop the Thread");

    }

    private synchronized static boolean isStopRequested() {
        return stopRequested;
    }
}
