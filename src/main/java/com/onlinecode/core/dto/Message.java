package com.onlinecode.core.dto;

public class Message {
    private String code;
    private String message;

    public Message(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public Message() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Message{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
