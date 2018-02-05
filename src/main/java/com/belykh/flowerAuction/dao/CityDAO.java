package com.belykh.flowerAuction.dao;

import com.belykh.flowerAuction.entity.dto.CityDTO;
import com.belykh.flowerAuction.exception.DAOException;

import java.util.List;

/**
 * The Interface CityDAO.
 */
public interface CityDAO {

    /**
     * Find city by id.
     *
     * @param id the city id
     * @return the city DTO
     * @throws DAOException the DAO exception
     */
    CityDTO findCityById(Long id) throws DAOException;

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
    List<CityDTO> findAllCities() throws DAOException;
    
    /**
     * Adds the city.
     *
     * @param cityDTO the city DTO
     * @return true, if successful
     * @throws DAOException the DAO exception
     */
    boolean addCity(CityDTO cityDTO) throws DAOException;
}
