package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class ListDeduplicatorTest {

    @Test
    public void deduplicate() {
        GenericListSorter sorted = Mockito.mock(GenericListSorter.class);
        Mockito.when(sorted.sort(Mockito.anyList())).thenReturn(Arrays.asList(1, 2, 2, 4, 5));

        List<Integer> list = Arrays.asList(1,2,4,2,5);
        List<Integer> expected = Arrays.asList(1,2,4,5);

        ListDeduplicator aggregator = new ListDeduplicator();
        List<Integer> deduplicated = aggregator.deduplicate(list, sorted);

        Assertions.assertEquals(expected, deduplicated);
    }
    @Test
    public void bug_8726_deduplicate() {
        GenericListSorter sorted = Mockito.mock(GenericListSorter.class);
        Mockito.when(sorted.sort(Mockito.anyList())).thenReturn(Arrays.asList(1, 2, 2, 4));
        List<Integer> list = Arrays.asList(1, 2, 4, 2);
        List<Integer> expected = Arrays.asList(1, 2, 4);

        ListDeduplicator aggregator = new ListDeduplicator();
        List<Integer> deduplicated = aggregator.deduplicate(list, sorted);
        Assertions.assertEquals(expected, deduplicated);
    }
}
