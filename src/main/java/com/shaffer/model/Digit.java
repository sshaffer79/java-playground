package com.shaffer.model;

public class Digit {
    private int value;
    private DigitPosition digitPosition;
    private Digit next;

    public Digit() {
    }

    public Digit(int value, DigitPosition digitPosition) {
        this.value = value;
        this.digitPosition = digitPosition;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public DigitPosition getDigitPosition() {
        return digitPosition;
    }

    public void setDigitPosition(DigitPosition digitPosition) {
        this.digitPosition = digitPosition;
    }

    public Digit getNext() {
        return next;
    }

    public void setNext(Digit next) {
        this.next = next;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Digit{");
        sb.append("value=").append(value);
        sb.append(", digitPosition=").append(digitPosition);
        sb.append(", next=").append(next);
        sb.append('}');
        return sb.toString();
    }
}
