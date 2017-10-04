package com.shaffer.model;

/**
 * Representation of one digit of a number and its position in the number. Also contains what the next Digit will
 * be if there is one
 */
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

    public Digit(int value, DigitPosition digitPosition, Digit next) {
        this.value = value;
        this.digitPosition = digitPosition;
        this.next = next;
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

    public int size() {
        if (getNext() != null) {
            return 1 + getNext().size();
        } else {
            return 1;
        }
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
