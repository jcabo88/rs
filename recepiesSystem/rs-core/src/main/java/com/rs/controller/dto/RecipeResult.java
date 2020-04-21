package com.rs.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class RecipeResult {

    @JsonProperty("recipe")
    private Object recipe;

    @JsonProperty("message")
    private String message;

    public RecipeResult(Builder builder) {
        this.recipe = builder.recipe;
        this.message = builder.message;
    }

    public RecipeResult() {
    }

    public Object getRecipe() {
        return recipe;
    }

    public void setRecipe(Object recipe) {
        this.recipe = recipe;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class Builder {
        private Object recipe;
        private String message;

        public Builder recipe(Object recipe){
            this.recipe = recipe;
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
