package ru.dartIt.model;




public class Catalog extends AbstractNamedEntity {

    public static final String DELETE = "Catalog.delete";
    public static final String BY_NAME = "Catalog.getByName";
    public static final String ALL = "Catalog.getAll";

    public Catalog() {
    }

    public Catalog(Catalog c) {
        this(c.getId(), c.getName());
    }

    public Catalog(Integer id, String name) {
        super(id, name);
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }
}
