package com.rs.db;

import com.rs.db.dto.Ingredient;
import com.rs.db.dto.Recipe;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class RecipesMockedData implements RecipesStorage {
    private static RecipesMockedData recipesMockedData = null;

    private List<Recipe> recipes;

    public RecipesMockedData() {
        List<Ingredient> ingredients1 = new ArrayList<>();
        ingredients1.add(new Ingredient("egg", "1"));
        ingredients1.add(new Ingredient("salt", "20g"));
        List<Ingredient> ingredients2 = new ArrayList<>();
        ingredients2.add(new Ingredient("rice", "200g"));
        ingredients2.add(new Ingredient("salt", "20g"));

        this.recipes = new ArrayList<>();
        recipes.add(new Recipe(1, "Huevos Fritos", "Freir los huevos", "5min",
                1, "", ingredients1));
        recipes.add(new Recipe(2, "Tortilla francesa", "Batir los huevos y echarlos en la sarten", "5min",
                1, "", ingredients1));
        recipes.add(new Recipe(2, "Tortilla patatas", "Batir los huevos y echarlos en la sarten", "60min",
                1, "", ingredients1));
        recipes.add(new Recipe(3, "Arroz blanco", "Freir el arroz durante 2 min "
                + "y una vez hecho ponerlo a hervir durante 5 min", "7min", 2, "", ingredients2));
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
    public List<Recipe> getRecipeByName(String recipeKeyword) {
        return recipes.stream()
                .filter(recipe -> recipe.getName().toLowerCase().contains(recipeKeyword.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Recipe> getRecipeByTime(String time) {
        return recipes.stream()
                .filter(recipe -> recipe.getTimeToComplete().equalsIgnoreCase(time))
                .collect(Collectors.toList());
    }
}
