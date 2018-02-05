package com.belykh.flowerAuction.dao;

import com.belykh.flowerAuction.entity.dto.FlowerDTO;
import com.belykh.flowerAuction.exception.DAOException;

import java.util.List;

/**
 * The Interface FlowerDAO.
 */
public interface FlowerDAO {

    /**
     * Find flower by id.
     *
     * @param id the id
     * @return the flower DTO
     * @throws DAOException the DAO exception
     */
    FlowerDTO findFlowerById(Long id) throws DAOException;

    /**
     * Find flower by name.
     *
     * @param name the name
     * @return true, if successful
     * @throws DAOException the DAO exception
     */
    boolean findFlowerByName(String name) throws DAOException;

    /**
     * Find all flowers.
     *
     * @return the list
     * @throws DAOException the DAO exception
     */
    List<FlowerDTO> findAllFlowers() throws DAOException;
    
    /**
     * Adds the flower.
     *
     * @param flowerDTO the flower DTO
     * @return true, if successful
     * @throws DAOException the DAO exception
     */
    boolean addFlower(FlowerDTO flowerDTO) throws DAOException;
}
