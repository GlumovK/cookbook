package ru.dartIt.model;


public class Ingredient extends AbstractNamedEntity {

    public Ingredient() {
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


