package com.springboot.ems.other;

public enum Rates {
    a(5, 5),
    b(4, 4),
    c(3, 3),
    d(2, 2),
    e(1, 1);

    public int id;
    public int rate;

    private Rates(int id, int rate) {
        this.id = id;
        this.rate = rate;
    }
}
