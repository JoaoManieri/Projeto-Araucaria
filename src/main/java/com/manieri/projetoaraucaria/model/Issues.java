package com.manieri.projetoaraucaria.model;

import java.util.ArrayList;

public class Issues {

    private int issuesId;
    private Status status;
    private Project project;
    private String subject;
    private String lastUpdate = null;
    public Issues(int issuesId, Status status, Project project, String subject) {
        this.issuesId = issuesId;
        this.status = status;
        this.project = project;
        this.subject = subject;
    }

    public Issues(int issuesId, Status status, Project project, String subject, String lastUpdate) {
        this.issuesId = issuesId;
        this.status = status;
        this.project = project;
        this.subject = subject;
        this.lastUpdate = lastUpdate;
    }

    public String getLastUpdate(){return  lastUpdate; }
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
