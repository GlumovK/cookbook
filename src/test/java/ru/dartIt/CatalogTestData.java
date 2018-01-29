package ru.dartIt;

import ru.dartIt.model.Catalog;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.dartIt.model.AbstractBaseEntity.START_SEQ;

public class CatalogTestData {
    public static final int SOUP_ID = START_SEQ + 7;

    public static final Catalog SOUP = new Catalog(SOUP_ID, "Soup");
    public static final Catalog SECOND_COURSE = new Catalog(SOUP_ID + 1, "Second course");
    public static final Catalog SNACK = new Catalog(SOUP_ID + 2, "Snack");
    public static final Catalog SALAD = new Catalog(SOUP_ID + 3, "Salad");
    public static final Catalog DRINK = new Catalog(SOUP_ID + 4, "Drink");

    public static void assertMatch(Catalog actual, Catalog expected) {
        assertThat(actual).isEqualTo(expected);
    }

    public static void assertMatch(Iterable<Catalog> actual, Catalog... expected) {
        assertMatch(actual, Arrays.asList(expected));
    }

    public static void assertMatch(Iterable<Catalog> actual, Iterable<Catalog> expected) {
        assertThat(actual).isEqualTo(expected);
    }

}
