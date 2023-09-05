package com.manieri.projetosequoia.model;

import java.util.ArrayList;

public class Issues {

    private int issuesId;
    private Status status;
    private Project project;
    private String subject;
    public Issues(int issuesId, Status status, Project project, String subject) {
        this.issuesId = issuesId;
        this.status = status;
        this.project = project;
        this.subject = subject;
    }

    public int getIssuesId() {
        return issuesId;
    }

    public Status getStatus() {
        return status;
    }

    public Project getProject() {
        return project;
    }

    public String getSubject() {
        return subject;
    }
}
