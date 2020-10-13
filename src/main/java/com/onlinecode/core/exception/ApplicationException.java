package com.onlinecode.core.exception;

public class ApplicationException extends Throwable {
    private  String key;
    private  String message;

    public ApplicationException(String key, String message) {
        this.key = key;
        this.message = message;
    }

    public ApplicationException(String key, String message,Throwable throwable) {
        super(throwable);
        this.key = key;
        this.message = message;
    }

    public ApplicationException(String key, Throwable throwable) {
        super(throwable);
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
