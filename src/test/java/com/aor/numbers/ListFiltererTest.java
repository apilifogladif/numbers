package com.aor.numbers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class ListFiltererTest {

    @Test
    public void positive() {
        GenericListFilter filter = Mockito.mock(GenericListFilter.class);
        Mockito.when(filter.accept(1)).thenReturn(true);
        Mockito.when(filter.accept(2)).thenReturn(true);
        Mockito.when(filter.accept(-5)).thenReturn(false);
        Mockito.when(filter.accept(3)).thenReturn(true);
        Mockito.when(filter.accept(-2)).thenReturn(false);
        Mockito.when(filter.accept(-9)).thenReturn(false);

        List<Integer> list = Arrays.asList(1, 2, -5, 3, -2, -9);
        ListFilterer filterused = new ListFilterer(new PositiveFilter());
        List<Integer> filtered = filterused.filter(list);

        List<Integer> expected = Arrays.asList(1, 2, 3);
        Assertions.assertEquals(expected, filtered);
    }

    @Test
    public void divisible() {
        GenericListFilter filter = Mockito.mock(GenericListFilter.class);
        Mockito.when(filter.accept(1)).thenReturn(false);
        Mockito.when(filter.accept(2)).thenReturn(true);
        Mockito.when(filter.accept(4)).thenReturn(true);
        Mockito.when(filter.accept(3)).thenReturn(false);
        Mockito.when(filter.accept(8)).thenReturn(true);
        Mockito.when(filter.accept(12)).thenReturn(true);

        List<Integer> list = Arrays.asList(1, 2, 4, 3, 8, 12);
        ListFilterer filterused = new ListFilterer(new DivisibleByFilter(2));
        List<Integer> filtered = filterused.filter(list);

        List<Integer> expected = Arrays.asList(2, 4, 8, 12);
        Assertions.assertEquals(expected, filtered);
    }
}
