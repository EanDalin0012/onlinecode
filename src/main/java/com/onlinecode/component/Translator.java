package com.onlinecode.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class Translator {
    private static ReloadableResourceBundleMessageSource messageSource;

    @Autowired
    Translator(ReloadableResourceBundleMessageSource messageSource) {
        Translator.messageSource = messageSource;
    }

    public static String toLocale(String languageCode, String msgCode) {
        String language = "en";
        if (languageCode == "") {
            language = "kh";
        } else if (languageCode == "05") {
            language = "ch";
        }
        Locale locale = new Locale(languageCode); // en || fr
        System.out.println(locale);
        return messageSource.getMessage(msgCode, null, locale);
    }
}
