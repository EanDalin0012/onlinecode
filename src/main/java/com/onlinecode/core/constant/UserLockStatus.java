package com.bizcode.core.constant;

public enum UserLockStatus {
    Start("START", "Start"),
    Processing("PROCESSING", "Processing"),
    End("END", "End");

    String value;
    String description;

    UserLockStatus(String v, String d) {
        this.value = v;
        this.description = d;
    }

    public String Value() {
        return value;
    }

    public String Description() {
        return description;
    }
}
