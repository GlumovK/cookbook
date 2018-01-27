package ru.dartIt;

import ru.dartIt.model.Ingredient;
import ru.dartIt.model.Recipe;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.dartIt.model.AbstractBaseEntity.START_SEQ;

public class RecipeTestData {


    public static final int BORSCH_ID = START_SEQ+2;


    public static final Recipe BORSCH = new Recipe(BORSCH_ID, "Borsch", "Суп со свеклой", "алгоритм борща", 20);
    public static final Recipe MUSHROOM_SOUP = new Recipe(BORSCH_ID+1, "Mushroom soup", "Суп с грибами", "алгоритм грибовницы", 15);
    public static final Recipe OLIVIE = new Recipe(BORSCH_ID+2, "Olivie", "Салат с мясом", "алгоритм оливье", 26);
    public static final Recipe OMELETTE = new Recipe(BORSCH_ID+3, "Omelette", "Жареные яйца", "алгоритм яишницы", 11);
    public static final Recipe CAPPUCCINO = new Recipe(BORSCH_ID+4, "Cappuccino", "Кофе с молоком", "алгоритм капучино", 42);

    public static Recipe getUpdated() {
        return new Recipe(BORSCH_ID, "Borsch", "Суп со свеклой", "алгоритм борща",  33);
    }


    public static void assertMatch(Recipe actual, Recipe expected) {
        assertThat(actual).isEqualToIgnoringGivenFields(expected, "user", "ingredients", "catalogs");
    }



    public static void assertMatch(Iterable<Recipe> actual, Recipe... expected) {
        assertMatch(actual, Arrays.asList(expected));
    }

    public static void assertMatch(Iterable<Recipe> actual, Iterable<Recipe> expected) {
        assertThat(actual).usingElementComparatorIgnoringFields("user", "ingredients", "catalogs").isEqualTo(expected);
    }

}
