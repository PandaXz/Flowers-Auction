package com.belykh.finalProj.dao;

import com.belykh.finalProj.dao.impl.*;

/**
 * Created by panda on 7.1.18.
 */
public class DAOFactory {
    private static DAOFactory instance = new DAOFactory();

    private final UserDAO userDAO = new UserDAOImpl();
    private final CountryDAO countryDAO = new CountryDAOImpl();
    private final CityDAO cityDAO = new CityDAOImpl();
    private final AddressDAO addressDAO = new AddressDAOImpl();
    private final AuctionDAO auctionDAO = new AuctionDAOImpl();
    private final FlowerDAO flowerDAO = new FlowerDAOImpl();
    private final LotStoryDAO lotStoryDAO = new LotStoryDAOImpl();

    public static DAOFactory getInstance() {
        return instance;
    }

    private DAOFactory() {
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

    public CountryDAO getCountryDAO() {
        return countryDAO;
    }

    public CityDAO getCityDAO() {
        return cityDAO;
    }

    public AddressDAO getAddressDAO() {
        return addressDAO;
    }

    public AuctionDAO getAuctionDAO() {
        return auctionDAO;
    }
}
