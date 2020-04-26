package com.rs.db;

import com.rs.db.dto.Recipe;

import java.util.List;
import java.util.Optional;

public interface RecipesStorage {

    /**
     * Obtain the Recipe from the db corresponding to the index of the recipe
     * @param index
     * @return The recipe corresponding to the index
     */
    Optional<Recipe> getRecipeByIndex(int index);


    /**
     * Obtain a lists of recipes from the db in case String name is part of the recipe's name.
     * @param name
     * @return The recipe corresponding to the index
     */
    List<Recipe> getRecipeByName(String name);

}
