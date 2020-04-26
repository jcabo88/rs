package com.rs.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class RecipeResult {

    @JsonProperty("recipes")
    private Object recipes;

    @JsonProperty("message")
    private String message;

    public RecipeResult(Builder builder) {
        this.recipes = builder.recipes;
        this.message = builder.message;
    }

    public RecipeResult() {
    }

    public Object getRecipes() {
        return recipes;
    }

    public void setRecipes(Object recipes) {
        this.recipes = recipes;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class Builder {
        private Object recipes;
        private String message;

        public Builder recipes(Object recipes){
            this.recipes = recipes;
            return this;
        }

        public Builder message(String message){
            this.message = message;
            return this;
        }

        public RecipeResult build() {
            return new RecipeResult(this);
        }
    }

}
