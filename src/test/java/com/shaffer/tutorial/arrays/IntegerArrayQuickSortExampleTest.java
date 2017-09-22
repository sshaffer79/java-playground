package com.shaffer.tutorial.arrays;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class IntegerArrayQuickSortExampleTest {
    @Test
    public void testPivotPositionZero() {
        //Given
        List<Integer> testArray = Arrays.asList(0,1,0,2,1,2);
        int pivotPosition = 0;

        //When
        IntegerArrayQuickSortExample.sort(testArray, pivotPosition);

        //Then
        assertThat(testArray.get(0), is(0));
        assertThat(testArray.get(1), is(1));
        assertThat(testArray.get(2), is(0));
        assertThat(testArray.get(3), is(2));
        assertThat(testArray.get(4), is(1));
        assertThat(testArray.get(5), is(2));
    }

    @Test
    public void testPivotPositionTooLarge() {
        //Given
        List<Integer> testArray = Arrays.asList(0,1,0,2,1,2);
        int pivotPosition = 7;

        //When
        IntegerArrayQuickSortExample.sort(testArray, pivotPosition);

        //Then
        assertThat(testArray.get(0), is(0));
        assertThat(testArray.get(1), is(1));
        assertThat(testArray.get(2), is(0));
        assertThat(testArray.get(3), is(2));
        assertThat(testArray.get(4), is(1));
        assertThat(testArray.get(5), is(2));
    }

    @Test
    public void testSortWithSimpleArray() {
        //Given
        List<Integer> testArray = Arrays.asList(2,1,0);
        int pivotPosition = 1;

        //When
        IntegerArrayQuickSortExample.sort(testArray, pivotPosition);

        //Then
        assertThat(testArray.get(0), is(0));
        assertThat(testArray.get(1), is(1));
        assertThat(testArray.get(2), is(2));
    }

    @Test
    public void testQuickSortWithArrayOfDuplicates() {
        //Given
        List<Integer> testArray = Arrays.asList(0,1,0,2,1,2);

        //When
        IntegerArrayQuickSortExample.quickSort(testArray);

        //Then
        assertThat(testArray.get(0), is(0));
        assertThat(testArray.get(1), is(0));
        assertThat(testArray.get(2), is(1));
        assertThat(testArray.get(3), is(1));
        assertThat(testArray.get(4), is(2));
        assertThat(testArray.get(5), is(2));
    }
}
