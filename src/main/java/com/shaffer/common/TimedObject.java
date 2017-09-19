package com.shaffer.common;

import java.util.Calendar;
import java.util.Objects;

public class TimedObject {
    private int id;
    private long timestamp = Calendar.getInstance().getTimeInMillis();

    public TimedObject(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimedObject that = (TimedObject) o;
        return id == that.id &&
                timestamp == that.timestamp;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, timestamp);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("TimedObject{");
        sb.append("id=").append(id);
        sb.append(", timestamp=").append(timestamp);
        sb.append('}');
        return sb.toString();
    }
}
