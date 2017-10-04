package com.shaffer.service;

import com.shaffer.model.Digit;
import com.shaffer.model.DigitPosition;
import com.shaffer.model.NumberText;

import java.util.Arrays;
import java.util.List;

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

    public static String get(Digit digit) {
        StringBuilder numberTextBuilder = new StringBuilder();
        if (positionsNotUsingTens.contains(digit.getDigitPosition())) {
            switch(digit.getValue()) {
                case 1:
                    numberTextBuilder.append(NumberText.one);
                    break;
                case 2:
                    numberTextBuilder.append(NumberText.two);
                    break;
                case 3:
                    numberTextBuilder.append(NumberText.three);
                    break;
                case 4:
                    numberTextBuilder.append(NumberText.four);
                    break;
                case 5:
                    numberTextBuilder.append(NumberText.five);
                    break;
                case 6:
                    numberTextBuilder.append(NumberText.six);
                    break;
                case 7:
                    numberTextBuilder.append(NumberText.seven);
                    break;
                case 8:
                    numberTextBuilder.append(NumberText.eight);
                    break;
                case 9:
                    numberTextBuilder.append(NumberText.nine);
                    break;
                default:
                    numberTextBuilder.append(NumberText.zero);
                    break;
            }
        } else {
            switch(digit.getValue()) {
                case 1:
                    numberTextBuilder.append(NumberText.ten);
                    break;
                case 2:
                    numberTextBuilder.append(NumberText.twenty);
                    break;
                case 3:
                    numberTextBuilder.append(NumberText.thirty);
                    break;
                case 4:
                    numberTextBuilder.append(NumberText.forty);
                    break;
                case 5:
                    numberTextBuilder.append(NumberText.fifty);
                    break;
                case 6:
                    numberTextBuilder.append(NumberText.sixty);
                    break;
                case 7:
                    numberTextBuilder.append(NumberText.seventy);
                    break;
                case 8:
                    numberTextBuilder.append(NumberText.eighty);
                    break;
                case 9:
                    numberTextBuilder.append(NumberText.ninety);
                    break;
                default:
                    break;
            }
        }

        return numberTextBuilder.toString();
    }

    public static String getTeen(Digit digit) {
        StringBuilder numberTextBuilder = new StringBuilder();
        switch(digit.getValue()) {
            case 1:
                numberTextBuilder.append(NumberText.eleven);
                break;
            case 2:
                numberTextBuilder.append(NumberText.twelve);
                break;
            case 3:
                numberTextBuilder.append(NumberText.thirteen);
                break;
            case 4:
                numberTextBuilder.append(NumberText.fourteen);
                break;
            case 5:
                numberTextBuilder.append(NumberText.fifty);
                break;
            case 6:
                numberTextBuilder.append(NumberText.sixteen);
                break;
            case 7:
                numberTextBuilder.append(NumberText.seventeen);
                break;
            case 8:
                numberTextBuilder.append(NumberText.eighteen);
                break;
            case 9:
                numberTextBuilder.append(NumberText.nineteen);
                break;
            default:
                numberTextBuilder.append(NumberText.ten);
                break;
        }

        return numberTextBuilder.toString();
    }

    public static boolean isATeen(Digit digit) {
        if (digit.getValue() == 1 && !positionsNotUsingTens.contains(digit.getDigitPosition())) {
            if (digit.getNext() != null
                    && digit.getNext().getDigitPosition().ordinal() == digit.getDigitPosition().ordinal() - 1) {
               return true;
            }
        }
        return false;
    }

//    public NumberText getLargeNumberText(Digit digit) {
//
//    }
}
