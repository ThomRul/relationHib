package repositories.base;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class CrudRepository<T, Id> implements ICrudRepository<T, Id> {
    private final EntityManagerFactory emf;
    private final Class<T> entityClass;

    public CrudRepository(Class<T> entityClass) {
        this.emf = Persistence.createEntityManagerFactory("hibernate_demo");
        this.entityClass = entityClass;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }


    @Override
    public List<T> getAll() {
        try (
                EntityManager em = getEntityManager();
                )
        {
            List<T> entities = em
                    .createQuery("FROM " + entityClass.getSimpleName(), entityClass)
                    .getResultList();
            return entities;
        }
    }

    @Override
    public T getOne(Id id) {
        try (
                EntityManager em = getEntityManager();
        ) {
            T entity = em.find(entityClass, id);
            return entity;
        }
    }

    @Override
    public T insert(T entity) {
        try (
                EntityManager em = getEntityManager();
        ) {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
            return entity;
        }
    }

    @Override
    public T update(Id id, T entity) {
        try (
                EntityManager em = getEntityManager();
        ) {
            T toUpdateEntity = getOne(id);

            if (toUpdateEntity != null) {
                em.getTransaction().begin();
                toUpdateEntity = em.merge(entity);
                em.getTransaction().commit();
            }


            return toUpdateEntity;
        }
    }

    @Override
    public T delete(Id id) {
        try (
                EntityManager em = getEntityManager();
        ) {
            T toDeleteEntity = getOne(id);
            if (toDeleteEntity != null) {
                em.getTransaction().begin();
                em.remove(toDeleteEntity);
                em.getTransaction().commit();
            }
            return toDeleteEntity;
        }
    }
}
