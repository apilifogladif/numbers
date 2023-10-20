package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

//import org.mockito.Mockito;

public class ListAggregatorTest {
    public List<Integer> list;
    @BeforeEach
    public void setup() {
        list = Arrays.asList(1,2,4,2,5);
    }
    @Test
    public void sum() {

        ListAggregator aggregator = new ListAggregator();
        int sum = aggregator.sum(list);

        Assertions.assertEquals(14, sum);
    }

    @Test
    public void max() {

        ListAggregator aggregator = new ListAggregator();
        int max = aggregator.max(list);

        Assertions.assertEquals(5, max);
    }

    @Test
    public void min() {

        ListAggregator aggregator = new ListAggregator();
        int min = aggregator.min(list);

        Assertions.assertEquals(1, min);
    }

    @Test
    public void distinct() {
        class stubdistinct implements GenericListDeduplicator {
            @Override
            public List<Integer> deduplicate(List<Integer> list) {
                return Arrays.asList(1, 2, 4, 5);
            }
        }
        GenericListDeduplicator stub = new stubdistinct();
        ListAggregator aggregator = new ListAggregator();
        int distinct = aggregator.distinct(list, stub);

        Assertions.assertEquals(4, distinct);
    }

    @Test
    public void bug_7263() {

        list = Arrays.asList(-1, -4, -5);
        ListAggregator aggregator = new ListAggregator();
        int max = aggregator.max(list);

        Assertions.assertEquals(-1, max);
    }

    @Test
    public void bug_8726() {
        class stubdistinct implements GenericListDeduplicator {
            @Override
            public List<Integer> deduplicate(List<Integer> list) {
                return Arrays.asList(1, 2, 4);
            }
        }
        stubdistinct stub = new stubdistinct();
        list = Arrays.asList(1, 2, 4, 2);
        ListAggregator aggregator = new ListAggregator();
        int distinct = aggregator.distinct(list, stub);

        Assertions.assertEquals(3, distinct);
    }

}
