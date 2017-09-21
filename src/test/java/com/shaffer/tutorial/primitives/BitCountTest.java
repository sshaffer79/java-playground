package com.shaffer.tutorial.primitives;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BitCountTest {
    @Test
    public void testZero() {
        //Given
        int testValue = 0;

        //When
        short count = BitCount.countBits(0);

        //Then
        assertThat(count, is((short)0));
    }

    @Test
    public void testSmall() {
        //Given
        int testValue = 0;

        //When
        short count = BitCount.countBits(4);

        //Then
        assertThat(count, is((short)1));
    }

    @Test
    public void testLarge() {
        //Given
        int testValue = 0;

        //When
        short count = BitCount.countBits(1673);

        //Then
        assertThat(count, is((short)5));
    }
}
