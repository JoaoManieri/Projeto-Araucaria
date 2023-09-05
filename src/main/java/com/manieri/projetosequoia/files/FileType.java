package com.manieri.projetosequoia.files;

public enum FileType {
    PDF("*.pdf"),
    DOC("*.doc"),
    TXT("*.txt"),
    JPG("*.jpg"),
    ALL_IMG("*.jpg,*.jpeg,*.png");

    private String extension;

    FileType(String extension) {
        this.extension = extension;
    }

    public String getExtension() {
        return extension;
    }
}
