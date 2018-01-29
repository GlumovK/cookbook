package ru.dartIt.repository;

import ru.dartIt.model.Recipe;

import java.util.List;

public interface RecipeRepository {

    Recipe save(Recipe recipe, int userId);

    boolean delete(int id);

    Recipe get(int id);

    Recipe get(int id, int userId);

    List<Recipe> getByName(String name);

    List<Recipe> getByIngredient(String ingredientName);

    List<Recipe> getByCatalog(String catalogName);

    List<Recipe> getByUser(String userName);

    List<Recipe> getAll();
}
