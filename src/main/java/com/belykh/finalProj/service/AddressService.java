package com.belykh.finalProj.service;

import com.belykh.finalProj.entity.Address;
import com.belykh.finalProj.entity.dbo.CityDBO;
import com.belykh.finalProj.exception.ServiceException;

import java.util.List;

public interface AddressService {

    Address findAddressById(Long addressId) throws ServiceException;
    List<CityDBO> findAllCities() throws ServiceException;
    Long addAddress(Long cityId, String street, int houseNumber) throws ServiceException;
}
