package com.belykh.finalProj.dao;

import com.belykh.finalProj.entity.dbo.AddressDBO;
import com.belykh.finalProj.exception.DAOException;

// TODO: Auto-generated Javadoc
/**
 * The Interface AddressDAO.
 */
public interface AddressDAO {

    /**
     * Find address by id.
     *
     * @param id the id
     * @return the address DBO
     * @throws DAOException the DAO exception
     */
    AddressDBO findAddressById(Long id) throws DAOException;
    
    /**
     * Find address by city id and address.
     *
     * @param cityId the city id
     * @param street the street
     * @param houseNumber the house number
     * @return the address DBO
     * @throws DAOException the DAO exception
     */
    AddressDBO findAddressByCityIdAndAddress(Long cityId, String street, int houseNumber) throws DAOException ;
    
    /**
     * Adds the address.
     *
     * @param addressDBO the address DBO
     * @return true, if successful
     * @throws DAOException the DAO exception
     */
    boolean addAddress(AddressDBO addressDBO) throws DAOException;
}
