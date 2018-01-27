package ru.dartIt.repository;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.dartIt.model.Recipe;
import ru.dartIt.model.User;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class JpaRecipeRepositoryImpl implements RecipeRepository{


    @PersistenceContext
    private EntityManager em;





    @Override
    @Transactional
    public Recipe save(Recipe recipe, int userId) {
        if (!recipe.isNew() && get(recipe.getId(), userId) == null) {
            return null;
        }
        recipe.setUser(em.getReference(User.class, userId));

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
    public Recipe get(int id, int userId) {
        Recipe meal = em.find(Recipe.class, id);
        return meal != null && meal.getUser().getId() == userId ? meal : null;
    }

//    @Override
//    public void addVote(int id) {
//
//    }

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
    public List<Recipe> getByName(String name){
        List<Recipe> recipes = em.createNamedQuery(Recipe.BY_NAME, Recipe.class)
                .setParameter(1, name)
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
    public List<Recipe> getByUser(int userId) {
        List<Recipe> recipes = em.createNamedQuery(Recipe.BY_USER, Recipe.class)
                .setParameter(1, userId)
                .getResultList();
        return recipes;
    }

    @Override
    public List<Recipe> getAll() {
        return em.createNamedQuery(Recipe.ALL, Recipe.class).getResultList();
    }
//    @Override
//    public void addVote (int id){
//
//    }

}


