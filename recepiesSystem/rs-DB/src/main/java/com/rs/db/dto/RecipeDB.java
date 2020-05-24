package com.rs.db.dto;

import javax.persistence.*;

@Entity
@Table (name = "recipe")
public class RecipeDB {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column (name = "recipename")
    private String name;
    private String ingredients;
    private String description;
    @Column (name = "timetocomplete")
    private String timeToComplete;
    @Column (name = "numberofpersons")
    private int numberOfPersons;
    @Column (name = "preparationmethod")
    private String preparationMethod;

    public RecipeDB(int id, String name, String description, String timeToComplete,
                    int numberOfPersons, String ingredients, String preparationMethod) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.timeToComplete = timeToComplete;
        this.numberOfPersons = numberOfPersons;
        this.ingredients = ingredients;
        this.preparationMethod = preparationMethod;
    }

    public RecipeDB () {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getPreparationMethod() {
        return preparationMethod;
    }

    public void setPreparationMethod(String preparationMethod) {
        this.preparationMethod = preparationMethod;
    }
}
