package ru.dartIt.repository;




import ru.dartIt.model.Ingredient;

import java.util.List;

public interface IngredientRepository {
    Ingredient save(Ingredient ingredient);

    // false if not found
    boolean delete(int id);

    // null if not found
    Ingredient get(int id);

    Ingredient getByName(String name);

    List<Ingredient> getAll();
}
