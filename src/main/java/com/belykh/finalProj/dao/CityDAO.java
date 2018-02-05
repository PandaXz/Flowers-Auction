package com.belykh.finalProj.dao;

import com.belykh.finalProj.entity.dbo.CityDBO;
import com.belykh.finalProj.exception.DAOException;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Interface CityDAO.
 */
public interface CityDAO {

    /**
     * Find city by id.
     *
     * @param id the id
     * @return the city DBO
     * @throws DAOException the DAO exception
     */
    CityDBO findCityById(Long id) throws DAOException;

    /**
     * Find city by name.
     *
     * @param name the name
     * @return true, if successful
     * @throws DAOException the DAO exception
     */
    boolean findCityByName(String name) throws DAOException;

    /**
     * Find all cities.
     *
     * @return the list
     * @throws DAOException the DAO exception
     */
    List<CityDBO> findAllCities() throws DAOException;
    
    /**
     * Adds the city.
     *
     * @param cityDBO the city DBO
     * @return true, if successful
     * @throws DAOException the DAO exception
     */
    boolean addCity(CityDBO cityDBO) throws DAOException;
}
