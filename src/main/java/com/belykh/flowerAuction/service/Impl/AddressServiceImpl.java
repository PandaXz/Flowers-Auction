package com.belykh.flowerAuction.service.Impl;

import com.belykh.flowerAuction.dao.AddressDAO;
import com.belykh.flowerAuction.dao.CityDAO;
import com.belykh.flowerAuction.dao.DAOFactory;
import com.belykh.flowerAuction.entity.Address;
import com.belykh.flowerAuction.entity.dto.AddressDTO;
import com.belykh.flowerAuction.entity.dto.CityDTO;
import com.belykh.flowerAuction.exception.DAOException;
import com.belykh.flowerAuction.exception.ServiceException;
import com.belykh.flowerAuction.service.AddressService;

import java.util.List;

/**
 * The Class AddressServiceImpl.
 */
public class AddressServiceImpl implements AddressService {

    /** The dao factory. */
    public static DAOFactory daoFactory = new DAOFactory();

    /* (non-Javadoc)
     * @see com.belykh.flowerAuction.service.AddressService#findAddressById(java.lang.Long)
     */
    @Override
    public Address findAddressById(Long addressId) throws ServiceException {
        Address result = null;
        AddressDAO addressDAO = daoFactory.getAddressDAO();
        CityDAO cityDAO = daoFactory.getCityDAO();
        try {
            AddressDTO addressDTO = addressDAO.findAddressById(addressId);
            if (addressDTO != null) {
                CityDTO cityDTO = cityDAO.findCityById(addressDTO.getCityId());
                result = new Address(addressDTO.getId(), cityDTO.getId(), addressDTO.getStreet(), addressDTO.getHouseNumber(), cityDTO.getName());
            }

        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return result;
    }

    /* (non-Javadoc)
     * @see com.belykh.flowerAuction.service.AddressService#findAllCities()
     */
    @Override
    public List<CityDTO> findAllCities() throws ServiceException {
        List<CityDTO> result;
        CityDAO cityDAO = daoFactory.getCityDAO();
        try {
            result = cityDAO.findAllCities();

        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return result;
    }

    /* (non-Javadoc)
     * @see com.belykh.flowerAuction.service.AddressService#addAddress(java.lang.Long, java.lang.String, int)
     */
    @Override
    public Long addAddress(Long cityId, String street, int houseNumber) throws ServiceException {
        Long result;
        AddressDAO addressDAO = daoFactory.getAddressDAO();
        try {
            AddressDTO addressDTO = addressDAO.findAddressByCityIdAndAddress(cityId, street, houseNumber);
            if (addressDTO == null && addressDAO.addAddress(new AddressDTO(0L, street, houseNumber, cityId))) {
                addressDTO = addressDAO.findAddressByCityIdAndAddress(cityId, street, houseNumber);
            }
            result = addressDTO.getId();

        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return result;
    }

    /* (non-Javadoc)
     * @see com.belykh.flowerAuction.service.AddressService#addCity(java.lang.String)
     */
    @Override
    public boolean addCity(String name) throws ServiceException {
        boolean result = true;
        CityDAO dao = daoFactory.getCityDAO();
        try {
            if(dao.findCityByName(name)) {
                result = dao.addCity(new CityDTO(0L, name));
            }
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

        return result;
    }
}
