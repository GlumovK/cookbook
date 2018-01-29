package ru.dartIt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.dartIt.model.Catalog;
import ru.dartIt.repository.CatalogRepository;
import ru.dartIt.util.exception.NotFoundException;

import java.util.List;

import static ru.dartIt.util.ValidationUtil.checkNotFound;
import static ru.dartIt.util.ValidationUtil.checkNotFoundWithId;

@Service
public class CatalogServiceImpl implements CatalogService {

    private final CatalogRepository repository;

    @Autowired
    public CatalogServiceImpl(CatalogRepository repository) {
        this.repository = repository;
    }

    @Override
    public Catalog create(Catalog catalog) {
        Assert.notNull(catalog, "catalog must not be null");
        return repository.save(catalog);
    }

    @Override
    public void delete(int id) throws NotFoundException {
        checkNotFoundWithId(repository.delete(id), id);
    }

    @Override
    public Catalog get(int id) throws NotFoundException {
        return checkNotFoundWithId(repository.get(id), id);
    }

    @Override
    public Catalog getByName(String name) throws NotFoundException {
        Assert.notNull(name, "name must not be null");
        return checkNotFound(repository.getByName(name), "name=" + name);
    }

    @Override
    public List<Catalog> getAll() {
        return repository.getAll();
    }

    @Override
    public void update(Catalog catalog) {
        Assert.notNull(catalog, "catalog must not be null");
        checkNotFoundWithId(repository.save(catalog), catalog.getId());
    }
}
