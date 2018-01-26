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
public class RecipeServiceImpl implements RecipeService{

    private final RecipeRepository repository;

    @Autowired
    public RecipeServiceImpl(RecipeRepository repository) {
        this.repository = repository;
    }

//    @Override
//    public Recipe create(Recipe recipe) {
//        Assert.notNull(recipe, "recipe must not be null");
//        return repository.save(recipe);
//    }
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
    public List<Recipe> getByIngredient(int ingredientId){
        Assert.notNull(ingredientId, "ingredientId must not be null");
        return repository.getByIngredient(ingredientId);
    }

    @Override
    public List<Recipe> getByCatalog(int catalogId) {
        Assert.notNull(catalogId, "catalogId must not be null");
        return repository.getByCatalog(catalogId);
    }
    @Override
    public List<Recipe> getByName(String name){
        Assert.notNull(name, "name must not be null");
        return repository.getByName(name);
    }

    @Override
    public List<Recipe> getByUser(int userId){
        Assert.notNull(userId, "userId must not be null");
        return repository.getByUser(userId);
    }

    @Override
    public List<Recipe> getAll() {
        return repository.getAll();
    }

//    @Override
//    public void update(Recipe recipe) {
//        Assert.notNull(recipe, "recipe must not be null");
//        checkNotFoundWithId(repository.save(recipe), recipe.getId());
//    }
@Override
public Recipe update(Recipe recipe, int userId) {
    return checkNotFoundWithId(repository.save(recipe, userId), recipe.getId());
}
}

