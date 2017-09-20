package com.shaffer.concurrency.threading;

import java.util.concurrent.*;

public class ExecutorScheduler {
    public static ScheduledExecutorService executorService;

    public static void start() {
        executorService = Executors.newScheduledThreadPool(1);
    }

    public static void run() throws ExecutionException, InterruptedException {
        ScheduledFuture scheduledFuture = executorService.schedule(new TimedObjectCallable(1), 10, TimeUnit.SECONDS);

        System.out.println(scheduledFuture.get().toString());
    }

    public static void shutdown() {
        executorService.shutdown();
    }
}
