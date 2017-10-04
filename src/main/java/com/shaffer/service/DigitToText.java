package com.shaffer.service;

import com.shaffer.model.Digit;
import com.shaffer.model.DigitPosition;
import com.shaffer.model.NumberText;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

public class DigitToText {
    private static final Logger logger = LoggerFactory.getLogger(DigitToText.class);

    public static final List<DigitPosition> positionsUsingTens;

    static {
        positionsUsingTens = Arrays.asList(
                DigitPosition.Tenth, DigitPosition.TenThousandth, DigitPosition.TenMillionth
        );
    }

    private static final String AND = "and";
    private static final String SPACE = " ";

    /**
     * Transforms a Digit object into a String representation for the Digits stored
     * @param digit The Digit being translated to text
     * @return String represent a Digit and its following digits.
     */
    public static String toString(Digit digit) {
        Digit currentDigit = digit;
        StringBuilder stringBuilder = new StringBuilder();
        Digit previousDigit = null;
        while (currentDigit != null) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append(SPACE);
            }
            if (previousDigit != null) {
                if (currentDigit.getDigitPosition().ordinal() < 2 && previousDigit.getDigitPosition().ordinal() >= 2) {
                    stringBuilder.append(AND).append(SPACE);
                }
            }
            if (NumberTextByDigit.isATeen(currentDigit)) {
                currentDigit = currentDigit.getNext();
                stringBuilder.append(NumberTextByDigit.getTeen(currentDigit));
            } else {
                stringBuilder.append(NumberTextByDigit.get(currentDigit));
            }
            if (currentDigit.getDigitPosition() == DigitPosition.Hundreth ||
                    currentDigit.getDigitPosition() == DigitPosition.HundredThousand ||
                    currentDigit.getDigitPosition() == DigitPosition.HundredMillionth) {
                stringBuilder.append(SPACE).append(NumberText.hundred);
            }

            if (NumberTextByDigit.needsThousandText(currentDigit)) {
                stringBuilder.append(SPACE).append(NumberText.thousand);
            } else if (NumberTextByDigit.needsMillionText(currentDigit)) {
                stringBuilder.append(SPACE).append(NumberText.million);
            }

            previousDigit = currentDigit;
            currentDigit = currentDigit.getNext();
        }
        return stringBuilder.toString();
    }

    /**
     * Prints the the Digit representation to the log
     * @param digit The digit to print to logs
     */
    public static void printDigits(Digit digit) {
        Digit currentDigit = digit;
        StringBuilder stringBuilder = new StringBuilder();
        while (currentDigit != null) {
            stringBuilder.append(currentDigit.getValue()).append(" ");
            currentDigit = currentDigit.getNext();
        }
        logger.info(stringBuilder.toString());
    }
}
