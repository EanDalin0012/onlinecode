package com.onlinecode.core.exception;

public class ApplicationException extends Exception{

    private  String response_code;
    private String response_message;

    public ApplicationException(String response_code, String response_message) {
        this.response_code = response_code;
        this.response_message = response_message;
    }

    public ApplicationException(String message, String response_code, String response_message) {
        super(message);
        this.response_code = response_code;
        this.response_message = response_message;
    }

    public ApplicationException(String message, Throwable cause, String response_code, String response_message) {
        super(message, cause);
        this.response_code = response_code;
        this.response_message = response_message;
    }

    public ApplicationException(Throwable cause, String response_code, String response_message) {
        super(cause);
        this.response_code = response_code;
        this.response_message = response_message;
    }

    public ApplicationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String response_code, String response_message) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.response_code = response_code;
        this.response_message = response_message;
    }

    public String getResponse_code() {
        return response_code;
    }

    public void setResponse_code(String response_code) {
        this.response_code = response_code;
    }

    public String getResponse_message() {
        return response_message;
    }

    public void setResponse_message(String response_message) {
        this.response_message = response_message;
    }
}
