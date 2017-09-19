package com.shaffer.concurrency.singleton;

import com.shaffer.common.SingletonObject;

public class SingletonFactory {
    private static final SingletonObject object = new SingletonObject(100);

    public static SingletonObject getObject() {
        return object;
    }
}
