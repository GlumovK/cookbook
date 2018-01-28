package ru.dartIt.web;

import org.springframework.beans.factory.annotation.Autowired;
import ru.dartIt.AuthorizedUser;
import ru.dartIt.model.Recipe;
import ru.dartIt.service.RecipeService;

import java.util.List;

import static ru.dartIt.util.ValidationUtil.assureIdConsistent;
import static ru.dartIt.util.ValidationUtil.checkNew;

public class AbstractRecipeController {

    @Autowired
    private RecipeService service;

    public List<Recipe> getByUser(String userName) {
        return service.getByUser(userName);
    }

    public List<Recipe>  getByIngredient(String ingredientName) {
        return service.getByIngredient(ingredientName);
    }

    public List<Recipe>  getByName(String name) {
        return service.getByName(name);
    }
    public List<Recipe> getByCatalog(String catalogName) {
        return service.getByCatalog(catalogName);
    }

    public Recipe create(Recipe recipe) {
        int userId = AuthorizedUser.id();
        checkNew(recipe);
        return service.create(recipe, userId);
    }
    public void update(Recipe recipe, int id) {
        int userId = AuthorizedUser.id();
        assureIdConsistent(recipe, id);
        service.update(recipe, userId);
    }

       public void addVote(int id) {
           int userId = AuthorizedUser.id();
           Recipe recipe = service.get(id);
           recipe.setRating(recipe.getRating()+1);
           service.update(recipe, userId);
       }

    public void subtractVote(int id) {
        int userId = AuthorizedUser.id();
        Recipe recipe = service.get(id);
        recipe.setRating(recipe.getRating()-1);
        service.update(recipe, userId);
    }
}
