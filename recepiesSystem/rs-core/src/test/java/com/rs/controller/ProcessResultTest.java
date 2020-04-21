package com.rs.controller;

import com.rs.controller.dto.Result;
import com.rs.db.RecipesStorage;
import com.rs.db.dto.Ingredient;
import com.rs.db.dto.Recipe;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ProcessResultTest {

    private ProcessResult processResult;

    @Mock
    private RecipesStorage recipesStorage;


    private static final String RECIPE_NOT_FOUND = "Recipe not Found";

    List<Ingredient> ingredients1 = new ArrayList() {
        {
            add(new Ingredient("egg", "1"));
            add(new Ingredient("salt", "20g"));
            add(new Ingredient("potatoes", "500g"));
        }
    };

    List<Ingredient> ingredients2 = new ArrayList(){
        {
            add(new Ingredient("rice", "200g"));
            add(new Ingredient("salt", "20g"));
        }
    };

    private Recipe recipeTortillaPatatas = new Recipe(2, "Tortilla francesa", "Batir los huevos y echarlos en la sarten", "5min",
            1, "", ingredients1);
    private Recipe recipeTortillaFrancesa = new Recipe(3, "Tortilla francesa", "Batir los huevos y echarlos en la sarten", "5min",
            1, "", ingredients1);
    public Recipe recipeHuevosFritos = new Recipe(1, "Huevos Fritos", "Freir los huevos", "5min",
            1, "", ingredients1);

    private List<Recipe> testListContainsSameName = new ArrayList(){
        {
            add(recipeTortillaPatatas);
            add(recipeTortillaFrancesa);
        }
    };
    private List<Recipe> testListSameMinutes = new ArrayList(){
        {
            add(recipeHuevosFritos);
            add(recipeTortillaFrancesa);
        }
    };


    @BeforeAll
    public void setUp() {
        this.processResult = new ProcessResult();
    }

    @Test
    void getRecipeFromIndex() {
//        Mockito.lenient().when(recipesStorage.getRecipeByIndex(1)).thenReturn(Optional.of(recipeHuevosFritos));
        Optional<Result> result = processResult.getRecipesByID(1);
        assertTrue(recipeHuevosFritos.equals(result.get().getResult().getRecipe()));
    }

    @Test
    void getRecipeFromIndexEmptyResult() {
        Optional<Result> result = processResult.getRecipesByID(20);
        assertTrue(RECIPE_NOT_FOUND.equals(result.get().getResult().getMessage()));
    }

//    @Test
//    void getReceipeFromName() {
//        List<Recipe> recipes = recipesMockedData.getRecipeByName(RECIPE_NAME);
//        Assertions.assertEquals(testListContainsSameName.size(), recipes.size());
//    }

}