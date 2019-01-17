package com.nshenoy.springboot.topics;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Topic {

    // Columns for Topic Table
    @Id
    public String id;
    public String name;
    public String description;

    public Topic(String id, String name, String description) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Topic() {
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}