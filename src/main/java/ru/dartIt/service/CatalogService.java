package ru.dartIt.service;

import ru.dartIt.model.Catalog;
import ru.dartIt.model.User;
import ru.dartIt.util.exception.NotFoundException;

import java.util.List;

public interface CatalogService {
    Catalog create(Catalog catalog);

    void delete(int id) throws NotFoundException;

    Catalog get(int id) throws NotFoundException;

    Catalog getByName(String name) throws NotFoundException;

    void update(Catalog catalog);

    List<Catalog> getAll();
}
