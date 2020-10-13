package com.onlinecode.admins.constants;

import com.onlinecode.component.Translator;
import com.onlinecode.core.dto.Message;

public class TranslateInvalid {
    public static Message validateValue(String key, String lang) {
        Message data = new Message();
        String message = Translator.toLocale(lang, "value_"+key);
        data.setCode(key);
        data.setMessage(message);
        return data;
    }

    public static Message validateField(String key, String lang) {
        Message data = new Message();
        String message = Translator.toLocale(lang, "field_"+key);
        data.setCode(key);
        data.setMessage(message);
        return data;
    }
}
