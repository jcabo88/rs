package com.rs.db.dto;

import java.util.Collections;
import java.util.List;

public class Recipe {

    private String name;
    private int index;
    private String description;
    private String timeToComplete;
    private int numberOfPersons;
    private List<Ingredient> ingredients;
    private String preparationMethod;

    public Recipe(int index, String name, String description, String timeToComplete,
                  int numberOfPersons, String preparationMethod, List<Ingredient> ingredients) {
        this.index = index;
        this.name = name;
        this.description = description;
        this.timeToComplete = timeToComplete;
        this.numberOfPersons = numberOfPersons;
        this.preparationMethod = preparationMethod;
        this.ingredients = ingredients;
    }

    public Recipe() {
        this.name = new String();
        this.index = -1;
        this.description = new String();
        this.timeToComplete = new String();
        this.description = new String();
        this.ingredients = Collections.emptyList();
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

    public int getNumberOfPersons() {
        return numberOfPersons;
    }

    public void setNumberOfPersons(int numberOfPersons) {
        this.numberOfPersons = numberOfPersons;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public String getPreparationMethod() {
        return preparationMethod;
    }

    public void setPreparationMethod(String preparationMethod) {
        this.preparationMethod = preparationMethod;
    }
}
