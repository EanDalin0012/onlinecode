package com.bizcode.constants;

public enum SYN {

    Y("Y_ACCESS", "100_ACCESS"),
    N("N_ACCESS", "200_ACCESS");

    String key;
    String value;

    SYN(String k, String v) {
        this.key = k;
        this.value = v;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
