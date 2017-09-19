package com.shaffer.concurrency.threading;

import com.shaffer.common.TimedObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorPolling {
    public static ExecutorService executorService;

    public static void start() {
        executorService = Executors.newCachedThreadPool();
    }

    public static void run(int numberOfTasks) throws ExecutionException, InterruptedException {
        CompletionService<TimedObject> completionService = new ExecutorCompletionService<TimedObject>(executorService);

        List<Future<TimedObject>> futures = new ArrayList<>();
        for (int callableCtr = 0; callableCtr < numberOfTasks; callableCtr++) {
            futures.add(completionService.submit(new TimedObjectCallable(callableCtr)));
        }
        int callablesLeft = numberOfTasks;

        while (callablesLeft > 0) {
            Future<TimedObject> p = completionService.poll();
            if (p != null) {
                TimedObject timedObject = p.get();
                System.out.println(timedObject.toString());
                callablesLeft--;
            }
        }
    }

    public static void shutdown() {
        executorService.shutdown();
    }
}
