package demo.forkjoin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

/**
 * Cannot return a value using RecursiveAction
 */
public class CustomRecursiveAction extends RecursiveAction {

    private int[] arr;

    private static final int THRESHOLD = 4;

    public CustomRecursiveAction(int[] arr) {
        this.arr = arr;
    }

    @Override
    protected void compute() {

        if (arr.length > THRESHOLD) {
            ForkJoinTask.invokeAll(createSubtasks());
        } else {
            processing(arr);
        }
    }

    private Collection<CustomRecursiveAction> createSubtasks() {

        List<CustomRecursiveAction> dividedTasks = new ArrayList<>();

        dividedTasks.add(new CustomRecursiveAction(Arrays.copyOfRange(arr, 0, arr.length / 2)));
        dividedTasks.add(new CustomRecursiveAction(Arrays.copyOfRange(arr, arr.length / 2, arr.length)));

        return dividedTasks;
    }

    private void processing(int[] arr) {
        int sum = Arrays.stream(arr).map(a -> a * 2).sum();
        System.out.println("This result - (" + sum + ") - was processed by " + Thread.currentThread()
            .getName());
    }
}
