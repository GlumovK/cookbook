package ru.dartIt.service;

import ru.dartIt.model.Recipe;

import ru.dartIt.util.exception.NotFoundException;

import java.util.List;

public interface RecipeService {
    Recipe create(Recipe recipe);

    void delete(int id) throws NotFoundException;

    Recipe get(int id) throws NotFoundException;

    void update(Recipe recipe);

    List<Recipe> getByIngredient(int ingredientId);

    List<Recipe> getByCatalog(int catalogId);

    List<Recipe> getAll();
}
