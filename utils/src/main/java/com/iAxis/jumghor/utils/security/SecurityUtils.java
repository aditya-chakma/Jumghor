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

    public static String encryptPassword(String password) throws IllegalArgumentException {
        if (isEmpty(password)) {
            throw new IllegalArgumentException("Password cannot be empty");
        }

        return bCryptPasswordEncoder.encode(password);
    }

    public static boolean matchPassword(String rawPassword, String hashedPassword) throws IllegalArgumentException {
        if (isEmpty(rawPassword) || isEmpty(hashedPassword)) {
            throw new IllegalArgumentException("Password or hash cannot be empty");
        }

        return bCryptPasswordEncoder.matches(rawPassword, hashedPassword);
    }

}
