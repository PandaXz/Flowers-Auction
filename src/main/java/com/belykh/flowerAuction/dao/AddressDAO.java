package com.belykh.flowerAuction.dao;

import com.belykh.flowerAuction.entity.dto.AddressDTO;
import com.belykh.flowerAuction.exception.DAOException;

/**
 * The Interface AddressDAO.
 */
public interface AddressDAO {

    /**
     * Find address by id.
     *
     * @param id the address id
     * @return the address entity
     * @throws DAOException the DAO exception
     */
    AddressDTO findAddressById(Long id) throws DAOException;
    
    /**
     * Find address by city id and address.
     *
     * @param cityId the city id
     * @param street the street
     * @param houseNumber the house number
     * @return the address DTO
     * @throws DAOException the DAO exception
     */
    AddressDTO findAddressByCityIdAndAddress(Long cityId, String street, int houseNumber) throws DAOException ;
    
    /**
     * Adds the address.
     *
     * @param addressDTO the address DTO
     * @return true, if successful
     * @throws DAOException the DAO exception
     */
    boolean addAddress(AddressDTO addressDTO) throws DAOException;
}
