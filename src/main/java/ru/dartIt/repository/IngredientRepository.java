package ru.dartIt.repository;

import ru.dartIt.model.Ingredient;

import java.util.List;

public interface IngredientRepository {

    Ingredient save(Ingredient ingredient);

    boolean delete(int id);

    Ingredient get(int id);

    Ingredient getByName(String name);

    List<Ingredient> getAll();
}
