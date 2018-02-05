package com.belykh.flowerAuction.dao;

import com.belykh.flowerAuction.dao.impl.*;

/**
 * A factory for creating DAO objects.
 */
public class DAOFactory {
    private final UserDAO userDAO = new UserDAOImpl();
    private final CityDAO cityDAO = new CityDAOImpl();
    private final AddressDAO addressDAO = new AddressDAOImpl();
    private final FlowerDAO flowerDAO = new FlowerDAOImpl();
    private final LotStoryDAO lotStoryDAO = new LotStoryDAOImpl();
    private final LotDAO lotDAO = new LotDAOImpl();
    private final LotHeaderDAO lotHeaderDAO = new LotHeaderDAOImpl();


    /**
     * Gets the lot header DAO.
     *
     * @return the lot header DAO
     */
    public LotHeaderDAO getLotHeaderDAO() {
        return lotHeaderDAO;
    }

    /**
     * Gets the lot DAO.
     *
     * @return the lot DAO
     */
    public LotDAO getLotDAO() {
        return lotDAO;
    }

    /**
     * Gets the user DAO.
     *
     * @return the user DAO
     */
    public UserDAO getUserDAO() {
        return userDAO;
    }

    /**
     * Gets the lot story DAO.
     *
     * @return the lot story DAO
     */
    public LotStoryDAO getLotStoryDAO() {
        return lotStoryDAO;
    }

    /**
     * Gets the flower DAO.
     *
     * @return the flower DAO
     */
    public FlowerDAO getFlowerDAO() {
        return flowerDAO;
    }

    /**
     * Gets the city DAO.
     *
     * @return the city DAO
     */
    public CityDAO getCityDAO() {
        return cityDAO;
    }

    /**
     * Gets the address DAO.
     *
     * @return the address DAO
     */
    public AddressDAO getAddressDAO() {
        return addressDAO;
    }

}
