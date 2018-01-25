package ru.dartIt.repository;

import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.dartIt.model.Catalog;
import ru.dartIt.model.Ingredient;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class JpaIngredientRepositoryImpl implements IngredientRepository{


    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public Ingredient save(Ingredient ingredient) {
        if (ingredient.isNew()) {
            em.persist(ingredient);
            return ingredient;
        } else {
            return em.merge(ingredient);
        }
    }

    @Override
    public Ingredient get(int id) {
        return em.find(Ingredient.class, id);
    }

    @Override
    @Transactional
    public boolean delete(int id) {

        return em.createNamedQuery(Ingredient.DELETE)
                .setParameter("id", id)
                .executeUpdate() != 0;
    }

    @Override
    public Ingredient getByName(String name) {
        List<Ingredient> ingredients = em.createNamedQuery(Ingredient.BY_NAME, Ingredient.class)
                .setParameter(1, name)
                .getResultList();
        return DataAccessUtils.singleResult(ingredients);
    }

    @Override
    public List<Ingredient> getAll() {
        return em.createNamedQuery(Ingredient.ALL, Ingredient.class).getResultList();
    }
}




