package com.shaffer.concurrency.singleton;

import com.shaffer.common.SingletonObject;

public class SingletonLockingFactory {
    private static SingletonObject object;

    public static SingletonObject getObject(int value) {
        if (object == null) {
            synchronized (SingletonObject.class) {
                object = new SingletonObject(value);
            }
        }
        return object;
    }
}
