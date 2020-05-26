package com.rs.controller;

import com.rs.controller.dto.Result;
import com.rs.db.RecipesStorage;
import com.rs.db.dto.Ingredient;
import com.rs.db.dto.Recipe;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ProcessResultTest {

    @InjectMocks
    private ProcessResult processResult;

    @Mock
    private RecipesStorage recipesStorage;


    private static final String RECIPE_NOT_FOUND = "Recipe not Found";
    private static final String RECIPE_NAME = "Tortilla";
    private static final String RECIPE_NAME_NO_EXIST = "Judias";

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

    @BeforeAll
    public void initMocks(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getRecipeFromIndex() {
        Mockito.lenient().when(recipesStorage.getRecipeByIndex(1)).thenReturn(Optional.of(recipeHuevosFritos));
        Optional<Result> result = processResult.getRecipesByID(1);
        assertTrue(recipeHuevosFritos.equals(result.get().getResult().getRecipes()));
    }

    @Test
    void getRecipeFromIndexEmptyResult() {
//        when(recipesStorage.getRecipeByIndex(20)).thenReturn(Optional.empty());
        Optional<Result> result = processResult.getRecipesByID(20);
        assertTrue(RECIPE_NOT_FOUND.equals(result.get().getResult().getMessage()));
    }

    @Test
    void getRecipeFromName() {
        Mockito.lenient().when(recipesStorage.getRecipeByName(RECIPE_NAME))
                .thenReturn(testListContainsSameName);
        Optional<Result> result = processResult.getRecipesByName(RECIPE_NAME);

        Assertions.assertEquals(2,
                ((ArrayList)result.get().getResult().getRecipes()).size());
    }

    @Test
    void getRecipeFromNameEmptyResult() {
//        Mockito.lenient().when(recipesStorage.getRecipeByName(RECIPE_NAME)).thenReturn(Optional.of(testListContainsSameName));
        Optional<Result> result = processResult.getRecipesByName(RECIPE_NAME_NO_EXIST);
        assertTrue(RECIPE_NOT_FOUND.equals(result.get().getResult().getMessage()));
    }

}