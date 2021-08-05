package demo.forkjoin;

import java.util.concurrent.ForkJoinPool;

public class Main {

    public static ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();

    public static void main(String[] args) {
        //CustomRecursiveAction customRecursiveAction = new CustomRecursiveAction("hello world");
        //forkJoinPool.execute(customRecursiveAction);

        int[] arr = {2,4,5,7,8,9,11};
        CustomRecursiveTask customRecursiveTask = new CustomRecursiveTask(arr);
        forkJoinPool.execute(customRecursiveTask);
       int result = customRecursiveTask.join();
        System.out.println(result);
    }
}
