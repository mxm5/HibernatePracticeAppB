package Repository.Base;

import Domain.base.BaseEntity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Optional;

public interface RepositoryAPI <E extends BaseEntity<ID>,ID extends Serializable> {

    Optional<E> create(E entity);

    void delete(E entity);

    Optional<E> update(E entity);

    E read(E entity);

    Collection<E> readAll();


}
