package com.belykh.finalProj.dao;

import com.belykh.finalProj.entity.AddressDBO;
import com.belykh.finalProj.exception.DAOException;

import java.util.List;

/**
 * Created by panda on 8.1.18.
 */
public interface AddressDAO {

    AddressDBO findAddressById(Long id) throws DAOException;
    List<AddressDBO> findAllAddresses() throws DAOException;
    List<AddressDBO> findAddressesByCityId(Long cityId) throws DAOException;

    boolean addAddress(AddressDBO addressDBO) throws DAOException;
    boolean delete(Long id) throws DAOException;
}
