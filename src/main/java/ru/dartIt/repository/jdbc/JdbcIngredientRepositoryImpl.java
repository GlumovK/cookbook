package ru.dartIt.repository.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import ru.dartIt.model.Catalog;
import ru.dartIt.model.Ingredient;
import ru.dartIt.repository.CatalogRepository;
import ru.dartIt.repository.IngredientRepository;

import javax.sql.DataSource;
import java.util.List;


@Repository
public class JdbcIngredientRepositoryImpl implements IngredientRepository {

    private static final BeanPropertyRowMapper<Ingredient> ROW_MAPPER = BeanPropertyRowMapper.newInstance(Ingredient.class);

    private final JdbcTemplate jdbcTemplate;

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final SimpleJdbcInsert insertIngredient;

    @Autowired
    public JdbcIngredientRepositoryImpl(DataSource dataSource, JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.insertIngredient = new SimpleJdbcInsert(dataSource)
                .withTableName("ingredients")
                .usingGeneratedKeyColumns("id");

        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        BeanPropertySqlParameterSource parameterSource = new BeanPropertySqlParameterSource(ingredient);

        if (ingredient.isNew()) {
            Number newKey = insertIngredient.executeAndReturnKey(parameterSource);
            ingredient.setId(newKey.intValue());
        } else if (namedParameterJdbcTemplate.update(
                "UPDATE ingredients SET name=:name WHERE id=:id", parameterSource) == 0) {
            return null;
        }
        return ingredient;
    }

    @Override
    public boolean delete(int id) {
        return jdbcTemplate.update("DELETE FROM ingredients WHERE id=?", id) != 0;
    }

    @Override
    public Ingredient get(int id) {
        List<Ingredient> ingredients = jdbcTemplate.query("SELECT * FROM ingredients WHERE id=?", ROW_MAPPER, id);
        return DataAccessUtils.singleResult(ingredients);
    }

    @Override
    public Ingredient getByName(String name) {
//        return jdbcTemplate.queryForObject("SELECT * FROM users WHERE email=?", ROW_MAPPER, email);
        List<Ingredient> ingredients = jdbcTemplate.query("SELECT * FROM ingredients WHERE name=?", ROW_MAPPER, name);
        return DataAccessUtils.singleResult(ingredients);
    }

    @Override
    public List<Ingredient> getAll() {
        return jdbcTemplate.query("SELECT * FROM ingredients", ROW_MAPPER);
    }
}
