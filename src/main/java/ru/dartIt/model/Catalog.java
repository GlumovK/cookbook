package ru.dartIt.model;


import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.util.List;

@NamedQueries({
        @NamedQuery(name = Catalog.DELETE, query = "DELETE FROM Catalog c WHERE c.id=:id"),
        @NamedQuery(name = Catalog.BY_NAME, query = "SELECT c FROM Catalog c  WHERE c.name=?1"),
        @NamedQuery(name = Catalog.ALL, query = "SELECT c FROM Catalog c"),
})

@Entity
@Table(name = "catalogs")
public class Catalog extends AbstractNamedEntity{

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

    //protected List<Recipe> recipes;

    @Override
    public String toString() {
        return "Catalog{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }
}
