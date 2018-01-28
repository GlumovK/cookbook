package ru.dartIt.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.bridge.SLF4JBridgeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;
import ru.dartIt.model.Recipe;


import java.util.List;

import static ru.dartIt.CatalogTestData.SOUP_ID;
import static ru.dartIt.IngredientTestData.POTATOES_ID;
import static ru.dartIt.RecipeTestData.*;
import static ru.dartIt.UserTestData.USER_ID;


@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringRunner.class)
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public class RecipeServiceTest {
    static {
        // Only for postgres driver logging
        // It uses java.util.logging and logged via jul-to-slf4j bridge
        SLF4JBridgeHandler.install();
    }

    @Autowired
    private RecipeService service;

    @Test
    public void get() throws Exception {
        Recipe recipe = service.get(BORSCH_ID);
        assertMatch(recipe, BORSCH);
    }
    @Test
    public void getAll() throws Exception {
        List<Recipe> all = service.getAll();
        assertMatch(all, BORSCH, MUSHROOM_SOUP, OLIVIE, OMELETTE, CAPPUCCINO);
    }
    @Test
    public void create() throws Exception {
        Recipe newRecipe = new Recipe( "New", "New desc", "New Algo");
        Recipe created = service.create(newRecipe, USER_ID);
       // newRecipe.setId(created.getId());
        assertMatch(service.getAll(), BORSCH, MUSHROOM_SOUP, OLIVIE, OMELETTE, CAPPUCCINO, newRecipe);
    }
//@Test
//public void getByIngredient() throws Exception {
//    List<Recipe> all = service.getByIngredient(POTATOES_ID);
//    assertMatch(all, BORSCH, MUSHROOM_SOUP, OLIVIE);
//}

//    @Test
//    public void getByCatalog() throws Exception {
//        List<Recipe> all = service.getByCatalog(SOUP_ID);
//        assertMatch(all, BORSCH, MUSHROOM_SOUP);
//    }

        @Test
        public void getByName() throws Exception {
            List<Recipe> all = service.getByName("Borsch");
            assertMatch(all, BORSCH);
    }
//    @Test
//    public void getByUser() throws Exception {
//        List<Recipe> all = service.getByUser(USER_ID);
//        System.out.println("!!!");
//        for (Recipe recipe : all) {
//            // recipe.getName();
//            System.out.println( recipe.getName());
//        }
//        System.out.println("!!!");
//        assertMatch(all, BORSCH, MUSHROOM_SOUP);
//    }

    @Test
    public void update() throws Exception {
        Recipe updated = getUpdated();
        service.update(updated, USER_ID);
        assertMatch(service.get(BORSCH_ID), updated);
    }


}
