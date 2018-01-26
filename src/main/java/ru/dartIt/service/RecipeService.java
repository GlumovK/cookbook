package ru.dartIt.service;

import ru.dartIt.model.Recipe;

import ru.dartIt.util.exception.NotFoundException;

import java.util.List;

public interface RecipeService {
   // Recipe create(Recipe recipe);

    Recipe create(Recipe recipe, int userId);

    void delete(int id) throws NotFoundException;

    Recipe get(int id) throws NotFoundException;

    //  void update(Recipe recipe);
    Recipe update(Recipe recipe, int userId) throws NotFoundException;

    List<Recipe> getByIngredient(int ingredientId);

    List<Recipe> getByCatalog(int catalogId);

    List<Recipe> getByUser(int userId);

    List<Recipe> getByName(String name);

    List<Recipe> getAll();
}
