package com.belykh.finalProj.dao;

import com.belykh.finalProj.entity.Address;

import java.util.List;

/**
 * Created by panda on 8.1.18.
 */
public interface AddressDAO {

    Address findAddressById(Long id);
    List<Address> findAllAddresses();
    List<Address> findAddressesByCityId(Long cityId);

    boolean addAddress(Address address);
    boolean delete(Long id);
}
