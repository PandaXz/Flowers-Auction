package com.belykh.finalProj.service;

import com.belykh.finalProj.entity.Address;
import com.belykh.finalProj.exception.ServiceException;

public interface AddressService {

    Address findAddressById(Long addressId) throws ServiceException;
}
