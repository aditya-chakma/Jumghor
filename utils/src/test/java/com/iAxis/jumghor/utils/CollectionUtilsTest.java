package com.iAxis.jumghor.utils;

import com.iAxis.jumghor.utils.collection.CollectionUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author aditya.chakma
 * @since 01 May, 2025
 */
public class CollectionUtilsTest {

    public static class CollectionUtilsTestClass {
    }

    @Test
    @SuppressWarnings("all")
    public void testIsAnyNull() {
        CollectionUtilsTestClass instance1 = new CollectionUtilsTestClass();
        CollectionUtilsTestClass instance2 = new CollectionUtilsTestClass();

        assert CollectionUtils.isAnyNull(null, instance1, instance2);
        assert !CollectionUtils.isAnyNull(instance1, instance2);
        assertThrows(AssertionError.class,() -> CollectionUtils.isAnyNull(null));
    }

}
