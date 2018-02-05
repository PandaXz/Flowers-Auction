package com.belykh.flowerAuction.service;

import com.belykh.flowerAuction.entity.Address;
import com.belykh.flowerAuction.entity.dto.CityDTO;
import com.belykh.flowerAuction.exception.ServiceException;

import java.util.List;

/**
 * The Interface AddressService.
 */
public interface AddressService {

    /**
     * Find address by id.
     *
     * @param addressId the address id
     * @return the address
     * @throws ServiceException the service exception
     */
    Address findAddressById(Long addressId) throws ServiceException;
    
    /**
     * Find all cities.
     *
     * @return the list
     * @throws ServiceException the service exception
     */
    List<CityDTO> findAllCities() throws ServiceException;
    
    /**
     * Adds the address.
     *
     * @param cityId the city id
     * @param street the street
     * @param houseNumber the house number
     * @return the long
     * @throws ServiceException the service exception
     */
    Long addAddress(Long cityId, String street, int houseNumber) throws ServiceException;

    /**
     * Adds the city.
     *
     * @param name the name
     * @return true, if successful
     * @throws ServiceException the service exception
     */
    boolean addCity(String name) throws ServiceException;
}
