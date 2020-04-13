package com.rs.controller;

import com.rs.controller.dto.Result;
import com.rs.controller.exceptions.InputValidationException;
import com.rs.db.RecipesMockedData;
import com.rs.db.RecipesStorage;
import com.rs.db.dto.Recipe;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class RecipesSystemController {

    public final ProcessResult processResult = new ProcessResult();

    @GetMapping("/recipes/{id}")
    public ResponseEntity<Result> getRecipesByIndex(@PathVariable String id) throws InputValidationException {
        UriInputValidator.validateId(id);
        Optional<Result> result = processResult.getRecipesByID(Integer.parseInt(id));
        return result.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

//    @GetMapping("/recipes/name/{name}")
//    public Result getRecipesByName(@PathVariable String name) throws InputValidationException{
//        UriInputValidator.validateString(name);
//    }
}
