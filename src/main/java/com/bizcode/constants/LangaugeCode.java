package com.bizcode.constants;

public enum LangaugeCode {
    EN("01", "English"), //
    KM("02", "Khmer"),
    ZH("05", "Chines");

    String key;
    String value;

    LangaugeCode(String key, String value) {
        this.key = key;
        this.value = value;
    }


    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
