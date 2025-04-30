package com.iAxis.jumghor.utils;

import com.iAxis.jumghor.utils.security.RandomGenerator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author aditya.chakma
 * @since 24 Apr, 2025
 */

public class RandomGeneratorTest {

    private static class UIDWrapper implements Runnable {
        Set<Long> uids;
        int iterations;

        public UIDWrapper(int iterations) {
            uids = new HashSet<>();
            this.iterations = iterations;
        }

        @Override
        public void run() {
            for (int i = 0; i < iterations; i++) {
                uids.add(RandomGenerator.init().randomUUID(101));
            }
        }

        public Set<Long> getUids() {
            return uids;
        }

        public int getIterations() {
            return iterations;
        }
    }

    @Test
    public void testRandom() {
        Set<String> set = new HashSet<>();

        for (int i = 0; i < 100_000; i++) {
            set.add(RandomGenerator.init().randomSecureString(RandomGenerator.GeneratorLen.L16));
        }

        assert set.size() == 100_000;
    }

    @Test
    public void testRandomUUID() throws InterruptedException {
        int iterations = 5_000;
        int concurrent = 10;

        List<UIDWrapper> wrappers = new ArrayList<>(concurrent);

        for (int i = 0; i < concurrent; i++) {
            wrappers.add(new UIDWrapper(iterations));
        }

        List<Thread> threads = wrappers.stream().map(Thread::new).toList();

        threads.forEach(Thread::start);

        for (Thread thread : threads) {
            thread.join();
        }

        Set<Long> uids = new HashSet<>();
        for (UIDWrapper wrapper : wrappers) {
            uids.addAll(wrapper.getUids());
        }

        assertEquals(concurrent * iterations, uids.size(), "Duplicate UIDs generated");
    }
}
