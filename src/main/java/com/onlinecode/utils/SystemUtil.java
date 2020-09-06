package com.bizcode.utils;

public class SystemUtil {
    public static String projectPath() {
        // Java 7
        // System.out.println(Paths.get("").toAbsolutePath().toString());
        return System.getProperty("user.dir");
    }

    public static String path() {
        return "uploads";
    }
}
