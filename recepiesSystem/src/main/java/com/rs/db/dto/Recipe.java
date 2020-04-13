package com.rs.db.dto;

public class Recipe {

    String name;
    int index;
    String description;
    String timeToComplete;
    int numberOfPersons;
    Ingredient ingredient;
    String preparationMethod;

    public Recipe(int index, String name, String description, String timeToComplete,
                  int numberOfPersons, String preparationMethod, Ingredient ingredient) {
        this.index = index;
        this.name = name;
        this.description = description;
        this.timeToComplete = timeToComplete;
        this.numberOfPersons = numberOfPersons;
        this.preparationMethod = preparationMethod;
        this.ingredient = ingredient;
    }

    public Recipe() {
        this.name = new String();
        this.index = -1;
        this.description = new String();
        this.timeToComplete = new String();
        this.description = new String();
        this.ingredient = new Ingredient();
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
