package ru.dartIt.model;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


public class Ingredient extends AbstractNamedEntity {

    public static final String DELETE = "Ingredient.delete";
    public static final String BY_NAME = "Ingredient.getByName";
    public static final String ALL = "Ingredient.getAll";

    public Ingredient() {
    }

    public Ingredient(Ingredient i) {
        this(i.getId(), i.getName());
    }

    public Ingredient(Integer id, String name) {
        super(id, name);
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }
}


