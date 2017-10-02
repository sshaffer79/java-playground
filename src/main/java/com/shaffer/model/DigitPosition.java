package com.shaffer.model;

public enum DigitPosition {
    Single(1, 1), Tenth(2, 10), Hundreth(3, 100), Thousandth(4, 1000), Millionth(6, 1000000), Billionth(8, 1000000000);

    private int position;
    private int multiplier;

    DigitPosition(int position, int multiplier) {
        this.position = position;
        this.multiplier = multiplier;
    }

    public int getPosition() {
        return this.position;
    }

    public int getMultiplier() {
        return this.multiplier;
    }
}
