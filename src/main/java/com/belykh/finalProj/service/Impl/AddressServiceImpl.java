package com.belykh.finalProj.service.Impl;

import com.belykh.finalProj.dao.AddressDAO;
import com.belykh.finalProj.dao.CityDAO;
import com.belykh.finalProj.dao.DAOFactory;
import com.belykh.finalProj.entity.Address;
import com.belykh.finalProj.entity.dbo.AddressDBO;
import com.belykh.finalProj.entity.dbo.CityDBO;
import com.belykh.finalProj.exception.DAOException;
import com.belykh.finalProj.exception.ServiceException;
import com.belykh.finalProj.service.AddressService;

import java.util.List;

public class AddressServiceImpl implements AddressService {
    @Override
    public Address findAddressById(Long addressId) throws ServiceException {
        Address result = null;
        AddressDAO addressDAO = DAOFactory.getInstance().getAddressDAO();
        CityDAO cityDAO = DAOFactory.getInstance().getCityDAO();
        try {
            AddressDBO addressDBO = addressDAO.findAddressById(addressId);
            if(addressDBO!=null) {
                CityDBO cityDBO = cityDAO.findCityById(addressDBO.getCityId());
                result=new Address(addressDBO.getId(),cityDBO.getId(),addressDBO.getStreet(),addressDBO.getHouseNumber(),cityDBO.getName());
            }

        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return result;
    }

    @Override
    public List<CityDBO> findAllCities() throws ServiceException {
        List<CityDBO> result = null;
        CityDAO cityDAO = DAOFactory.getInstance().getCityDAO();
        try {
            result=cityDAO.findAllCities();

        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return result;
    }
}
