package com.belykh.finalProj.dao;

import com.belykh.finalProj.dao.impl.CountryDAOImpl;
import com.belykh.finalProj.dao.impl.UserDAOImpl;

/**
 * Created by panda on 7.1.18.
 */
public class DAOFactory {
    private static DAOFactory instance = new DAOFactory();

    private final UserDAO userDAO = new UserDAOImpl();
    private final CountryDAO countryDAO = new CountryDAOImpl();

    public static DAOFactory getInstance() {
        return instance;
    }

    private DAOFactory() {
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public CountryDAO getCountryDAO() {
        return countryDAO;
    }
}
