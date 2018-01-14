package com.belykh.finalProj.dao;

import com.belykh.finalProj.entity.AddressDBO;

import java.util.List;

/**
 * Created by panda on 8.1.18.
 */
public interface AddressDAO {

    AddressDBO findAddressById(Long id);
    List<AddressDBO> findAllAddresses();
    List<AddressDBO> findAddressesByCityId(Long cityId);

    boolean addAddress(AddressDBO addressDBO);
    boolean delete(Long id);
}
