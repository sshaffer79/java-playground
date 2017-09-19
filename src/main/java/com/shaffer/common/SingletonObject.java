package com.shaffer.common;

import java.util.Objects;

public class SingletonObject {
    private int value = 100;

    public SingletonObject(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SingletonObject that = (SingletonObject) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("SingletonObject{");
        sb.append("value=").append(value);
        sb.append('}');
        return sb.toString();
    }
}
