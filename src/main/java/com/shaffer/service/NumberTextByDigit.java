package com.shaffer.service;

import com.shaffer.model.Digit;
import com.shaffer.model.DigitPosition;
import com.shaffer.model.NumberText;

import java.util.Arrays;
import java.util.List;

/**
 * Class responsible for determining what NumberText should be available for a given Digit
 */
public class NumberTextByDigit {
    public static final List<DigitPosition> positionsNotUsingTens;

    static {
        positionsNotUsingTens = Arrays.asList(
                DigitPosition.Single, DigitPosition.Hundreth,
                DigitPosition.Thousandth, DigitPosition.HundredThousand,
                DigitPosition.Millionth, DigitPosition.HundredMillionth,
                DigitPosition.Billionth
        );
    }

    /**
     * Retrieve a String representation of a NumberText enum value based off the Digit passed in. Supports
     * 1 - 9 and multiples of 10 up to 90.
     * @param digit The Digit with the value and position to be used
     * @return String representation of the NumberText value
     */
    public static String get(Digit digit) {
        NumberText numberText = null;
        if (positionsNotUsingTens.contains(digit.getDigitPosition())) {
            switch(digit.getValue()) {
                case 1:
                    numberText = NumberText.one;
                    break;
                case 2:
                    numberText = NumberText.two;
                    break;
                case 3:
                    numberText = NumberText.three;
                    break;
                case 4:
                    numberText = NumberText.four;
                    break;
                case 5:
                    numberText = NumberText.five;
                    break;
                case 6:
                    numberText = NumberText.six;
                    break;
                case 7:
                    numberText = NumberText.seven;
                    break;
                case 8:
                    numberText = NumberText.eight;
                    break;
                case 9:
                    numberText = NumberText.nine;
                    break;
                default:
                    numberText = NumberText.zero;
                    break;
            }
        } else {
            switch(digit.getValue()) {
                case 1:
                    numberText = NumberText.ten;
                    break;
                case 2:
                    numberText = NumberText.twenty;
                    break;
                case 3:
                    numberText = NumberText.thirty;
                    break;
                case 4:
                    numberText = NumberText.forty;
                    break;
                case 5:
                    numberText = NumberText.fifty;
                    break;
                case 6:
                    numberText = NumberText.sixty;
                    break;
                case 7:
                    numberText = NumberText.seventy;
                    break;
                case 8:
                    numberText = NumberText.eighty;
                    break;
                case 9:
                    numberText = NumberText.ninety;
                    break;
                default:
                    break;
            }
        }

        return numberText.toString();
    }

    /**
     * Used to get the text representating of Digits between 10 and 19
     * @param digit The digit object
     * @return A String representing the text found
     */
    public static String getTeen(Digit digit) {
        NumberText numberText = null;
        switch(digit.getValue()) {
            case 1:
                numberText = NumberText.eleven;
                break;
            case 2:
                numberText = NumberText.twelve;
                break;
            case 3:
                numberText = NumberText.thirteen;
                break;
            case 4:
                numberText = NumberText.fourteen;
                break;
            case 5:
                numberText = NumberText.fifteen;
                break;
            case 6:
                numberText = NumberText.sixteen;
                break;
            case 7:
                numberText = NumberText.seventeen;
                break;
            case 8:
                numberText = NumberText.eighteen;
                break;
            case 9:
                numberText = NumberText.nineteen;
                break;
            default:
                numberText = NumberText.ten;
                break;
        }

        return numberText.toString();
    }

    /**
     * Checks to see whether a Digit is between 11 - 19
     * @param digit Digit to be used to see if it should be treated as a teen
     * @return True if in the range of 11 - 19
     */
    public static boolean isATeen(Digit digit) {
        if (digit.getValue() == 1 && !positionsNotUsingTens.contains(digit.getDigitPosition())) {
            if (digit.getNext() != null
                    && digit.getNext().getDigitPosition().ordinal() == digit.getDigitPosition().ordinal() - 1) {
               return true;
            }
        }
        return false;
    }

    /**
     * Determines whether the current Digit should be using the text 'million' after it
     * @param digit The Digit being evaluated
     * @return True if the Digit value is at the position where it should have the text after it
     */
    public static boolean needsMillionText(Digit digit) {
        return needsLargeNumberText(digit, DigitPosition.Millionth, DigitPosition.HundredMillionth);
    }

    /**
     * Determines whether the current Digit should be using the text 'thousand' after it
     * @param digit The Digit being evaluated
     * @return True if the Digit value is at the position where it should have the text after it
     */
    public static boolean needsThousandText(Digit digit) {
        return needsLargeNumberText(digit, DigitPosition.Thousandth, DigitPosition.HundredThousand);
    }

    /**
     * Determines whether text should be used for a provided Digit given a lower and upper position and also whether tha
     * Digit has a next value in the same range.
     * @param digit The Digit being evaluated
     * @param lowerPosition The lowest position for a digit to be evaluated
     * @param upperPosition The upper position for a digit to be evaluated
     * @return True if text should be used
     */
    public static boolean needsLargeNumberText(Digit digit, DigitPosition lowerPosition, DigitPosition upperPosition) {
        if (digit.getDigitPosition().ordinal() <= upperPosition.ordinal()
                && digit.getDigitPosition().ordinal() >= lowerPosition.ordinal()) {
            if (digit.getNext() == null
                    || digit.getNext().getDigitPosition().ordinal() < lowerPosition.ordinal()) {
                return true;
            }
        }
        return false;
    }
}
