package com.manieri.projetoaraucaria.model;

public enum IssueStatus {
    NEW_AND_IN_PROGRESS(-1),
    ALL(0),
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