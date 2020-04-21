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
    public Optional<Recipe> getRecipeByIndex(int index);

//    /**
//     * Obtain the Recipe from the db when
//     * @param keyWord
//     * @return
//     */
//    public List<Recipe> getRecipeByContent(String keyWord);

    public List<Recipe> getRecipeByName(String name);

    public List<Recipe> getRecipeByTime(String time);
}
