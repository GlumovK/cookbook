package ru.dartIt.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@NamedQueries({
        @NamedQuery(name = Recipe.ALL, query = "SELECT r FROM Recipe r "),
        @NamedQuery(name = Recipe.DELETE, query = "DELETE FROM Recipe r WHERE r.id=:id"),
        @NamedQuery(name = Recipe.BY_INGREDIENT, query = "SELECT r FROM Recipe r join r.ingredients i WHERE i.name=?1"),
        @NamedQuery(name = Recipe.BY_CATALOG, query = "SELECT r FROM Recipe r join r.catalogs c WHERE c.name=?1"),
        @NamedQuery(name = Recipe.BY_USER, query = "SELECT r FROM Recipe r WHERE r.user.name=?1"),
        @NamedQuery(name = Recipe.BY_NAME, query = "SELECT r FROM Recipe r WHERE r.name=?1"),
})

@Entity
@Table(name = "recipes")
public class Recipe extends AbstractNamedEntity {

    public static final String ALL = "Recipe.getAll";
    public static final String DELETE = "Recipe.delete";
    public static final String BY_INGREDIENT = "Recipe.byIngredient";
    public static final String BY_CATALOG = "Recipe.byCatalog";
    public static final String BY_USER = "Recipe.byUser";
    public static final String BY_NAME = "Recipe.byName";

    @Column(name = "description", nullable = false)
    @NotBlank
    @Size(min = 2, max = 120)
    private String description;

    @Column(name = "cookAlgorithm", nullable = false)
    @NotBlank
    private String cookAlgorithm;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private User user;

    @Column(name = "rating", nullable = false)
    private int rating;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "ingredient_to_recipe",
            joinColumns = {@JoinColumn(name = "recipe_id")},
            inverseJoinColumns = {@JoinColumn(name = "ingredient_id")})
    private Set<Ingredient> ingredients = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "catalog_to_recipe",
            joinColumns = {@JoinColumn(name = "recipe_id")},
            inverseJoinColumns = {@JoinColumn(name = "catalog_id")})
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
