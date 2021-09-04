package Service.base;

import Domain.base.BaseEntity;

import java.io.Serializable;
import java.util.Collection;

public interface ServiceApi<E extends BaseEntity<ID>,ID extends Serializable> {
    public E create(E e);
    public E update(E e);
    public E delete(E e);
    public void deleteById(ID id);
    public E exists(E e);
    public Collection<E> readAll();
    public E read(E e);
    public ID getEntityID(E e);
    public E findByID(ID id);
    public E getEntity(E e);

}
