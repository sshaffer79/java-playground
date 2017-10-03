package com.shaffer.service;

import org.junit.Test;

import java.math.BigDecimal;
import java.text.DecimalFormat;

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
    public void test() {
        BigDecimal newValue = new BigDecimal(5);
        newValue = newValue.scaleByPowerOfTen(0);
        DecimalFormat df = new DecimalFormat("0");
        System.out.print(df.format(newValue.doubleValue()));
    }
}
