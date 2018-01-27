package ru.dartIt.repository;

import ru.dartIt.model.Catalog;


import java.util.List;

public interface CatalogRepository {
    Catalog save(Catalog catalog);

    // false if not found
    boolean delete(int id);

    // null if not found
    Catalog get(int id);

    Catalog getByName(String name);

    List<Catalog> getAll();
}
