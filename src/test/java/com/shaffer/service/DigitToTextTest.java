package com.shaffer.service;

import com.shaffer.model.Digit;
import com.shaffer.model.DigitPosition;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DigitToTextTest {

    @Test
    public void testSingle() {
        Digit digit = new Digit(1, DigitPosition.Single);

        String text = DigitToText.toString(digit);

        assertThat(text, is("one"));

        digit = new Digit(7, DigitPosition.Single);

        text = DigitToText.toString(digit);

        assertThat(text, is("seven"));
    }

    @Test
    public void testTeen() {
        Digit digit = new Digit(1, DigitPosition.Tenth,
                new Digit(8, DigitPosition.Single));

        String text = DigitToText.toString(digit);

        assertThat(text, is("eighteen"));
    }

    @Test
    public void testDoubleDigit() {
        Digit digit = new Digit(8, DigitPosition.Tenth);
        digit.setNext(new Digit(7, DigitPosition.Single));

        String text = DigitToText.toString(digit);

        assertThat(text, is("eighty seven"));
    }

    @Test
    public void testHundred() {
        Digit digit = new Digit(1, DigitPosition.Hundreth);

        String text = DigitToText.toString(digit);

        assertThat(text, is("one hundred"));
    }

    @Test
    public void testTenThousand() {
        Digit digit = new Digit(1, DigitPosition.TenThousandth);

        String text = DigitToText.toString(digit);

        assertThat(text, is("ten thousand"));
    }

    @Test
    public void testTenThousandAndTwentyThree() {
        Digit digit = new Digit(1, DigitPosition.TenThousandth,
                new Digit(2, DigitPosition.Tenth,
                        new Digit(3, DigitPosition.Single)));

        String text = DigitToText.toString(digit);

        assertThat(text, is("ten thousand and twenty three"));
    }

    @Test
    public void testDigitInHundred() {
        Digit rootDigit = new Digit(6, DigitPosition.Hundreth);
        Digit tenth = new Digit(3, DigitPosition.Tenth);
        Digit single = new Digit(5, DigitPosition.Single);
        tenth.setNext(single);
        rootDigit.setNext(tenth);

        String text = DigitToText.toString(rootDigit);

        assertThat(text, is("six hundred and thirty five"));
    }

    @Test
    public void testDigitInThousand() {
        Digit rootDigit = new Digit(8, DigitPosition.Thousandth);
        Digit tenth = new Digit(3, DigitPosition.Hundreth);
        Digit single = new Digit(5, DigitPosition.Single);
        tenth.setNext(single);
        rootDigit.setNext(tenth);

        String text = DigitToText.toString(rootDigit);

        assertThat(text, is("eight thousand three hundred and five"));
    }

    @Test
    public void testDigitInHundredsOfThousand() {
        Digit rootDigit = new Digit(8, DigitPosition.HundredThousand,
                new Digit(3, DigitPosition.TenThousandth,
                        new Digit(7, DigitPosition.Thousandth,
                                new Digit(1, DigitPosition.Hundreth,
                                        new Digit(9, DigitPosition.Tenth,
                                            new Digit(5, DigitPosition.Single))))));

        String text = DigitToText.toString(rootDigit);

        assertThat(text, is("eight hundred thirty seven thousand one hundred and ninety five"));
    }
}
