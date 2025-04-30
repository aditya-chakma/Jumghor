package com.iAxis.jumghor.utils.collection;

/**
 * @author aditya.chakma
 * @since 30 Apr, 2025
 */
public final class CollectionUtils {

    public static boolean isAnyNull(Object... objects) {
        assert objects != null;

        for (Object object : objects) {
            if (object == null) {
                return true;
            }
        }

        return false;
    }

}
