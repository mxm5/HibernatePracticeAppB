package Repository;

import Domain.Address;
import Repository.Base.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.Collection;
import java.util.Optional;

public class AddressRepo extends Repository<Address, Integer> {

    @Override
    public Optional<Address> create(Address address) {
//        getEntityManager().getTransaction().begin();
        //        getEntityManager().getTransaction().commit();
        return simpleSave(address)
                ;
    }

    @Override
    public void delete(Address address) {
        simpleRemove(address);
    }

    @Override
    public Optional<Address> update(Address address) {
        return simpleSave(address);
    }

    @Override
    public Address read(Address address) {
        return simpleFindById(address.getAddressId());
    }

    @Override
    public Collection<Address> readAll() {
        return simpleFindAll();
    }


    @Override
    public Class<Address> getEntityClassType() {
        return Address.class;
    }

    @Override
    public Optional<Address> getEntityFromDb(Address entity) {
        TypedQuery<Address> query = getAddressTypedQuery(entity);
        Address foundAddress = query.getSingleResult();
        return Optional.ofNullable(foundAddress);
    }

    @Override
    public Integer getEntityId(Address entity) {

        TypedQuery<Address> query = getAddressTypedQuery(entity);
        return query.getSingleResult().getAddressId();
    }

    private TypedQuery<Address> getAddressTypedQuery(Address entity) {
        return getEntityManager().createQuery(
                "select a from Address a where a.addressNumber = " + entity.getAddressNumber() + " " +
                        "and a.addressState = " + entity.getAddressState() + " " +
                        "and a.addressCity = " + entity.getAddressCity() + " " +
                        "and a.addressPostalAddress = " + entity.getAddressPostalAddress() + "",
                Address.class
        );
    }
}
