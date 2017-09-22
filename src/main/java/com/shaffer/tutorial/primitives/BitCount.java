package com.shaffer.tutorial.primitives;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BitCount {
    private static final Logger logger = LoggerFactory.getLogger(BitCount.class);

    public static short countBits(int value) {
        if (logger.isDebugEnabled()) {
            logger.debug("Value is: " + value);
        }
        short bits = 0;
        while (value != 0) {
            bits += (value & 1);
            value >>>= 1;
            if (logger.isDebugEnabled()) {
                logger.debug("Bits are: " + bits);
                logger.debug("Value now is: " + value);
            }
        }
        return bits;
    }
}
