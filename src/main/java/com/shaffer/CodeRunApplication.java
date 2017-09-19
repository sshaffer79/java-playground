package com.shaffer;

import com.shaffer.common.SingletonObject;
import com.shaffer.concurrency.singleton.SingletonFactory;
import com.shaffer.concurrency.singleton.SingletonLockingFactory;
import com.shaffer.concurrency.threading.ExecutorInvokeAll;
import com.shaffer.concurrency.threading.ExecutorPolling;

import java.util.concurrent.ExecutionException;

public class CodeRunApplication {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.exit(1);
        }

        System.out.println("Running process " + args[0]);
        switch (args[0]) {
            case "Singleton": {
                SingletonObject singletonObject1 = SingletonFactory.getObject();
                SingletonObject singletonObject2 = SingletonFactory.getObject();

                compareObjects(singletonObject1, singletonObject2);

                break;
            }

            case "SingletonLocking": {
                SingletonObject singletonObject1 = SingletonLockingFactory.getObject(200);
                SingletonObject singletonObject2 = SingletonLockingFactory.getObject(200);

                compareObjects(singletonObject1, singletonObject2);
                break;
            }

            case "ExecutorPolling": {
                ExecutorPolling.start();

                try {
                    ExecutorPolling.run(6);
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    ExecutorPolling.shutdown();
                }

                break;
            }

            case "ExecutorInvokeAll": {
                ExecutorInvokeAll.start();

                try {
                    ExecutorInvokeAll.run(6);
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    ExecutorInvokeAll.shutdown();
                }

                break;
            }

            default: {
                System.out.println("Command argument not recognized");

                break;
            }
        }
    }

    public static void compareObjects(Object object1, Object object2) {
        if (object1 == object2) {
            System.out.println("Objects do match!");
            System.exit(0);
        } else {
            System.out.println("Objects do not match so not a singleton");
            System.exit(1);
        }
    }
}
