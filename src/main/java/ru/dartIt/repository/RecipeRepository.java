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

 //void addVote (int id);


    List<Recipe> getByName(String name);

    List<Recipe> getByIngredient(String ingredientName);

    List<Recipe> getByCatalog(String catalogName);

    List<Recipe> getByUser(String userName);

    List<Recipe> getAll();
}
