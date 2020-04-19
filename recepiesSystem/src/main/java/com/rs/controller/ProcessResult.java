package com.rs.controller;

import com.rs.controller.dto.RecipeResult;
import com.rs.controller.dto.Result;
import com.rs.db.RecipesMockedData;
import com.rs.db.RecipesStorage;
import com.rs.db.dto.Recipe;

import java.util.Optional;

public class ProcessResult {

    private static final String RECIPE_NOT_FOUND = "Recipe not Found";
    private final RecipesStorage recipesStorage = RecipesMockedData.getInstance();

    public Optional<Result> getRecipesByID(int id){
        return getRecipeResultByID(id)
                .flatMap(this::getResult);
    }
//    TODO Return List of Recipes
//    public Optional<Recipe> getRecipesByName(String name){
//        return recipesStorage.getRecipeByName(name);
//    }

    private Optional<RecipeResult> getRecipeResultByID(int id){
        return recipesStorage.getRecipeByIndex(id)
                .map(this::getRecipeResult)
                .orElseGet(() -> Optional.ofNullable(
                        new RecipeResult.Builder().message(RECIPE_NOT_FOUND).build()));
    }

    private Optional<RecipeResult> getRecipeResult(Recipe recipe){
        return Optional.ofNullable(new RecipeResult.Builder()
                .recipe(recipe)
                .build());
    }

    private Optional<Result> getResult(RecipeResult recipe) {
        return Optional.of(new Result(recipe));
    }
}
