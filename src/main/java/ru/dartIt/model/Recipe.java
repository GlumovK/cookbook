package ru.dartIt.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;


public class Recipe extends AbstractNamedEntity {

    public static final String ALL = "Recipe.getAll";
    public static final String DELETE = "Recipe.delete";
    public static final String BY_INGREDIENT = "Recipe.byIngredient";
    public static final String BY_CATALOG = "Recipe.byCatalog";
    public static final String BY_USER = "Recipe.byUser";
    public static final String BY_NAME = "Recipe.byName";


    private String description;


    private String cookAlgorithm;


    private User user;


    private int rating;


    private Set<Ingredient> ingredients = new HashSet<>();


    private Set<Catalog> catalogs = new HashSet<>();

    public Recipe() {
    }

    public Recipe(String name, String description, String cookAlgorithm) {
        this(null, name, description, cookAlgorithm, 0);
    }

    public Recipe(Integer id, String name, String description, String cookAlgorithm, int rating) {
        super(id, name);
        this.description = description;
        this.cookAlgorithm = cookAlgorithm;
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCookAlgorithm() {
        return cookAlgorithm;
    }

    public void setCookAlgorithm(String cookAlgorithm) {
        this.cookAlgorithm = cookAlgorithm;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Set<Catalog> getCatalogs() {
        return catalogs;
    }

    public void setCatalogs(Set<Catalog> catalogs) {
        this.catalogs = catalogs;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", name=" + name +
                ", description='" + description +
                ", cookAlgorithm=" + cookAlgorithm +
                ", rating=" + rating +
                '}';
    }
}
