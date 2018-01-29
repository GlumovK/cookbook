package ru.dartIt.repository;

import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.dartIt.model.Catalog;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class CatalogRepositoryImpl implements CatalogRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public Catalog save(Catalog catalog) {
        if (catalog.isNew()) {
            em.persist(catalog);
            return catalog;
        } else {
            return em.merge(catalog);
        }
    }

    @Override
    public Catalog get(int id) {
        return em.find(Catalog.class, id);
    }

    @Override
    @Transactional
    public boolean delete(int id) {

        return em.createNamedQuery(Catalog.DELETE)
                .setParameter("id", id)
                .executeUpdate() != 0;
    }

    @Override
    public Catalog getByName(String name) {
        List<Catalog> catalogs = em.createNamedQuery(Catalog.BY_NAME, Catalog.class)
                .setParameter(1, name)
                .getResultList();
        return DataAccessUtils.singleResult(catalogs);
    }

    @Override
    public List<Catalog> getAll() {
        return em.createNamedQuery(Catalog.ALL, Catalog.class).getResultList();
    }
}



