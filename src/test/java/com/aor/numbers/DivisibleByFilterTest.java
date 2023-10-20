package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DivisibleByFilterTest {
    @Test
    public void divisible() {
        DivisibleByFilter filter = new DivisibleByFilter(2);
        Assertions.assertEquals(true, filter.accept(2));
        Assertions.assertEquals(false, filter.accept(5));
        Assertions.assertEquals(true, filter.accept(526));
        Assertions.assertEquals(false, filter.accept(211));

        DivisibleByFilter filter1 = new DivisibleByFilter(10);
        Assertions.assertEquals(false, filter1.accept(211));
        Assertions.assertEquals(true, filter1.accept(80));
        Assertions.assertEquals(false, filter1.accept(66));
        Assertions.assertEquals(false, filter1.accept(95));

        DivisibleByFilter filter2 = new DivisibleByFilter(22);
        Assertions.assertEquals(true, filter2.accept(44));
        Assertions.assertEquals(false, filter2.accept(95));
        Assertions.assertEquals(true, filter2.accept(88));
        Assertions.assertEquals(false, filter2.accept(21));

    }
}
