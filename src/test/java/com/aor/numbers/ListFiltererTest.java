package com.aor.numbers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.List;

public class ListFiltererTest {

    @Test
    public void positive() {
        List<Integer> list = Arrays.asList(1, 2, -5, 9, 3, -2, -9);
        ListFilterer filter = new ListFilterer(new PositiveFilter());
        List<Integer> filtered = filter.filter(list);

        List<Integer> expected = Arrays.asList(1, 2, 9, 3);
        Assertions.assertEquals(expected, filtered);
    }

    @Test
    public void divisible() {
        List<Integer> list = Arrays.asList(1, 2, 4, 3, 8, 12);
        ListFilterer filter = new ListFilterer(new DivisibleByFilter(2));
        List<Integer> filtered = filter.filter(list);

        List<Integer> expected = Arrays.asList(2, 4, 8, 12);
        Assertions.assertEquals(expected, filtered);
    }
}
