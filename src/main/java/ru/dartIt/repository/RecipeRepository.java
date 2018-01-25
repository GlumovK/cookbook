package ru.dartIt.repository;


import ru.dartIt.model.Recipe;

import java.util.List;

public interface RecipeRepository {
    Recipe save(Recipe recipe);

    // false if not found
    boolean delete(int id);

    // null if not found
    Recipe get(int id);

    List<Recipe> getAll();
}
