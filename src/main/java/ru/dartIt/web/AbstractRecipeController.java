package ru.dartIt.web;

import org.springframework.beans.factory.annotation.Autowired;
import ru.dartIt.AuthorizedUser;
import ru.dartIt.model.Recipe;
import ru.dartIt.service.RecipeService;

import java.util.List;

import static ru.dartIt.util.ValidationUtil.checkNew;

public class AbstractRecipeController {

    @Autowired
    private RecipeService service;

    public List<Recipe> getByUser(int userId) {
        return service.getByUser(userId);
    }

    public List<Recipe>  getByIngredient(int ingredientId) {
        return service.getByIngredient(ingredientId);
    }

    public List<Recipe>  getByName(String name) {
        return service.getByName(name);
    }

    public Recipe create(Recipe recipe) {
        int userId = AuthorizedUser.id();
        checkNew(recipe);
        return service.create(recipe, userId);
    }
}