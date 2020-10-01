package com.onlinecode.utils;

import java.nio.file.Path;
import java.nio.file.Paths;

public class SystemUtil {
    public static String projectPath() {
        // Java 7
        // System.out.println(Paths.get("").toAbsolutePath().toString());
        return System.getProperty("user.dir");
    }

    public static String path() {
        return "uploads";
    }

    private static String currentPath() {
        Path currentWorkingDir = Paths.get("").toAbsolutePath();
        System.out.println("\n\npath**:"+currentWorkingDir.normalize().toString());
        String path = currentWorkingDir.normalize().toString();
        return path;
    }

    public static String resourcePath() {
        Path currentWorkingDir = Paths.get("").toAbsolutePath();
        String path = currentWorkingDir.normalize().toString() + "/resources";
        return path;
    }

}
