package com.shaffer.utils;

import java.util.Random;

public class RandomIntGenerator {
    private static final Random rand = new Random();

    public static int generate() {
        int randomNum = rand.nextInt((10 - 1) + 1) + 1;
        return randomNum;
    }
}
