package ru.dartIt.model;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries({
        @NamedQuery(name = Ingredient.DELETE, query = "DELETE FROM Ingredient i WHERE i.id=:id"),
        @NamedQuery(name = Ingredient.BY_NAME, query = "SELECT i FROM Ingredient i  WHERE i.name=?1"),
        @NamedQuery(name = Ingredient.ALL, query = "SELECT i FROM Ingredient i"),
})

@Entity
@Table(name = "ingredients")
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


