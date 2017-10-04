package com.shaffer.service;

import com.shaffer.model.Digit;
import com.shaffer.model.DigitPosition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Calculates a Digit object and any further Digit objects for a number
 */
public class DigitCalculation {
    private static final Logger logger = LoggerFactory.getLogger(DigitCalculation.class);

    /**
     * Gets a Digit representation of the int
     * @param value The integer to be transformed to a Digit
     * @return Digit representing the int entered
     */
    public static Digit getHighestDigit(int value) {
        return getHighestDigit(value, 0);
    }

    /**
     * Creates a Digit for the depth passed in. Creates all remaining digits as well.
     *
     * @param value The integer to be transformed to a Digit
     * @param depth The depth that the int is currently at
     * @return Digit representing the int entered
     */
    public static Digit getHighestDigit(int value, int depth) {
        if (logger.isDebugEnabled()) {
            logger.debug("Calculating highest digit for {} with current depth of {}", value, depth);
        }
        if (value < 10) {
            DigitPosition digitPosition = DigitPosition.getByDepth(depth);
            return new Digit(value, digitPosition);
        }
        value = value / 10;

        return getHighestDigit(value, depth + 1);
    }
}
