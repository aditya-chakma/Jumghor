package com.iAxis.jumghor.utils;

import com.iAxis.jumghor.utils.common.ServerInitials;
import com.iAxis.jumghor.utils.security.RandomGenerator;
import org.junit.jupiter.api.Test;

import java.util.*;

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

    @Test
    public void testRandomUUID() {
        List<Map.Entry<Integer, Long>> idxUidList = new ArrayList<>();

        for (int i = 0; i < 10_000; i++) {
            idxUidList.add(new AbstractMap.SimpleEntry<>(i, RandomGenerator.randomUUID(ServerInitials.DEFAULT, 101)));
        }

        idxUidList.sort((a, b) -> {
            if ()
        });

        int wrongSequence = 0;
        for (int i = 0; i < idxUidList.size(); i++) {
            if (idxUidList.get(i).getKey() > i) {
//                System.out.println(i + ":" +idxUidList.get(i));
                wrongSequence += 1;
            }
        }

        System.out.println("Wrong sequence: " + wrongSequence);
    }
}
