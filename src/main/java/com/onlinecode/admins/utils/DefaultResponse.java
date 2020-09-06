package com.onlinecode.admins.utils;

import com.onlinecode.core.map.MMap;

public class DefaultResponse {
    public static MMap defaultHeader(Boolean error, String msg) {
        MMap _header = new MMap();
        _header.setString("message", msg);
        _header.setBoolean("result", error);
        return _header;
    }

    public static MMap defaultHeader(String msg) {
        MMap _header = new MMap();
        _header.setString("message", msg);
        _header.setBoolean("result", true);
        return _header;
    }

    public static MMap defaultHeader() {
        MMap _header = new MMap();
        _header.setString("message", "msg default");
        _header.setBoolean("result", true);
        return _header;
    }

    public static MMap defaultBody() {
        MMap _body = new MMap();
        _body.setString("isSuccess", "Y");
        _body.setString("errorMessage", "No error");
        return _body;
    }

    public static MMap defaultBody(String error) {
        MMap _body = new MMap();
        _body.setString("isSuccess", "N");
        _body.setString("errorMessage", error);
        return _body;
    }

    public static MMap defaultBody(boolean bool, String error) {
        MMap _body = new MMap();
        _body.setBoolean("isSuccess", bool);
        _body.setString("errorMessage", error);
        return _body;
    }
}
