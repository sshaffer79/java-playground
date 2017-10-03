package com.shaffer.service;

import com.shaffer.model.Digit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class NumberTransformation {
    private static final Logger logger = LoggerFactory.getLogger(NumberTransformation.class);

    public static String getTextForNumber(int number) {
        if (number == 0) {
            return "Zero";
        }
        //Run DigitCalculation until all digits are found
        BigDecimal bigDecimalNumber = new BigDecimal(number).setScale(0);
        List<Digit> digitList = new ArrayList<>();

        while (bigDecimalNumber.intValue() > 0) {
            logger.debug("Number being worked on is currently " + bigDecimalNumber.toPlainString());
            Digit digit = DigitCalculation.getHighestDigit(bigDecimalNumber.intValue());
            digitList.add(digit);

            BigDecimal digitalToSubtract = new BigDecimal(digit.getValue())
                    .setScale(0)
                    .scaleByPowerOfTen(digit.getDigitPosition().getDepth());
            logger.debug("Subtracting {} from {} ", digitalToSubtract.toPlainString(), bigDecimalNumber.toPlainString());
            bigDecimalNumber = bigDecimalNumber.subtract(digitalToSubtract);
        }
        for (Digit digit : digitList) {
            logger.info(digit.toString());
        }

        // Cycle through digits to create string

        return null;
    }
}
