package com.shaffer.service;

import com.shaffer.model.Digit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

public class NumberTransformation {
    private static final Logger logger = LoggerFactory.getLogger(NumberTransformation.class);

    public static String getTextForNumber(int number) {
        if (number == 0) {
            return "Zero";
        }
        BigDecimal bigDecimalNumber = new BigDecimal(number).setScale(0);

        Digit rootDigit = getRootDigit(bigDecimalNumber);
        DigitToText.printDigits(rootDigit);

        String textValue = DigitToText.toString(rootDigit);

        return textValue.substring(0, 1).toUpperCase() + textValue.substring(1);
    }

    /**
     * Creates a Digit object that is a breakdown of all the position of a given BigDecimal
     * @param value A BigDecimal representing a int
     * @return A Digit object with sub objects based off BigDecimal
     */
    protected static Digit getRootDigit(BigDecimal value) {
        Digit rootDigit = null;
        Digit parentDigit = null;

        while (value.intValue() > 0) {
            if (logger.isDebugEnabled()) {
                logger.debug("Number being worked on is currently " + value.toPlainString());
            }
            Digit currentDigit = DigitCalculation.getHighestDigit(value.intValue());

            BigDecimal digitalToSubtract = new BigDecimal(currentDigit.getValue())
                    .setScale(0)
                    .scaleByPowerOfTen(currentDigit.getDigitPosition().getDepth());
            if (logger.isDebugEnabled()) {
                logger.debug("Subtracting {} from {} ", digitalToSubtract.toPlainString(), value.toPlainString());
            }
            value = value.subtract(digitalToSubtract);

            if (rootDigit == null) {
                rootDigit = currentDigit;
                parentDigit = currentDigit;
            } else {
                parentDigit.setNext(currentDigit);
                parentDigit = currentDigit;
            }
        }
        return rootDigit;
    }
}
