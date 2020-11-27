package com.onlinecode.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SystemDateUtil {
    static SimpleDateFormat formatter;//= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
    //System.out
// 	System.out.println(formatter.format(date));

    public static String getDate() {
        formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        return formatter.format(date);
    }

    public static String getDateTime() {
        formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        return formatter.format(date);
    }

    public static String getDateYyyyMdDd() {
        formatter = new SimpleDateFormat("yyyyMMdd");
        Date date = new Date(System.currentTimeMillis());
        return formatter.format(date);
    }

    public static String getDateYyyyMdDdHhMmSs() {
        formatter = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        return formatter.format(date);
    }

    public static String getTime() {
        formatter = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        return formatter.format(date);
    }

    public static String getDateYyyyMdDd_Hh_Mm_Ss() {
        formatter = new SimpleDateFormat("yyyyMMdd_HH_mm_ss");
        Date date = new Date(System.currentTimeMillis());
        return formatter.format(date);
    }

    public static String getDateFormat(String format) {
        formatter = new SimpleDateFormat(format);
        Date date = new Date(System.currentTimeMillis());
        return formatter.format(date);
    }
}
