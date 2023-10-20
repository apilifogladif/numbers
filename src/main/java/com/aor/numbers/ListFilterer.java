package com.aor.numbers;

import java.util.ArrayList;
import java.util.List;

public class ListFilterer {
    private final GenericListFilter filter_;
    public ListFilterer(GenericListFilter filter) {
        filter_ = filter;
    }
    public List<Integer> filter(List<Integer> list) {
        List<Integer> ret = new ArrayList<>();
        for (int i: list) {
            if (filter_.accept(i)) {
                ret.add(i);
            }
        }
        return ret;
    }
}
