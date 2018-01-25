package ru.dartIt.repository;


import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.dartIt.model.Recipe;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class JpaRecipeRepositoryImpl implements RecipeRepository{


    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public Recipe save(Recipe recipe) {
        if (recipe.isNew()) {
            em.persist(recipe);
            return recipe;
        } else {
            return em.merge(recipe);
        }
    }

    @Override
    public Recipe get(int id) {
        return em.find(Recipe.class, id);
    }

    @Override
    @Transactional
    public boolean delete(int id) {
        return em.createNamedQuery(Recipe.DELETE)
                .setParameter("id", id)
                .executeUpdate() != 0;
    }

    @Override
    public List<Recipe> getByIngredient(int ingredientId) {


        List<Recipe> recipes = em.createNamedQuery(Recipe.BY_INGREDIENT, Recipe.class)
                .setParameter(1, ingredientId)
        .getResultList();
        return recipes;
    }

    @Override
    public List<Recipe> getByCatalog(int catalogId) {
        List<Recipe> recipes = em.createNamedQuery(Recipe.BY_CATALOG, Recipe.class)
                .setParameter(1, catalogId)
                .getResultList();
        return recipes;
    }

    @Override
    public List<Recipe> getAll() {
        return em.createNamedQuery(Recipe.ALL, Recipe.class).getResultList();
    }
}


