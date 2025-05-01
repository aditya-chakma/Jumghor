package com.iAxis.jumghor.utils.security;

import java.security.SecureRandom;

/**
 * @author aditya.chakma
 * @since 24 Apr, 2025 3:16 PM
 */

/**
 * This is an implementation of Twitters Snowflake algorithm,
 * a UUID generator in distributed system
 * <p>
 * Available methods: {@link #init()}, {@link #randomUUID(int)}, {@link #randomSecureString(GeneratorLen)}
 */
public final class RandomGenerator {

    public enum GeneratorLen {
        L16(16),
        L32(32),
        L64(64),
        L128(128);

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

    /**
     * BugNote: <br>
     * Making instance an "instance" variable causes multiple instances in multithreaded environment
     * <br>
     * consider the case:
     *
     * <pre>{@code
     *  private static final RandomGenerator instance;
     *  public static RandomGenerator init() {
     *       if (instance == null) {
     *          instance = new RandomGenerator();
     *       }
     *
     *       return instance;
     *     }
     *  }</pre>
     *
     * <br>
     * <p>
     * If two threads access "instance" at the same time, they both will see null and will create their own instance.
     * To solve this, we can create a static final. The second approach to solve it is double-checking-locking
     * <pre>
     *     {@code
     *     if (instance == null) {
     *             synchronized (RandomGenerator.class) {
     *                 if (instance == null) {
     *                     instance = new RandomGenerator();
     *                 }
     *             }
     *         }
     *     }
     * </pre>
     */
    private static final RandomGenerator instance = new RandomGenerator();

    private final SecureRandom secureRandom;

    private RandomGenerator() {
        secureRandom = new SecureRandom();
    }

    /**
     * Returns a RandomGenerator object instance. Must access through `init()` method.
     *
     * @return an instance of RandomGenerator
     */
    public static RandomGenerator init() {
        return instance;
    }

    /**
     * <b>
     * This method is deprecated. Use {@link #randomUUID(int serverId)} instead.
     * </b>
     * Returns a 64 bit UUID. Uses 101 as default machineId
     *
     * @return 64 bit UUID.
     */
    @Deprecated
    public long randomUUID() {
        return randomUUID(101);
    }

    /**
     * Returns a 64 bit UUID based on the snowflake algorithm. Bits distribution:
     *
     * <table>
     *     <tr>
     *         <th>Bits</th>
     *         <th>Range</th>
     *         <th>Data</th>
     *     </tr>
     *     <tr>
     *         <td>1</td>
     *         <td>64-64</td>
     *         <td>Sign bit</td>
     *     </tr>
     *     <tr>
     *         <td>41</td>
     *         <td>23-63</td>
     *         <td>Time based</td>
     *     </tr>
     *     <tr>
     *         <td>10</td>
     *         <td>13-22</td>
     *         <td>Machine/server id</td>
     *     </tr>
     *     <tr>
     *         <td>12</td>
     *         <td>1-12</td>
     *         <td>Sequence</td>
     *     </tr>
     * </table>
     *
     * @param serverId server or machine id
     * @return 64 bit UUID
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
     *
     * @param generatorLen Length of the string generated
     * @return a cryptographically secure random string from a symbol pool
     */
    public String randomSecureString(GeneratorLen generatorLen) {
        int len = generatorLen.getLen();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < len; i++) {
            sb.append(symbolPool[secureRandom.nextInt(symbolPool.length)]);
        }

        return sb.toString();
    }

    private long getMillis() {
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
