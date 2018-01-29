package ru.dartIt.service;

import ru.dartIt.model.Ingredient;
import ru.dartIt.util.exception.NotFoundException;

import java.util.List;

public interface IngredientService {

    Ingredient create(Ingredient ingredient);

    void delete(int id) throws NotFoundException;

    Ingredient get(int id) throws NotFoundException;

    Ingredient getByName(String name) throws NotFoundException;

    void update(Ingredient ingredient);

    List<Ingredient> getAll();
}
