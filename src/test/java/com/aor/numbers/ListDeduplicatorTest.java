package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ListDeduplicatorTest {

    @Test
    public void deduplicate() {
        class stubdeduplicate implements GenericListSorter {
            @Override
            public List<Integer> sort(List<Integer> list) {
                return Arrays.asList(1, 2, 2, 4);
            }
        }

        List<Integer> list = Arrays.asList(1,2,4,2,5);
        List<Integer> expected = Arrays.asList(1,2,4,5);

        stubdeduplicate stub = new stubdeduplicate();
        List<Integer> sorted = stub.sort(list);
        ListDeduplicator aggregator = new ListDeduplicator();
        List<Integer> deduplicated = aggregator.deduplicate(list, stub);

        Assertions.assertEquals(expected, deduplicated);
    }
    @Test
    public void bug_8726_deduplicate() {
        class stubdeduplicate implements GenericListSorter {
            @Override
            public List<Integer> sort(List<Integer> list) {
                return Arrays.asList(1, 2, 2, 4);
            }
        }
        List<Integer> list = Arrays.asList(1, 2, 4, 2);
        List<Integer> expected = Arrays.asList(1, 2, 4);
        stubdeduplicate stub = new stubdeduplicate();
        List<Integer> sorted = stub.sort(list);
        ListDeduplicator aggregator = new ListDeduplicator();
        List<Integer> deduplicated = aggregator.deduplicate(sorted, stub);
        Assertions.assertEquals(expected, deduplicated);
    }
}
