package service.forkjoin.util;

import java.util.concurrent.ForkJoinPool;

public class PoolUtil {

    public static ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
    //new ForkJoinPool(2);

}
