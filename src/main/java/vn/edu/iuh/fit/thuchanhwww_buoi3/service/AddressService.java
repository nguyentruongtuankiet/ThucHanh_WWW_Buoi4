package vn.edu.iuh.fit.thuchanhwww_buoi3.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.thuchanhwww_buoi3.daos.AddressRepositories;
import vn.edu.iuh.fit.thuchanhwww_buoi3.entities.Address;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AddressService {

    private final AddressRepositories addressRepositories;

    @Autowired
    public AddressService(AddressRepositories addressRepositories) {
        this.addressRepositories = addressRepositories;
    }
    public List<Address> getAll() throws Exception{
        return addressRepositories.getAll();
    }

    public Optional<Address> getByID(UUID uuid)throws Exception{
        return addressRepositories.getByID(uuid);
    }

    public boolean delete(UUID uuid)throws Exception{
        return addressRepositories.delete(uuid);
    }

    public boolean add(Address entity) throws Exception {
        return addressRepositories.add(entity);
    }
    public boolean update(Address entity) throws Exception{
        return addressRepositories.update(entity);
    }


}