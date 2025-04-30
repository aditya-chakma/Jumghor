package com.iAxis.jumghor.utils.security;

import java.security.SecureRandom;

/**
 * @author aditya.chakma
 * @since 24 Apr, 2025 3:16 PM
 */

/**
 * This is an implementation of Twitters Snowflake algorithm,
 * a UUID generator in distributed system
 */
public final class RandomGenerator {

    public enum GeneratorLen {
        L16(16),
        L32(32),
        L64(64);

        private final int len;

        GeneratorLen(int len) {
            this.len = len;
        }

        public int getLen() {
            return len;
        }
    }

    private static volatile long sequence = 0L;
    private static volatile long lastMillis = -1L;

    private static final long MILLIS_EPOCH = 1745660566448L;
    private static final long MAX_TIMESTAMP = (1L << 41) - 1;
    private static final int TIMESTAMP_BITS = 41;
    private static final int SERVER_ID_BITS = 10;
    private static final int SEQUENCE_BITS = 12;
    private static final int SERVER_ID_MASK = (1 << SERVER_ID_BITS) - 1;
    private static final int SEQUENCE_MASK = (1 << SEQUENCE_BITS) - 1;

    private static final byte[] dash = "-".getBytes();
    private static final String[] symbolPool = new String[]{
            "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z",
            "0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z",
            "@", "-", "+", "=", "_"
    };

    private static RandomGenerator instance;

    private static final SecureRandom secureRandom;

    static {
        secureRandom = new SecureRandom();
    }

    private RandomGenerator() {

    }

    public static RandomGenerator init() {
        if (instance == null) {
            instance = new RandomGenerator();
        }

        return instance;
    }

    public long randomUUID() {
        return randomUUID(101);
    }

    /**
     * returns a 64 bit UUID
     */
    public long randomUUID(int serverId) {
        long serverBits = getServerBits(serverId);

        long millis;
        long nextSeq;

        synchronized (this) {
            millis = getMillis();

            if (millis == lastMillis) {
                sequence = (sequence + 1) & SEQUENCE_MASK;

                if (sequence == 0) {
                    millis = waitForNextMillis(millis);
                }

            } else {
                sequence = 0;
            }

            lastMillis = millis;
            nextSeq = sequence;
        }

        return (millis << (SERVER_ID_BITS + SEQUENCE_BITS))
                | (serverBits << SEQUENCE_BITS)
                | (nextSeq & SEQUENCE_MASK);
    }

    /**
     * Generates a cryptographically secure random String
     */
    public String randomSecureString(GeneratorLen generatorLen) {
        int len = generatorLen.getLen();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < len; i++) {
            sb.append(symbolPool[secureRandom.nextInt(symbolPool.length)]);
        }

        return sb.toString();
    }


    public long getMillis() {
        long millis = System.currentTimeMillis() - MILLIS_EPOCH;
        return millis & MAX_TIMESTAMP;
    }

    private long getServerBits(long serverId) {
        return serverId & SERVER_ID_MASK;
    }

    private long waitForNextMillis(long currentMillis) {
        while (currentMillis == lastMillis) {
            lastMillis = getMillis();
        }
        return lastMillis;
    }

}
