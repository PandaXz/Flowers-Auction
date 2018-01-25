package com.belykh.finalProj.dao;

import com.belykh.finalProj.entity.dbo.CityDBO;
import com.belykh.finalProj.exception.DAOException;

import java.util.List;

/**
 * Created by panda on 8.1.18.
 */
public interface CityDAO {

    CityDBO findCityById(Long id) throws DAOException;
    List<CityDBO> findAllCities() throws DAOException;
    List<CityDBO> findCitiesByCountryId(Long countryId) throws DAOException;

    boolean addCity(CityDBO cityDBO) throws DAOException;
    boolean delete(Long id) throws DAOException;
}
