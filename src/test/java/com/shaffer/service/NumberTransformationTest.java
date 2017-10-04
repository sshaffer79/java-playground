package com.shaffer.service;

import com.shaffer.model.Digit;
import com.shaffer.model.DigitPosition;
import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

public class NumberTransformationTest {
    @Test
    public void testZero() {
        int value = 0;
        String text = NumberTransformation.getTextForNumber(value);
        assertThat(text, is("Zero"));
    }


    @Test
    public void testFive() {
        int value = 5;
        String text = NumberTransformation.getTextForNumber(value);
        assertThat(text, is("Five"));
    }

    @Test
    public void testTeens() {
        int value = 13;
        String text = NumberTransformation.getTextForNumber(value);
        assertThat(text, is("Thirteen"));
    }

    @Test
    public void testEightyFive() {
        int value = 85;
        String text = NumberTransformation.getTextForNumber(value);
        assertThat(text, is("Eighty five"));
    }

    @Test
    public void testThousands() {
        int value = 5237;
        String text = NumberTransformation.getTextForNumber(value);
        assertThat(text, is("Five thousand two hundred and thirty seven"));
    }

    @Test
    public void testTensThousands() {
        int value = 52307;
        String text = NumberTransformation.getTextForNumber(value);
        assertThat(text, is("Fifty two thousand three hundred and seven"));
    }

    @Test
    public void testTensMillions() {
        int value = 50012307;
        String text = NumberTransformation.getTextForNumber(value);
        assertThat(text, is("Fifty million twelve thousand three hundred and seven"));
    }

    @Test
    public void testGetRootDigit() {
        BigDecimal value = new BigDecimal(6).setScale(0);

        Digit digit = NumberTransformation.getRootDigit(value);

        assertThat(digit.size(), is(1));
        assertThat(digit.getValue(), is(6));
        assertThat(digit.getDigitPosition(), is(DigitPosition.Single));
        assertThat(digit.getNext(), is(nullValue()));
    }

    @Test
    public void testGetRootDigitByThousand() {
        BigDecimal value = new BigDecimal(2358).setScale(0);

        Digit digit = NumberTransformation.getRootDigit(value);

        assertThat(digit.size(), is(4));
        assertThat(digit.getValue(), is(2));
        assertThat(digit.getDigitPosition(), is(DigitPosition.Thousandth));
        assertThat(digit.getNext().getValue(), is(3));
        assertThat(digit.getNext().getDigitPosition(), is(DigitPosition.Hundreth));
        assertThat(digit.getNext().getNext().getValue(), is(5));
        assertThat(digit.getNext().getNext().getDigitPosition(), is(DigitPosition.Tenth));
        assertThat(digit.getNext().getNext().getNext().getValue(), is(8));
        assertThat(digit.getNext().getNext().getNext().getDigitPosition(), is(DigitPosition.Single));
    }

    @Test
    public void testGetGetRootDigitByThousandWithZeroIn() {
        BigDecimal value = new BigDecimal(2308).setScale(0);

        Digit digit = NumberTransformation.getRootDigit(value);

        assertThat(digit.size(), is(3));
        assertThat(digit.getValue(), is(2));
        assertThat(digit.getDigitPosition(), is(DigitPosition.Thousandth));
        assertThat(digit.getNext().getValue(), is(3));
        assertThat(digit.getNext().getDigitPosition(), is(DigitPosition.Hundreth));
        assertThat(digit.getNext().getNext().getValue(), is(8));
        assertThat(digit.getNext().getNext().getDigitPosition(), is(DigitPosition.Single));
    }

    @Test
    public void test() {
        Digit digit = NumberTransformation.getRootDigit(new BigDecimal(4000));

        DigitToText.printDigits(digit);
    }
}
