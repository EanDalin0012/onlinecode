package com.onlinecode.core.template;

public class ResponseData<B> {
    private B body;

    public ResponseData(B body) {
        this.body = body;
    }

    public ResponseData() {
    }

    public B getBody() {
        return body;
    }

    public void setBody(B body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "ResponseData{" +
                ", body=" + body +
                '}';
    }
}
