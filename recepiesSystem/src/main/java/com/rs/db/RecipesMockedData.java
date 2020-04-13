package com.rs.db;

import com.rs.db.dto.Recipe;
import com.rs.db.exceptions.DatabaseException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class RecipesMockedData implements RecipesStorage {
    private static RecipesMockedData recipesMockedData = null;

    private List<Recipe> recipes;

    public RecipesMockedData() {
        this.recipes = new ArrayList<>();
        recipes.add(new Recipe(1, "Huevos Fritos", "Freir los huevos", "5min"));
        recipes.add(new Recipe(2, "Tortilla francesa", "Batir los huevos " +
                "y echarlos en la sarten", "5min"));
        recipes.add(new Recipe(3, "Arroz blanco", "Freir el arroz durante 2 min "
                + "y una vez hecho ponerlo a hervir durante 5 min", "7min"));
    }

    //We use a singleton to persist the data across all the HTTP requests.
    public static RecipesMockedData getInstance() {
        if (recipesMockedData != null) {
            return recipesMockedData;
        }
        return new RecipesMockedData();
    }


    @Override
    public Optional<Recipe> getRecipeByIndex(int index) {
        return recipes.stream()
                .filter(recipe -> recipe.getIndex() == index)
                .findAny();
    }

//    @Override
//    public List<Recipe> getRecipeByContent(String keyWord) {
//        return recipes.stream()
//                .filter(recipe -> recipe.getDescription().contains(keyWord))
//                .collect(Collectors.toList());
//    }

    @Override
    public List<Recipe> getRecipeByName(String title) {
        return recipes.stream()
                .filter(recipe -> recipe.getName().contains(title))
                .collect(Collectors.toList());
    }

    @Override
    public List<Recipe> getRecipeByTime(String time) {
        return recipes.stream()
                .filter(recipe -> recipe.getTimeToComplete().equalsIgnoreCase(time))
                .collect(Collectors.toList());
    }
}
