package com.rs.db;

import com.rs.db.dto.Recipe;
import com.rs.db.exceptions.DatabaseException;
import com.rs.db.utils.ResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class RecipesStorageDB implements RecipesStorage {

    @Autowired
    RecipesRepository recipesRepository;

    public RecipesStorageDB() {
    }

    @Override
    public Optional<Recipe> getRecipeByIndex(int index) {
        try {
            return ResultTransformer.mapToRecipe(recipesRepository.findById(index));
        } catch (Exception e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    @Override
    public List<Recipe> getRecipeByName(String name) {
        return null;
    }
}
