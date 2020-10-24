package com.onlinecode.core.dto;

public class File {
    private java.io.File file;

    public File(java.io.File file) {
        this.file = file;
    }

    public File() {
    }

    public java.io.File getFile() {
        return file;
    }

    public void setFile(java.io.File file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return "File{" +
                "file=" + file +
                '}';
    }
}
