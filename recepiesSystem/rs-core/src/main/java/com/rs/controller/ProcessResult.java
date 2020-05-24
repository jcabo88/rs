package com.rs.controller;

import com.rs.controller.dto.RecipeResult;
import com.rs.controller.dto.Result;
import com.rs.db.RecipesStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

// Spring uses component scanning to find the classes that it needs to auto-wire and insert into classes for IoC (Inversion of Control)
// Basically, Spring is going to scan the project’s classpath (or paths you specified),
// find all of the @Component classes and make them available for auto-wiring.
@Component
public class ProcessResult {

    private static final String RECIPE_NOT_FOUND = "Recipe not Found";

    // Injects RecipesStorage when Process Result it is created
    @Autowired
    public RecipesStorage recipesStorage;

    public ProcessResult() {}

    public Optional<Result> getRecipesByID(int id) {
        return getRecipeResultByID(id)
                .flatMap(this::getResult);
    }

    public Optional<Result> getRecipesByName(String name) {
        return getRecipesResultByName(name)
                .flatMap(this::getResult);
    }

    private Optional<Result> getResult(RecipeResult recipe) {
        return Optional.of(new Result(recipe));
    }

    private Optional<RecipeResult> getRecipesResultByName(String name) {
        List list = recipesStorage.getRecipeByName(name);
        if (list.isEmpty()) {
            return getRecipeNotFound();
        }
        return getRecipeResult(list);
    }

    private Optional<RecipeResult> getRecipeResultByID(int id) {
        return recipesStorage.getRecipeByIndex(id)
                .map(this::getRecipeResult)
                .orElseGet(this::getRecipeNotFound);
    }

    private Optional<RecipeResult> getRecipeResult(Object recipes) {
        return Optional.ofNullable(new RecipeResult.Builder()
                .recipes(recipes)
                .build());
    }

    private Optional<RecipeResult> getRecipeNotFound(){
        return Optional.ofNullable(new RecipeResult.Builder().message(RECIPE_NOT_FOUND).build());
    }
}
