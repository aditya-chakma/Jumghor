package com.iAxis.jumghor.utils;

import com.iAxis.jumghor.utils.security.RandomGenerator;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author aditya.chakma
 * @since 24 Apr, 2025
 */

public class RandomGeneratorTest {

    @Test
    public void testRandom() {
        Set<String> set = new HashSet<>();

        for (int i = 0; i < 100_000; i++) {
            set.add(RandomGenerator.random(RandomGenerator.GeneratorLen.L16));
        }

        assert set.size() == 100_000;
    }
}
