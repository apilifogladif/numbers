package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class PositiveFilterTest {
    @Test
    public void positive() {
        PositiveFilter filter = new PositiveFilter();
        Assertions.assertEquals(true, filter.accept(1));
        Assertions.assertEquals(true, filter.accept(10000000));
        Assertions.assertEquals(true, filter.accept(5000));
        Assertions.assertEquals(true, filter.accept(18));
        Assertions.assertEquals(true, filter.accept(91));
        Assertions.assertEquals(false, filter.accept(-500));
        Assertions.assertEquals(false, filter.accept(-14));
        Assertions.assertEquals(false, filter.accept(-5));
        Assertions.assertEquals(false, filter.accept(-88));
        Assertions.assertEquals(false, filter.accept(-32));
    }
}
