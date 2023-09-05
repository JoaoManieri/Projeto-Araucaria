package com.manieri.projetosequoia.model;

public class Status {

    public Status(int id, String name, Boolean is_closed) {
        this.id = id;
        this.name = name;
        this.is_closed = is_closed;
    }

    private int id;
    private String name;
    private Boolean is_closed;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Boolean getIs_closed() {
        return is_closed;
    }
}
