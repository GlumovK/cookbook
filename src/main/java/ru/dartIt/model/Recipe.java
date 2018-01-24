package ru.dartIt.model;

import java.util.List;

public class Recipe extends AbstractNamedEntity {

    String description;
    Ingredient ingredient;
    String cookAlgorithm;
    User user;
    int rating;
    protected List<Catalog> catalogs;

    public Recipe() {
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

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
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
