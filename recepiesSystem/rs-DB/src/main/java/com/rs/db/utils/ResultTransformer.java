package com.rs.db.utils;

import com.rs.db.dto.Ingredient;
import com.rs.db.dto.Recipe;
import com.rs.db.dto.RecipeDB;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ResultTransformer {


    public static Optional<Recipe> mapToRecipe(RecipeDB recipeDB) {
        if (recipeDB == null ){
            return Optional.empty();
        }

        return Optional.of (new Recipe.Builder()
                .index(recipeDB.getId())
                .name(recipeDB.getName())
                .ingredients(getListIngredients(recipeDB.getIngredients()))
                .description(recipeDB.getDescription())
                .numberOfPersons(recipeDB.getNumberOfPersons())
                .preparationMethod(recipeDB.getPreparationMethod())
                .timeToComplete(recipeDB.getTimeToComplete())
                .build()
        );
    }

    private static List<Ingredient> getListIngredients(String ingredients){
        String[] ingredientsArray = ingredients.split(",");
        List<Ingredient> ingredientsList = new ArrayList<>();
        for (String ingredient : ingredientsArray) {
            ingredientsList.add(new Ingredient(ingredient, ""));
        }
        return ingredientsList;
    }
}
