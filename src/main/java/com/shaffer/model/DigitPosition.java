package com.shaffer.model;

public enum DigitPosition {
    Single(0), Tenth(1), Hundreth(2), Thousandth(3), TenThousandth(4), HundredThousand(5),
    Millionth(6), TenMillionth(7), HundredMillionth(8), Billionth(9);

    private int depth;

    DigitPosition(int depth) {
        this.depth = depth;
    }

    public int getDepth() {
        return this.depth;
    }

    public static DigitPosition getByDepth(int depth) {
        DigitPosition returnPosition = Single;
        for (DigitPosition digitPosition : DigitPosition.values()) {
          if (depth == digitPosition.getDepth()) {
              returnPosition = digitPosition;
          }
        }
        return returnPosition;
    }
}
