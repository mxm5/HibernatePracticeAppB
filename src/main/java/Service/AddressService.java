package Service;

import Domain.Address;
import Repository.AddressRepo;
import Service.base.Service;

import java.util.Collection;
import java.util.Optional;

public class AddressService extends Service<Address, Integer> {
    private static final AddressRepo addressRepo;

    public static AddressRepo getAddressRepo() {
        return addressRepo;
    }

    static {
        addressRepo = new AddressRepo();
    }


    @Override
    public Address create(Address address) {

        Address addressInsert = addressRepo.create(address).get();

        return addressInsert;
    }

    @Override
    public Address update(Address address) {

        Optional<Address> addressUpdate = addressRepo.create(address);

        return addressUpdate.get();
    }

    @Override
    public Address delete(Address address) {
        addressRepo.delete(address);
        return address;
    }

    @Override
    public void deleteById(Integer id) {
        addressRepo.delete(findByID(id));
    }

    @Override
    public Address exists(Address address) {
        Optional<Integer> entityId = Optional.ofNullable(addressRepo.getEntityId(address));
        return entityId.map(addressRepo::simpleFindById).orElse(null);
    }

    @Override
    public Collection<Address> readAll() {
        return addressRepo.readAll();
    }

    @Override
    public Address read(Address address) {
        return addressRepo.read(address);
    }

    @Override
    public Integer getEntityID(Address address) {
        return addressRepo.getEntityId(address);
    }

    @Override
    public Address findByID(Integer id) {
        return addressRepo.simpleFindById(id);
    }

    @Override
    public Address getEntity(Address address) {

        return addressRepo.getEntityFromDb(address).get();
    }
}
