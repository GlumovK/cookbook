package ru.dartIt.model;


import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "catalogs")
public class Catalog extends AbstractNamedEntity{


    public Catalog() {
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
