package com.onlinecode.core.exception;

public class ValueException extends Throwable{
    private  String value;

    public ValueException(String value) {
        this.value = value;
    }

    public ValueException(String value, Throwable throwable) {
        super(throwable);
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
