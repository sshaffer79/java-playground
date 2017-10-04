package com.shaffer.service;

import com.shaffer.model.Digit;
import com.shaffer.model.DigitPosition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DigitCalculation {
    private static final Logger logger = LoggerFactory.getLogger(DigitCalculation.class);

    public static Digit getHighestDigit(int value) {
        return getHighestDigit(value, 0);
    }

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
