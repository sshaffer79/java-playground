package com.shaffer.tutorial.arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;

public class IntegerArrayQuickSortExample {
    private static final Logger logger = LoggerFactory.getLogger( IntegerArrayQuickSortExample.class);

    public static void quickSort(List<Integer> array) {
        for (int counter = 0; counter < array.size(); counter++) {
            sort(array, counter);
        }
    }

    public static void sort(List<Integer> array, int pivotPosition) {
        if (pivotPosition == 0 || pivotPosition > array.size() - 1) {
            return;
        }
        printArray(array);

        Integer pivotValue = array.get(pivotPosition);
        if (logger.isDebugEnabled()) {
            logger.debug("Pivot value is: " + pivotValue);
        }

        logger.debug("Sort by smalled then pivot now");

        for (int outerCounter = 0; outerCounter < array.size(); outerCounter++) {
            for (int innerCounter = outerCounter + 1; innerCounter < array.size(); innerCounter++) {
                int value = array.get(innerCounter);
                if (logger.isDebugEnabled()) {
                    logger.debug("Array value is: " + value);
                }
                if (value < pivotValue) {
                    if (logger.isDebugEnabled()) {
                        logger.debug("Values have been swapped for outer [{}] and inner[{}]", outerCounter, innerCounter);
                    }
                    if (array.get(outerCounter) > value) {
                        Collections.swap(array, outerCounter, innerCounter);
                    }
                    break;
                }
            }
        }
        printArray(array);

        logger.debug("Sort by larger then pivot now");

        for (int outerCounter = array.size() - 1; outerCounter > 0 && array.get(outerCounter) >= pivotValue; outerCounter--) {
            for (int innerCounter = outerCounter - 1; innerCounter > 0 && array.get(innerCounter) >= pivotValue; innerCounter--) {
                int value = array.get(innerCounter);
                if (logger.isDebugEnabled()) {
                    logger.debug("Array value is: " + value);
                }
                if (value > pivotValue) {
                    if (logger.isDebugEnabled()) {
                        logger.debug("Values have been swapped for outer [{}] and inner[{}]", outerCounter, innerCounter);
                    }
                    if (array.get(outerCounter) > value) {
                        Collections.swap(array, outerCounter, innerCounter);
                    }
                    break;
                }
            }
        }
        printArray(array);

        logger.debug("Done");
    }

    public static void printArray(List<Integer> array) {
        if (logger.isDebugEnabled()) {
            boolean isFirst = true;
            StringBuilder stringBuilder = new StringBuilder();
            for (Integer integer : array) {
                if (isFirst) {
                    isFirst = false;
                } else {
                    stringBuilder.append(",");
                }
                stringBuilder.append(integer.intValue());
            }
            logger.debug(stringBuilder.toString());
        }
    }
}
