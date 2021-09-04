package Repository.Base;

import Domain.base.BaseEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.io.Serializable;
import java.util.Collection;
import java.util.Optional;

public abstract class Repository<E extends BaseEntity<ID>, ID extends Serializable> implements RepositoryAPI<E,ID> {
    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    public abstract Class<E> getEntityClassType();
    public abstract Optional<E> getEntityFromDb(E entity);
    public abstract ID getEntityId(E entity);

    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public Repository() {
        entityManagerFactory =
                Persistence.createEntityManagerFactory("Hibernate_practice_app");
        entityManager = entityManagerFactory.createEntityManager();

    }


    public EntityTransaction getTransaction() {
        return this.entityManager.getTransaction();
    }

    public Optional<E> simpleSave(E entity) {
        entityManager.getTransaction().begin();
        if (entity.getId() == null) {
            entityManager.persist(entity);
            entityManager.getTransaction().commit();
            ID id =getEntityId(entity);
            entity.setId(id);
            return Optional.of(entity);
        } else {
            E merge = entityManager.merge(entity);
            entityManager.getTransaction().commit();
            return Optional.of(merge);
        }

    }

    public void simpleRemove(E entity) {
        entityManager.getTransaction().begin();
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
    }

    public E simpleFindById(ID id) {
        return entityManager.find(getEntityClassType(), id);
    }


    public Collection<E> simpleFindAll() {

        return entityManager.createQuery(
                "from " + getEntityClassType().getSimpleName(),
                getEntityClassType()
        ).getResultList();
    }


    public void closeEntityManager() {
        entityManager.close();
        entityManagerFactory.close();
    }
}
