package com.rs.controller;

import com.rs.controller.dto.Result;
import com.rs.db.RecipesMockedData;
import com.rs.db.RecipesStorage;
import com.rs.db.dto.Recipe;

import java.util.Optional;

public class ProcessResult {

    private Result result;
    private final RecipesStorage recipesStorage = RecipesMockedData.getInstance();

    //TODO Return an object Recipe inside the object Result
    public Optional<Result> getRecipesByID(int id){
        recipesStorage.getRecipeByIndex(id)
                .ifPresent(this::getRecipe);
        return Optional.of(this.result);
    }

//    public Optional<Recipe> getRecipesByName(String name){
//        return recipesStorage.getRecipeByName(name);
//    }

    private void getRecipe(Recipe recipe) {
        this.result = new Result(recipe);
    }
}
