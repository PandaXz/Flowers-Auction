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

    private DAOFactory daoFactory = new DAOFactory();

    public void setDaoFactory(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public Address findAddressById(Long addressId) throws ServiceException {
        Address result = null;
        AddressDAO addressDAO = daoFactory.getAddressDAO();
        CityDAO cityDAO = daoFactory.getCityDAO();
        try {
            AddressDBO addressDBO = addressDAO.findAddressById(addressId);
            if (addressDBO != null) {
                CityDBO cityDBO = cityDAO.findCityById(addressDBO.getCityId());
                result = new Address(addressDBO.getId(), cityDBO.getId(), addressDBO.getStreet(), addressDBO.getHouseNumber(), cityDBO.getName());
            }

        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return result;
    }

    @Override
    public List<CityDBO> findAllCities() throws ServiceException {
        List<CityDBO> result = null;
        CityDAO cityDAO = daoFactory.getCityDAO();
        try {
            result = cityDAO.findAllCities();

        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return result;
    }

    @Override
    public Long addAddress(Long cityId, String street, int houseNumber) throws ServiceException {
        Long result = null;
        AddressDAO addressDAO = daoFactory.getAddressDAO();
        try {
            AddressDBO addressDBO = addressDAO.findAddressByCityIdAndAddress(cityId, street, houseNumber);
            if (addressDBO == null && addressDAO.addAddress(new AddressDBO(0l, street, houseNumber, cityId))) {
                addressDBO = addressDAO.findAddressByCityIdAndAddress(cityId, street, houseNumber);
            }
            result = addressDBO.getId();

        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return result;
    }

    @Override
    public boolean addCity(String name) throws ServiceException {
        boolean result = false;
        CityDAO dao = daoFactory.getCityDAO();
        try {
            result = dao.addCity(new CityDBO(0l,name));

        } catch (DAOException e) {
            throw new ServiceException(e);
        }

        return result;
    }
}
