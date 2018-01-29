package ru.dartIt.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.bridge.SLF4JBridgeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;
import ru.dartIt.model.Ingredient;
import ru.dartIt.util.exception.NotFoundException;
import java.util.List;
import static ru.dartIt.IngredientTestData.*;

@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringRunner.class)
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public class IngredientServiceTest {
    static {
        // Only for postgres driver logging
        // It uses java.util.logging and logged via jul-to-slf4j bridge
        SLF4JBridgeHandler.install();
    }

    @Autowired
    private IngredientService service;

    @Test
    public void get() throws Exception {
        Ingredient ingredient = service.get(POTATOES_ID);
        assertMatch(ingredient, POTATOES);
    }

    @Test
    public void getAll() throws Exception {
        List<Ingredient> all = service.getAll();
        assertMatch(all, POTATOES, BEET, MUSHROOM, MEAT, PEASE, EGG, COFFEE);
    }
    @Test
    public void create() throws Exception {
        Ingredient newIngredient = new Ingredient(null, "New");
        Ingredient created = service.create(newIngredient);
        newIngredient.setId(created.getId());
        assertMatch(service.getAll(),POTATOES, BEET, MUSHROOM, MEAT, PEASE, EGG, COFFEE, newIngredient);
    }
    @Test
    public void delete() throws Exception {
        service.delete(POTATOES_ID);
        assertMatch(service.getAll(), BEET, MUSHROOM, MEAT, PEASE, EGG, COFFEE);
    }
    @Test
    public void getByName() throws Exception {
        Ingredient ingredient = service.getByName("Potatoes");
        assertMatch(ingredient, POTATOES);
    }
    @Test
    public void update() throws Exception {
        Ingredient updated = new Ingredient(POTATOES);
        updated.setName("UpdatedName");
        service.update(updated);
        assertMatch(service.get(POTATOES_ID), updated);
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
