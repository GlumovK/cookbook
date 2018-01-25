package ru.dartIt.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.bridge.SLF4JBridgeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;
import ru.dartIt.CatalogTestData;

import ru.dartIt.model.Catalog;
import ru.dartIt.util.exception.NotFoundException;


import java.util.List;

import static ru.dartIt.CatalogTestData.*;




@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringRunner.class)
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public class CatalogServiceTest {
    static {
        // Only for postgres driver logging
        // It uses java.util.logging and logged via jul-to-slf4j bridge
        SLF4JBridgeHandler.install();
    }

    @Autowired
    private CatalogService service;

    @Test
    public void get() throws Exception {
        Catalog catalog = service.get(SOUP_ID);
        assertMatch(catalog, SOUP);
    }
    @Test
    public void getAll() throws Exception {
        List<Catalog> all = service.getAll();
        CatalogTestData.assertMatch(all, SOUP, SECOND_COURSE, SNACK, SALAD, DRINK);
    }
    @Test
    public void create() throws Exception {
        Catalog newCatalog = new Catalog(null, "New");
        Catalog created = service.create(newCatalog);
        newCatalog.setId(created.getId());
        assertMatch(service.getAll(),SOUP, SECOND_COURSE, SNACK, SALAD, DRINK, newCatalog);
    }
    @Test
    public void delete() throws Exception {
        service.delete(SOUP_ID);
        assertMatch(service.getAll(), SECOND_COURSE, SNACK, SALAD, DRINK);
    }
    @Test
    public void getByName() throws Exception {
        Catalog ingredient = service.getByName("Soup");
        assertMatch(ingredient, SOUP);
    }
    @Test
    public void update() throws Exception {
        Catalog updated = new Catalog(SOUP);
        updated.setName("UpdatedName");
        service.update(updated);
        assertMatch(service.get(SOUP_ID), updated);
    }
    @Test(expected = NotFoundException.class)
    public void getNotFound() throws Exception {
        service.get(1);
    }
    @Test(expected = NotFoundException.class)
    public void notFoundDelete() throws Exception {
        service.delete(1);
    }

}
