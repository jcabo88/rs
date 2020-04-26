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
        this.preparationMethod = new String();
        this.numberOfPersons = -1;
        this.ingredients = Collections.emptyList();
    }

    public Recipe(Builder builder){
        this.name = builder.name;
        this.index = builder.index;
        this.description = builder.description;
        this.timeToComplete = builder.timeToComplete;
        this.preparationMethod = builder.preparationMethod;
        this.numberOfPersons = builder.numberOfPersons;
        this.ingredients = builder.ingredients;
    }

    public static class Builder {

        private String name;
        private String description;
        private String timeToComplete;
        private String preparationMethod;
        private int index;
        private int numberOfPersons;
        private List<Ingredient> ingredients;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder timeToComplete(String timeToComplete) {
            this.timeToComplete = timeToComplete;
            return this;
        }

        public Builder preparationMethod(String preparationMethod) {
            this.preparationMethod = preparationMethod;
            return this;
        }

        public Builder index(int index) {
            this.index = index;
            return this;
        }

        public Builder numberOfPersons(int numberOfPersons) {
            this.numberOfPersons = numberOfPersons;
            return this;
        }

        public Builder ingredients(List ingredients){
            this.ingredients = ingredients;
            return this;
        }

        public Recipe build() {
            return new Recipe(this);
        }
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

    public boolean equals(Object o) {
        if (o instanceof Recipe) {
            Recipe recipe = (Recipe) o;
            if (this.index == recipe.index &&
                    this.name == recipe.name &&
                    this.timeToComplete == recipe.timeToComplete &&
                    this.numberOfPersons == recipe.numberOfPersons &&
                    this.description == recipe.description &&
                    this.preparationMethod == recipe.preparationMethod) {
                return true;
            }
        }
        return false;
    }
}
