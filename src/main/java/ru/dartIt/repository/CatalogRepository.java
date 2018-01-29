package ru.dartIt.repository;

import ru.dartIt.model.Catalog;

import java.util.List;

public interface CatalogRepository {
    Catalog save(Catalog catalog);

    boolean delete(int id);

    Catalog get(int id);

    Catalog getByName(String name);

    List<Catalog> getAll();
}
