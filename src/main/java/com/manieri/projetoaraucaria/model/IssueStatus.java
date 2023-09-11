package com.manieri.projetoaraucaria.model;

public enum IssueStatus {
    DONE(4),
    NEW(2),
    IN_PROGRESS(3),
    WARRANTY(11),
    BASAL(14);

    private final int id;

    IssueStatus(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}