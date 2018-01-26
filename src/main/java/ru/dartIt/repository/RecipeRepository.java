package ru.dartIt.repository;


import ru.dartIt.model.Ingredient;
import ru.dartIt.model.Recipe;

import java.util.List;
import java.util.Set;

public interface RecipeRepository {
    Recipe save(Recipe recipe, int userId);

   // Recipe save(Recipe recipe, int userId, int catalogId, Set<Integer> ingredientId);
    // false if not found
    boolean delete(int id);

    // null if not found
    Recipe get(int id);

    Recipe get(int id, int userId);


    List<Recipe> getByName(String name);

    List<Recipe> getByIngredient(int ingredientId);

    List<Recipe> getByCatalog(int catalogId);

    List<Recipe> getByUser(int userId);

    List<Recipe> getAll();
}
