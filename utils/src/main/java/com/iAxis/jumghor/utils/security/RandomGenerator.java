package com.iAxis.jumghor.utils.security;

import com.iAxis.jumghor.utils.common.ServerInitials;

import java.nio.ByteBuffer;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.UUID;

/**
 * @author aditya.chakma
 * @since 24 Apr, 2025 3:16 PM
 */
public final class RandomGenerator {

    private static final SecureRandom secureRandom;

    private static RandomGenerator instance;

    static {
        secureRandom = new SecureRandom();
    }

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

    private static final String[] symbolPool = new String[]{
            "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z",
            "0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z",
            "@", "-", "+", "=", "+"
    };

    private static final byte[] dash = "-".getBytes();

    private RandomGenerator() {
    }

    /**
     * returns a 36 character long uid
     */
    public static String randomUUID(ServerInitials serverInitials, int serverId) {
        // todo: implementation
        long millis = System.currentTimeMillis();


        return null;
    }

    /**
     * Generates a random String
     */
    public static String random(GeneratorLen generatorLen) {
        int len = generatorLen.getLen();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < len; i++) {
            sb.append(symbolPool[secureRandom.nextInt(symbolPool.length)]);
        }

        return sb.toString();
    }


    public static String get(ServerInitials serverInitials, GeneratorLen uuidLen, long nodeNumber) {
        String server = serverInitials.getServerName();
        int len = uuidLen.getLen();

//        byte[] bytes = new byte[len]; // each character is 4 bytes long
//        int offset = 0;
//        System.out.printf("Dash bytes: (%d) %s\n", dash.length , Base64.getEncoder().encodeToString(dash));
//
//        // server identifier
//        byte[] serverBytes = getBytes(server, 2);
//        offset = putBytes(bytes, offset, serverBytes);
//        offset = putBytes(bytes, offset, dash);
//
//        System.out.printf("Server bytes: (%d) %s \n", serverBytes.length,  Base64.getEncoder().encodeToString(serverBytes));
//
//        // node identifier
//        byte[] nodeBytes = getBytes(nodeNumber, 2);
//        offset = putBytes(bytes, offset, nodeBytes);
//        offset = putBytes(bytes, offset, dash);
//
//        System.out.printf("Node bytes: (%d), %s\n", nodeBytes.length, Base64.getEncoder().encodeToString(nodeBytes));
//
//        // random bytes
//        byte[] randomBytes = getRandomBytes(4);
//        offset = putBytes(bytes, offset, randomBytes);
//
//       // System.out.println("Random bytes: " + Arrays.toString(randomBytes));
//
//        // put sequence
//        byte[] sequenceBytes = getBytes(System.nanoTime(), 6);
//        offset = putBytes(bytes, offset, sequenceBytes);
//
//        System.out.println("Offset: " + offset);
//        System.out.printf("Sequence bytes: (%d) %s\n", sequenceBytes.length, Base64.getEncoder().encodeToString(sequenceBytes));
//        System.out.printf("bytes length: %d\n", bytes.length);

        int offset = 0;

        // first

        return null;
    }

    private static byte[] getBytes(String s, int len) {
        byte[] bytes = s.getBytes();
        return Arrays.copyOfRange(bytes, bytes.length - len, bytes.length);
    }

    private static byte[] getBytes(Long num, int len) {
        ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES);
        buffer.putLong(num);
        byte[] bytes = buffer.array();
        return Arrays.copyOfRange(bytes, bytes.length - len, bytes.length);
    }

    private static int putBytes(byte[] bytes, int offset, byte[] source) {
        System.out.println("Offset: " + offset);
        System.arraycopy(source, 0, bytes, offset, source.length);
        return source.length + offset;
    }

    private static byte[] getRandomBytes(int len) {
        byte[] bytes = new byte[len];
        secureRandom.nextBytes(bytes);

        return bytes;
    }

}
