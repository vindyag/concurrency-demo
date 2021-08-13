package demo.forkjoin;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;

public class ForkJoinMain {

    public static ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
    public static ExecutorService executor = Executors.newWorkStealingPool();

    public static void main(String[] args) {
        int[] arr = {2, 4, 5, 7, 8, 9, 11};
        CustomRecursiveAction customRecursiveAction = new CustomRecursiveAction(arr);
        forkJoinPool.execute(customRecursiveAction);
        customRecursiveAction.join();

        CustomRecursiveTask customRecursiveTask = new CustomRecursiveTask(arr);
        forkJoinPool.execute(customRecursiveTask);
        int result = customRecursiveTask.join();
        System.out.println(result);
    }
}
