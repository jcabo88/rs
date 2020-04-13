package com.rs.db.dto;

public class Ingredient {

    String name;
    String quantity;

    public Ingredient(String name, String quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public Ingredient() {
        this.name = new String();
        this.quantity = new String();
    }
}
