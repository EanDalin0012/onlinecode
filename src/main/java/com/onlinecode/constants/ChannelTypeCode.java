package com.onlinecode.constants;

public enum ChannelTypeCode {

    ADMIN("01", "ADMIN"), //
    WEB("02", "ADMIN");

    String key;
    String value;

    ChannelTypeCode(String key, String value) {
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
