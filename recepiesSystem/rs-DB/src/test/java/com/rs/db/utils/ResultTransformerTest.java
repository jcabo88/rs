package com.rs.db.utils;

import com.rs.db.dto.Ingredient;
import com.rs.db.dto.Recipe;
import com.rs.db.dto.RecipeDB;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ResultTransformerTest {

    List<Ingredient> ingredients1 = new ArrayList() {
        {
            add(new Ingredient("huevo", ""));
            add(new Ingredient("sal", ""));
        }
    };
    Recipe recipe = new Recipe(2, "Tortilla francesa", "Batir los huevos y echarlos en la sarten", "5min",
            1, "", ingredients1);

    RecipeDB recipedb = new RecipeDB(2 , "Tortilla francesa", "Batir los huevos y echarlos en la sarten", "5min",
            1, "huevo, sal", "");

    @Test
    void mapToRecipe() {
        Optional<Recipe> rcp = ResultTransformer.mapToRecipe(recipedb);
        Assertions.assertTrue(recipe.equals(rcp.get()));
    }

    @Test
    void emptyRecipe(){
        Optional<Recipe> rcp = ResultTransformer.mapToRecipe(null);
        Assertions.assertEquals(rcp, Optional.empty());
    }
}