package com.belykh.finalProj.dao;

import com.belykh.finalProj.dao.impl.*;

/**
 * Created by panda on 7.1.18.
 */
public class DAOFactory {
    private final UserDAO userDAO = new UserDAOImpl();
    private final CityDAO cityDAO = new CityDAOImpl();
    private final AddressDAO addressDAO = new AddressDAOImpl();
    private final FlowerDAO flowerDAO = new FlowerDAOImpl();
    private final LotStoryDAO lotStoryDAO = new LotStoryDAOImpl();
    private final LotDAO lotDAO = new LotDAOImpl();
    private final LotHeaderDAO lotHeaderDAO = new LotHeaderDAOImpl();


    public LotHeaderDAO getLotHeaderDAO() {
        return lotHeaderDAO;
    }

    public LotDAO getLotDAO() {
        return lotDAO;
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public LotStoryDAO getLotStoryDAO() {
        return lotStoryDAO;
    }

    public FlowerDAO getFlowerDAO() {
        return flowerDAO;
    }

    public CityDAO getCityDAO() {
        return cityDAO;
    }

    public AddressDAO getAddressDAO() {
        return addressDAO;
    }

}
