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

import ru.dartIt.repository.CatalogRepository;


import javax.sql.DataSource;
import java.util.List;

@Repository
public class JdbcCatalogRepositoryImpl implements CatalogRepository {

    private static final BeanPropertyRowMapper<Catalog> ROW_MAPPER = BeanPropertyRowMapper.newInstance(Catalog.class);

    private final JdbcTemplate jdbcTemplate;

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final SimpleJdbcInsert insertCatalog;

    @Autowired
    public JdbcCatalogRepositoryImpl(DataSource dataSource, JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.insertCatalog = new SimpleJdbcInsert(dataSource)
                .withTableName("catalogs")
                .usingGeneratedKeyColumns("id");

        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public Catalog save(Catalog catalog) {
        BeanPropertySqlParameterSource parameterSource = new BeanPropertySqlParameterSource(catalog);

        if (catalog.isNew()) {
            Number newKey = insertCatalog.executeAndReturnKey(parameterSource);
            catalog.setId(newKey.intValue());
        } else if (namedParameterJdbcTemplate.update(
                "UPDATE catalogs SET name=:name WHERE id=:id", parameterSource) == 0) {
            return null;
        }
        return catalog;
    }

    @Override
    public boolean delete(int id) {
        return jdbcTemplate.update("DELETE FROM catalogs WHERE id=?", id) != 0;
    }

    @Override
    public Catalog get(int id) {
        List<Catalog> catalogs = jdbcTemplate.query("SELECT * FROM catalogs WHERE id=?", ROW_MAPPER, id);
        return DataAccessUtils.singleResult(catalogs);
    }

    @Override
    public Catalog getByName(String name) {
//        return jdbcTemplate.queryForObject("SELECT * FROM users WHERE email=?", ROW_MAPPER, email);
        List<Catalog> catalogs = jdbcTemplate.query("SELECT * FROM catalogs WHERE name=?", ROW_MAPPER, name);
        return DataAccessUtils.singleResult(catalogs);
    }

    @Override
    public List<Catalog> getAll() {
        return jdbcTemplate.query("SELECT * FROM catalogs", ROW_MAPPER);
    }
}
