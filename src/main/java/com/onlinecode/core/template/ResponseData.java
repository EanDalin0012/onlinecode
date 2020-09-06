package com.onlinecode.core.template;

public class ResponseData<H, B> {
    private H header;
    private B body;

    public ResponseData(H header, B body) {
        this.header = header;
        this.body = body;
    }

    public ResponseData() {
    }

    public H getHeader() {
        return header;
    }

    public void setHeader(H header) {
        this.header = header;
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
                "header=" + header +
                ", body=" + body +
                '}';
    }
}
