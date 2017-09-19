package com.shaffer.concurrency.threading;

import com.shaffer.common.TimedObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorInvokeAll {
    public static ExecutorService executorService;

    public static void start() {
        executorService = Executors.newCachedThreadPool();
    }

    public static void run(int numberOfTasks) throws ExecutionException, InterruptedException {
        List<TimedObjectCallable> callables = new ArrayList<>();
        for (int callableCtr = 0; callableCtr < numberOfTasks; callableCtr++) {
            callables.add(new TimedObjectCallable(callableCtr));
        };

        List<Future<TimedObject>> futures = executorService.invokeAll(callables);
        for (Future future : futures) {
            TimedObject object = (TimedObject) future.get();
            System.out.println(object.toString());
        }
    }

    public static void shutdown() {
        executorService.shutdown();
    }
}
