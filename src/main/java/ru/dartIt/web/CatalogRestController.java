package ru.dartIt.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.dartIt.model.Catalog;
import ru.dartIt.service.CatalogService;

import java.util.List;

import static ru.dartIt.util.ValidationUtil.assureIdConsistent;
import static ru.dartIt.util.ValidationUtil.checkNew;


@Controller
public class CatalogRestController {

    @Autowired
    private CatalogService service;

    public List<Catalog> getAll() {
        return service.getAll();
    }

    public Catalog get(int id) {

        return service.get(id);
    }

    public Catalog create(Catalog catalog) {

        checkNew(catalog);
        return service.create(catalog);
    }

    public void delete(int id) {

        service.delete(id);
    }

    public void update(Catalog user, int id) {

        assureIdConsistent(user, id);
        service.update(user);
    }

    public Catalog getByName(String name) {

        return service.getByName(name);
    }
}
