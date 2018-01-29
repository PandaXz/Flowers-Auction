package com.belykh.finalProj.service.Impl;

import com.belykh.finalProj.dao.AddressDAO;
import com.belykh.finalProj.dao.CityDAO;
import com.belykh.finalProj.dao.CountryDAO;
import com.belykh.finalProj.dao.DAOFactory;
import com.belykh.finalProj.entity.Address;
import com.belykh.finalProj.entity.UserInfo;
import com.belykh.finalProj.entity.dbo.AddressDBO;
import com.belykh.finalProj.entity.dbo.CityDBO;
import com.belykh.finalProj.entity.dbo.CountryDBO;
import com.belykh.finalProj.entity.dbo.UserDBO;
import com.belykh.finalProj.exception.DAOException;
import com.belykh.finalProj.exception.ServiceException;
import com.belykh.finalProj.service.AddressService;

public class AddressServiceImpl implements AddressService {
    @Override
    public Address findAddressById(Long addressId) throws ServiceException {
        Address result = null;
        AddressDAO addressDAO = DAOFactory.getInstance().getAddressDAO();
        CityDAO cityDAO = DAOFactory.getInstance().getCityDAO();
        CountryDAO countryDAO= DAOFactory.getInstance().getCountryDAO();
        try {
            AddressDBO addressDBO = addressDAO.findAddressById(addressId);
            if(addressDBO!=null) {
                CityDBO cityDBO = cityDAO.findCityById(addressDBO.getCityId());
                CountryDBO countryDBO = countryDAO.findCountryById(cityDBO.getCountryId());
                result=new Address(addressDBO.getId(),cityDBO.getId(),countryDBO.getId(),addressDBO.getStreet(),addressDBO.getHouseNumber(),cityDBO.getName(),countryDBO.getName());
            }

        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return result;
    }
}
