package com.aor.numbers;

public class DivisibleByFilter implements GenericListFilter {
    private final Integer n_;
    public DivisibleByFilter (Integer n) {
        n_ = n;
    }
    @Override
    public boolean accept(Integer number) {return number % n_ == 0; }
}
