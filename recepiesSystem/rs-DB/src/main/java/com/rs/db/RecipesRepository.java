package com.rs.db;

import com.rs.db.dto.RecipeDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipesRepository extends JpaRepository<RecipeDB, Integer> {

    //List<RecipeDB> findByNameRecipeContaining(String name);

    RecipeDB findById(int id);
}