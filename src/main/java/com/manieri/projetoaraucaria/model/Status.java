package com.manieri.projetoaraucaria.model;

import java.util.Objects;

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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Status otherStatus = (Status) obj;
        return id == otherStatus.id && name.equals(otherStatus.name) && is_closed == otherStatus.is_closed;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, is_closed);
    }
}
