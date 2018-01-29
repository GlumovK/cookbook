package ru.dartIt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.dartIt.model.Ingredient;
import ru.dartIt.repository.IngredientRepository;
import ru.dartIt.util.exception.NotFoundException;

import java.util.List;

import static ru.dartIt.util.ValidationUtil.checkNotFound;
import static ru.dartIt.util.ValidationUtil.checkNotFoundWithId;

@Service
public class IngredientServiceImpl implements IngredientService {
    private final IngredientRepository repository;

    @Autowired
    public IngredientServiceImpl(IngredientRepository repository) {
        this.repository = repository;
    }

    @Override
    public Ingredient create(Ingredient ingredient) {
        Assert.notNull(ingredient, "catalog must not be null");
        return repository.save(ingredient);
    }

    @Override
    public void delete(int id) throws NotFoundException {
        checkNotFoundWithId(repository.delete(id), id);
    }

    @Override
    public Ingredient get(int id) throws NotFoundException {
        return checkNotFoundWithId(repository.get(id), id);
    }

    @Override
    public Ingredient getByName(String name) throws NotFoundException {
        Assert.notNull(name, "name must not be null");
        return checkNotFound(repository.getByName(name), "name=" + name);
    }

    @Override
    public List<Ingredient> getAll() {
        return repository.getAll();
    }

    @Override
    public void update(Ingredient ingredient) {
        Assert.notNull(ingredient, "ingredient must not be null");
        checkNotFoundWithId(repository.save(ingredient), ingredient.getId());
    }
}


