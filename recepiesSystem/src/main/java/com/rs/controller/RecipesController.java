package com.rs.controller;

import com.rs.controller.exceptions.InputValidationException;
import com.rs.db.RecipesMockedData;
import com.rs.db.RecipesStorage;
import com.rs.db.dto.Recipe;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecipesController {

    private static final String INPUT_EXCEPTION = "The id is not numeric or it is not valid";

    private final RecipesStorage recipesStorage = RecipesMockedData.getInstance();

    @GetMapping("/recipes/{id}")
    public Recipe getRecipesByIndex(@PathVariable String id) throws InputValidationException {
        validateId(id);
        return recipesStorage.getRecipeByIndex(Integer.parseInt(id))
                .orElse(new Recipe());
    }

    private void validateId(String id) throws InputValidationException {
        if (StringUtils.isBlank(id) || !StringUtils.isNumeric(id)) {
            throw new InputValidationException(INPUT_EXCEPTION);
        }
    }
}
