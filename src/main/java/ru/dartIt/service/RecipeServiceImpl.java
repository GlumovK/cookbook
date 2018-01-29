package ru.dartIt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.dartIt.model.Recipe;
import ru.dartIt.repository.RecipeRepository;
import ru.dartIt.util.exception.NotFoundException;

import java.util.List;

import static ru.dartIt.util.ValidationUtil.checkNotFoundWithId;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository repository;

    @Autowired
    public RecipeServiceImpl(RecipeRepository repository) {
        this.repository = repository;
    }

    @Override
    public Recipe create(Recipe recipe, int userId) {
        Assert.notNull(recipe, "recipe must not be null");
        return repository.save(recipe, userId);
    }

    @Override
    public void delete(int id) throws NotFoundException {
        checkNotFoundWithId(repository.delete(id), id);
    }

    @Override
    public Recipe get(int id) throws NotFoundException {
        return checkNotFoundWithId(repository.get(id), id);
    }

    public List<Recipe> getByIngredient(String ingredientName) {
        Assert.notNull(ingredientName, "ingredientName must not be null");
        return repository.getByIngredient(ingredientName);
    }

    @Override
    public List<Recipe> getByCatalog(String catalogName) {
        Assert.notNull(catalogName, "catalogName must not be null");
        return repository.getByCatalog(catalogName);
    }

    @Override
    public List<Recipe> getByName(String name) {
        Assert.notNull(name, "name must not be null");
        return repository.getByName(name);
    }

    @Override
    public List<Recipe> getByUser(String userName) {
        Assert.notNull(userName, "userName must not be null");
        return repository.getByUser(userName);
    }

    @Override
    public List<Recipe> getAll() {
        return repository.getAll();
    }

    @Override
    public Recipe update(Recipe recipe, int userId) {
        return checkNotFoundWithId(repository.save(recipe, userId), recipe.getId());
    }
}

