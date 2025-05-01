package com.iAxis.jumghor.utils;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

/**
 * @author aditya.chakma
 * @since 01 May, 2025
 */
public class StringUtilsTest {

    @Test
    @SuppressWarnings("ConstantConditions")
    public void isBlank() {
        assert StringUtils.isBlank(null);
        assert StringUtils.isBlank("");
        assert !StringUtils.isBlank("test-string");
    }

}
