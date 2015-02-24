package edu.neu.coe.model;

import edu.neu.coe.constants.Status;

import java.io.Serializable;

public class Role implements Serializable {

    private long id;
    private String name;
    private String description;
    private Status status;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
