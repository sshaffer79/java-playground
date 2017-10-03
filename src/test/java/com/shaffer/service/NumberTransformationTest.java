package com.shaffer.service;

import com.shaffer.model.Digit;
import com.shaffer.model.DigitPosition;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
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
    public void test() {
        BigDecimal newValue = new BigDecimal(5);
        newValue = newValue.scaleByPowerOfTen(0);
        DecimalFormat df = new DecimalFormat("0");
        System.out.print(df.format(newValue.doubleValue()));
    }
}
