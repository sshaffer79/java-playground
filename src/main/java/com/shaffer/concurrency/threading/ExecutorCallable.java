package com.shaffer.concurrency.threading;

import com.shaffer.common.TimedObject;

import java.util.concurrent.Callable;

public interface ExecutorCallable extends Callable<TimedObject> {

}
