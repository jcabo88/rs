package com.rs.db.dto;

public class Recipe {

    String name;
    int index;
    String description;
    String timeToComplete;

    public Recipe(int index, String name, String description, String timeToComplete) {
        this.index = index;
        this.name = name;
        this.description = description;
        this.timeToComplete = timeToComplete;
    }

    public Recipe() {
        this.name = new String();
        this.index = -1;
        this.description = new String();
        this.timeToComplete = new String();
    }

    public int getIndex() { return index; }

    public void setIndex(int index) { this.index = index; }

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

    public String getTimeToComplete() {
        return timeToComplete;
    }

    public void setTimeToComplete(String timeToComplete) {
        this.timeToComplete = timeToComplete;
    }
}
