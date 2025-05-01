package com.iAxis.jumghor.utils.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static com.iAxis.jumghor.utils.collection.StringUtils.isEmpty;

/**
 * @author aditya.chakma
 * @since 27 Apr, 2025
 */
public final class SecurityUtils {

    private static final BCryptPasswordEncoder bCryptPasswordEncoder;

    static {
        bCryptPasswordEncoder = new BCryptPasswordEncoder(10);
    }

    /**
     * Returns the hash of the password
     * @param password The raw password
     * @return Password hash (60 chars)
     * */
    public static String encryptPassword(String password) throws IllegalArgumentException {
        if (isEmpty(password)) {
            throw new IllegalArgumentException("Password cannot be empty");
        }

        return bCryptPasswordEncoder.encode(password);
    }

    /**
     * Verifies the password hash
     * @param rawPassword The raw password
     * @param hashedPassword The password hash
     * @return true if hash matches, false otherwise
     * */
    public static boolean matchPassword(String rawPassword, String hashedPassword) throws IllegalArgumentException {
        if (isEmpty(rawPassword) || isEmpty(hashedPassword)) {
            throw new IllegalArgumentException("Password or hash cannot be empty");
        }

        return bCryptPasswordEncoder.matches(rawPassword, hashedPassword);
    }

}
