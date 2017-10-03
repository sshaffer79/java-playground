package com.shaffer.service;

import com.shaffer.model.Digit;
import com.shaffer.model.DigitPosition;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DigitCalculationTest {

    @Test
    public void testZero() {
        int value = 0;
        Digit digit = DigitCalculation.getHighestDigit(value);

        assertThat(digit.getDigitPosition(), is(DigitPosition.Single));
        assertThat(digit.getValue(), is(0));
    }

    @Test
    public void testHundreds() {
        int value = 335;
        Digit digit = DigitCalculation.getHighestDigit(value);

        assertThat(digit.getDigitPosition(), is(DigitPosition.Hundreth));
        assertThat(digit.getValue(), is(3));
    }

    @Test
    public void testHundredsThousand() {
        int value = 310035;
        Digit digit = DigitCalculation.getHighestDigit(value);

        assertThat(digit.getDigitPosition(), is(DigitPosition.HundredThousand));
        assertThat(digit.getValue(), is(3));
    }

    @Test
    public void testTensMillion() {
        int value = 51901345;
        Digit digit = DigitCalculation.getHighestDigit(value);

        assertThat(digit.getDigitPosition(), is(DigitPosition.TenMillionth));
        assertThat(digit.getValue(), is(5));
    }
}
