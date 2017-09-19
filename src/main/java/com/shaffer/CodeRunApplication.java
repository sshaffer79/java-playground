package com.shaffer;

import com.shaffer.common.SingletonObject;
import com.shaffer.concurrency.singleton.SingletonFactory;
import com.shaffer.concurrency.singleton.SingletonLockingFactory;

public class CodeRunApplication {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.exit(1);
        }

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
