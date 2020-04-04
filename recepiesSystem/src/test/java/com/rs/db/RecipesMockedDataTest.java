package com.rs.db;

import com.rs.db.dto.Recipe;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class RecipesMockedDataTest {

    private RecipesMockedData recipesMockedData;

    private static final String RECIPE_NAME = "tortilla";
    private List<Recipe> testListContainsSameName = new ArrayList(){
        {
            add(new Recipe(4, "Tortilla de patatas", "Freir patatas y tortilla", "60min"));
            add(new Recipe(2, "Tortilla francesa", "Batir los huevos " +
                    "y echarlos en la sarten", "5min"));
        }
    };
    private List<Recipe> testListSameMinutes = new ArrayList(){
        {
            add(new Recipe(1, "Huevos Fritos", "Freir los huevos", "5min"));
            add(new Recipe(2, "Tortilla francesa", "Batir los huevos " +
                    "y echarlos en la sarten", "5min"));
        }
    };


    @BeforeAll
    public void setUp() {
        recipesMockedData = RecipesMockedData.getInstance();
    }

    @Test
    void getRecipeFromIndex() {
        Recipe recipeData = new Recipe(2, "Tortilla francesa", "Batir los huevos " +
                "y echarlos en la sarten", "5min");

        Optional<Recipe> recipe = recipesMockedData.getRecipeByIndex(2);
        assertEquals(recipeData, recipe.get());
    }

    @Test
    void getReceipeFromName() {
        List<Recipe> recipes = recipesMockedData.getRecipeByName(RECIPE_NAME);
        Assertions.assertEquals(testListContainsSameName.size(), recipes.size());
    }

}