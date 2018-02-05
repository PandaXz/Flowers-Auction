package com.belykh.finalProj.service;

import com.belykh.finalProj.entity.Address;
import com.belykh.finalProj.entity.dbo.CityDBO;
import com.belykh.finalProj.exception.ServiceException;

import java.util.List;

// TODO: Auto-generated Javadoc
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
    List<CityDBO> findAllCities() throws ServiceException;
    
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
