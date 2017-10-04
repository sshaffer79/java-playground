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
    public void testTeen() {
        Digit digit = new Digit(1, DigitPosition.Tenth);
        digit.setNext(new Digit(4, DigitPosition.Single));

        String text = NumberTextByDigit.get(digit);

        assertThat(text, is("fourteen"));
    }

    @Test
    public void testEighty() {
        Digit digit = new Digit(8, DigitPosition.Tenth);

        String text = NumberTextByDigit.get(digit);

        assertThat(text, is("eighty"));
    }
}
