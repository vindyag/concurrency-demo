package demo.forkjoin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * Cannot return a value using RecursiveTask
 */
public class CustomRecursiveTask extends RecursiveTask<Integer> {

    private int[] arr;

    private static final int THRESHOLD = 4;

    public CustomRecursiveTask(int[] arr) {
        this.arr = arr;
    }

    @Override
    protected Integer compute() {

        if (arr.length > THRESHOLD) {

            return ForkJoinTask.invokeAll(createSubtasks())
                .stream()
                .mapToInt(ForkJoinTask::join)
                .sum();

        } else {
            return processing(arr);
        }
    }

    private Collection<CustomRecursiveTask> createSubtasks() {
        List<CustomRecursiveTask> dividedTasks = new ArrayList<>();
        dividedTasks.add(new CustomRecursiveTask(Arrays.copyOfRange(arr, 0, arr.length / 2)));
        dividedTasks.add(new CustomRecursiveTask(Arrays.copyOfRange(arr, arr.length / 2, arr.length)));
        return dividedTasks;
    }

    private Integer processing(int[] arr) {
        return Arrays.stream(arr).map(a -> a * 2).sum();
    }
}
