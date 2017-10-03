package com.shaffer.service;

import com.shaffer.model.Digit;
import com.shaffer.model.DigitPosition;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

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
    public void testTeens() {
        int value = 13;
        String text = NumberTransformation.getTextForNumber(value);
        assertThat(text, is("Thirteen"));
    }

    @Test
    public void testEight5() {
        int value = 85;
        String text = NumberTransformation.getTextForNumber(value);
        assertThat(text, is("Eighty Five"));
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
    public void testGetDigitListBySingle() {
        BigDecimal value = new BigDecimal(6).setScale(0);

        List<Digit> digitList = NumberTransformation.getDigitList(value);

        assertThat(digitList.size(), is(1));
        assertThat(digitList.get(0).getValue(), is(6));
        assertThat(digitList.get(0).getDigitPosition(), is(DigitPosition.Single));
    }

    @Test
    public void testGetDigitListByThousand() {
        BigDecimal value = new BigDecimal(2358).setScale(0);

        List<Digit> digitList = NumberTransformation.getDigitList(value);

        assertThat(digitList.size(), is(4));
        assertThat(digitList.get(0).getValue(), is(2));
        assertThat(digitList.get(0).getDigitPosition(), is(DigitPosition.Thousandth));
        assertThat(digitList.get(1).getValue(), is(3));
        assertThat(digitList.get(1).getDigitPosition(), is(DigitPosition.Hundreth));
        assertThat(digitList.get(2).getValue(), is(5));
        assertThat(digitList.get(2).getDigitPosition(), is(DigitPosition.Tenth));
        assertThat(digitList.get(3).getValue(), is(8));
        assertThat(digitList.get(3).getDigitPosition(), is(DigitPosition.Single));
    }

    @Test
    public void testGetDigitListByThousandWithZeroIn() {
        BigDecimal value = new BigDecimal(2308).setScale(0);

        List<Digit> digitList = NumberTransformation.getDigitList(value);

        assertThat(digitList.size(), is(3));
        assertThat(digitList.get(0).getValue(), is(2));
        assertThat(digitList.get(0).getDigitPosition(), is(DigitPosition.Thousandth));
        assertThat(digitList.get(1).getValue(), is(3));
        assertThat(digitList.get(1).getDigitPosition(), is(DigitPosition.Hundreth));
        assertThat(digitList.get(2).getValue(), is(8));
        assertThat(digitList.get(2).getDigitPosition(), is(DigitPosition.Single));
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
        Digit digit = NumberTransformation.getRootDigit(new BigDecimal(713423534));

        System.out.println(digit.toString());

        Digit currentDigit = digit;
        StringBuilder stringBuilder = new StringBuilder();
        while (currentDigit != null) {
            stringBuilder.append(currentDigit.getValue()).append(" ");
            currentDigit = currentDigit.getNext();
        }
        System.out.println(stringBuilder.toString());
        System.out.println(digit.size());
    }
}
