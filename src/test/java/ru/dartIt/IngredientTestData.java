package ru.dartIt;

import ru.dartIt.model.Ingredient;
import ru.dartIt.model.User;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.dartIt.model.AbstractBaseEntity.START_SEQ;

public class IngredientTestData {

    public static final int POTATOES_ID = START_SEQ + 12;


    public static final Ingredient POTATOES = new Ingredient(POTATOES_ID, "Potatoes");
    public static final Ingredient BEET = new Ingredient(POTATOES_ID + 1, "Beet");
    public static final Ingredient MUSHROOM = new Ingredient(POTATOES_ID + 2, "Mushroom");
    public static final Ingredient MEAT = new Ingredient(POTATOES_ID + 3, "Meat");
    public static final Ingredient PEASE = new Ingredient(POTATOES_ID + 4, "Pease");
    public static final Ingredient EGG = new Ingredient(POTATOES_ID + 5, "Egg");
    public static final Ingredient COFFEE = new Ingredient(POTATOES_ID + 6, "Coffee");

    public static void assertMatch(Ingredient actual, Ingredient expected) {
        assertThat(actual).isEqualTo(expected);
    }

    public static void assertMatch(Iterable<Ingredient> actual, Ingredient... expected) {
        assertMatch(actual, Arrays.asList(expected));
    }

    public static void assertMatch(Iterable<Ingredient> actual, Iterable<Ingredient> expected) {
        assertThat(actual).isEqualTo(expected);
    }


}
