package com.belykh.finalProj.dao;

import com.belykh.finalProj.entity.dbo.AddressDBO;
import com.belykh.finalProj.exception.DAOException;

/**
 * Created by panda on 8.1.18.
 */
public interface AddressDAO {

    AddressDBO findAddressById(Long id) throws DAOException;
    AddressDBO findAddressByCityIdAndAddress(Long cityId, String street, int houseNumber) throws DAOException ;
    boolean addAddress(AddressDBO addressDBO) throws DAOException;
    boolean delete(Long id) throws DAOException;
}
