package com.belykh.finalProj.dao;

import com.belykh.finalProj.entity.CountryDBO;
import com.belykh.finalProj.exception.DAOException;

import java.util.List;

/**
 * Created by panda on 8.1.18.
 */
public interface CountryDAO {

    CountryDBO findCountryById(Long id) throws DAOException;
    List<CountryDBO> findAllCountries() throws DAOException;

    boolean addCountry(CountryDBO countryDBO) throws DAOException;
    boolean delete(Long id) throws DAOException;
}
