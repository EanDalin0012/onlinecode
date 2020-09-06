package com.bizcode.constants;

public enum Status {
    Active("1", "Active "),
    InActive("2", "InActive"),
    Modify("3", "Modify"),
    Request("4", "Request"),
    Cancel("5", "Cancel"),
    Delete("6", "Delete"),
    Expired("7", "Expired"),
    UnActive("8", "UnActive"),
    Restore("9", "Restore"),
    ;

    String value;
    String description;

    Status(String v, String d) {
        this.value = v;
        this.description = d;
    }

    public int getValueInt() {
        return Integer.parseInt(value);
    }

    public String getValueStr() {
        return value;
    }

    public String getDescription() {
        return description;
    }
}
