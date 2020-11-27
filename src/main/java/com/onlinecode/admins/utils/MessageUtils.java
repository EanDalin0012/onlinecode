package com.onlinecode.admins.utils;

import com.onlinecode.component.Translator;
import com.onlinecode.constants.ErrorCode;
import com.onlinecode.core.dto.Message;

public class MessageUtils {

    public static Message message(String key, String lang) {
        Message data = new Message();
        String message = Translator.toLocale(lang, key);
        if (ErrorCode.EXCEPTION_ERR == key) {
            message = Translator.toLocale(lang, key);
        } else if ("status".equals(key)) {
            message = Translator.toLocale(lang, "status");
        } else if ("user_id".equals(key)) {
            message = Translator.toLocale(lang, "user_id");
        }
        data.setCode(key);
        data.setMessage(message);
        return data;
    }

}
