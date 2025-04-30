package com.iAxis.jumghor.entities.utils;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author aditya.chakma
 * @since 28 Apr, 2025
 */
public final class EntityUtils {

    public static <T extends Number> boolean isValidIdentifier(T t) {
        return t != null && t.intValue() != 0;
    }

}
