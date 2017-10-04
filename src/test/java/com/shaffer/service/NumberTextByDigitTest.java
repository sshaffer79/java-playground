package com.shaffer.service;

import com.shaffer.model.Digit;
import com.shaffer.model.DigitPosition;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class NumberTextByDigitTest {
    @Test
    public void testSingle() {
        Digit digit = new Digit(1, DigitPosition.Single);

        String text = NumberTextByDigit.get(digit);

        assertThat(text, is("one"));
    }

    @Test
    public void testAnotherSingle() {
        Digit digit = new Digit(6, DigitPosition.Single);

        String text = NumberTextByDigit.get(digit);

        assertThat(text, is("six"));
    }

    @Test
    public void testTen() {
        Digit digit = new Digit(1, DigitPosition.Tenth);

        String text = NumberTextByDigit.get(digit);

        assertThat(text, is("ten"));
    }

    @Test
    public void testEighty() {
        Digit digit = new Digit(8, DigitPosition.Tenth);

        String text = NumberTextByDigit.get(digit);

        assertThat(text, is("eighty"));
    }

    @Test
    public void testGetTeen() {
        Digit digit = new Digit(4, DigitPosition.Single);

        String text = NumberTextByDigit.getTeen(digit);

        assertThat(text, is("fourteen"));
    }

    @Test
    public void testGetTeenWithTen() {
        Digit digit = new Digit(1, DigitPosition.Tenth);

        boolean value = NumberTextByDigit.isATeen(digit);

        assertThat(value, is(false));
    }

    @Test
    public void testGetTeenWithFifteen() {
        Digit digit = new Digit(1, DigitPosition.Tenth,
                new Digit(5, DigitPosition.Single));

        boolean value = NumberTextByDigit.isATeen(digit);

        assertThat(value, is(true));
    }

    @Test
    public void testGetTeenWithThousand() {
        Digit digit = new Digit(1, DigitPosition.Thousandth,
                new Digit(5, DigitPosition.Single));

        boolean value = NumberTextByDigit.isATeen(digit);

        assertThat(value, is(false));
    }

    @Test
    public void testNeedsThousandTextIsTrue() {
        Digit digit = new Digit(1, DigitPosition.Thousandth);

        boolean value = NumberTextByDigit.needsLargeNumberText(digit,
                DigitPosition.Thousandth, DigitPosition.HundredThousand);

        assertThat(value, is(true));
    }

    @Test
    public void testNeedsThousandTextIsFalseAsHundred() {
        Digit digit = new Digit(1, DigitPosition.Hundreth);

        boolean value = NumberTextByDigit.needsLargeNumberText(digit,
                DigitPosition.Thousandth, DigitPosition.HundredThousand);

        assertThat(value, is(false));
    }

    @Test
    public void testNeedsThousandTextIsFalseDueToMultipleThousandsDigits() {
        Digit digit = new Digit(1, DigitPosition.HundredThousand,
                new Digit(2, DigitPosition.Thousandth));

        boolean value = NumberTextByDigit.needsLargeNumberText(digit,
                DigitPosition.Thousandth, DigitPosition.HundredThousand);

        assertThat(value, is(false));
    }
}
