package ru.dartIt.repository.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import ru.dartIt.model.Recipe;
import ru.dartIt.repository.RecipeRepository;

import javax.sql.DataSource;

import java.util.List;


@Repository
public class JdbcRecipeRepositoryImpl implements RecipeRepository {

    private static final RowMapper<Recipe> ROW_MAPPER = BeanPropertyRowMapper.newInstance(Recipe.class);

    private final JdbcTemplate jdbcTemplate;

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final SimpleJdbcInsert insertRecipe;

    @Autowired
    public JdbcRecipeRepositoryImpl(DataSource dataSource, JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.insertRecipe = new SimpleJdbcInsert(dataSource)
                .withTableName("recipes")
                .usingGeneratedKeyColumns("id");

        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public Recipe save(Recipe recipe, int userId) {
        MapSqlParameterSource map = new MapSqlParameterSource()
                .addValue("id", recipe.getId())
                .addValue("name", recipe.getName())
                .addValue("description", recipe.getDescription())
                .addValue("cookAlgorithm", recipe.getCatalogs())
                .addValue("rating", recipe.getRating())
                .addValue("user_id", userId);

        if (recipe.isNew()) {
            Number newId = insertRecipe.executeAndReturnKey(map);
            recipe.setId(newId.intValue());
        } else {
            if (namedParameterJdbcTemplate.update(
                            "UPDATE recipes " +
                            "SET name=:name, description=:description, cookAlgorithm=:cookAlgorithm, rating=:rating " +
                            "WHERE id=:id AND user_id=:user_id"
                    , map) == 0) {
                return null;
            }
        }
        return recipe;
    }

    @Override
    public boolean delete(int id) {
        return jdbcTemplate.update("DELETE FROM recipes WHERE id=?", id) != 0;
    }

    @Override
    public Recipe get(int id) {
        List<Recipe> recipes = jdbcTemplate.query(
                "SELECT * FROM recipes WHERE id = ? ", ROW_MAPPER, id);
        return DataAccessUtils.singleResult(recipes);
    }

    @Override
    public Recipe get(int id, int userId) {
        return null;
    }

    @Override
    public List<Recipe> getByName(String name) {
        return jdbcTemplate.query(
                " SELECT * FROM recipes WHERE name = ? ", ROW_MAPPER, name);
    }


    @Override
    public List<Recipe> getAll() {
        return jdbcTemplate.query(
                "SELECT * FROM recipes", ROW_MAPPER);
    }

    public List<Recipe> getByIngredient(String ingredientName) {
        return jdbcTemplate.query(
                "SELECT recipes.id, recipes.name, recipes.description, recipes.cookalgorithm, recipes.user_id, recipes.rating " +
                        "FROM   recipes, ingredients, ingredient_to_recipe " +
                        "WHERE  recipes.id = ingredient_to_recipe.recipe_id " +
                        "AND   ingredients.id = ingredient_to_recipe.ingredient_id " +
                        "AND ingredients.name = ?", ROW_MAPPER, ingredientName);
    }

    public List<Recipe> getByCatalog(String catalogName) {
        return jdbcTemplate.query(
                "SELECT recipes.id, recipes.name, recipes.description, recipes.cookalgorithm, recipes.user_id, recipes.rating " +
                        "FROM   recipes, catalogs, catalog_to_recipe " +
                        "WHERE  recipes.id = catalog_to_recipe.recipe_id " +
                        "AND   catalogs.id = catalog_to_recipe.catalog_id " +
                        "AND catalogs.name = ?", ROW_MAPPER, catalogName);
    }

    public List<Recipe> getByUser(String userName) {
        return jdbcTemplate.query(
                "SELECT recipes.id, recipes.name, recipes.description, recipes.cookalgorithm, recipes.user_id, recipes.rating " +
                        "FROM recipes " +
                        "LEFT JOIN users ON recipes.user_id = users.id " +
                        "WHERE users.name = ?", ROW_MAPPER, userName);
    }
}

