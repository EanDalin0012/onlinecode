package com.onlinecode.core.exception;

public class FieldException extends Throwable{
    private String field;
    private String message;

    public FieldException(String field, String message) {
        this.field = field;
        this.message = message;
    }

    public FieldException(String message, Throwable throwable) {
        super(throwable);
        this.message = message;
    }

    public FieldException(String field,String message, Throwable throwable) {
        super(throwable);
        this.message = message;
        this.field = field;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
