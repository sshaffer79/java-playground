package com.shaffer.concurrency.threading;

import com.shaffer.common.TimedObject;
import com.shaffer.utils.RandomIntGenerator;

import java.util.Calendar;

public class TimedObjectCallable implements ExecutorCallable {
    public TimedObject timedObject;

    public TimedObjectCallable(int id) {
        timedObject = new TimedObject(id);
    }

    @Override
    public TimedObject call() throws Exception {
        int sleepInterval = RandomIntGenerator.generate();
        System.out.println("Sleep interval [" + sleepInterval + "] for id " + timedObject.getId());
        Thread.sleep(sleepInterval);
        timedObject.setTimestamp(Calendar.getInstance().getTimeInMillis());
        return timedObject;
    }
}
