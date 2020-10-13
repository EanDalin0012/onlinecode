package com.onlinecode.core.template;
import com.onlinecode.core.dto.Message;

public class ResponseData<B> {
    private B body;
    private Message error;

    public ResponseData(B body, Message error) {
        this.body = body;
        this.error = error;
    }

    public ResponseData() {
    }

    public B getBody() {
        return body;
    }

    public void setBody(B body) {
        this.body = body;
    }

    public Message getError() {
        return error;
    }

    public void setError(Message error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "ResponseData{" +
                "body=" + body +
                ", error=" + error +
                '}';
    }
}
