package com.belykh.finalProj.dao;

import com.belykh.finalProj.entity.dbo.FlowerDBO;
import com.belykh.finalProj.exception.DAOException;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Interface FlowerDAO.
 */
public interface FlowerDAO {
    
    /**
     * Find flower by id.
     *
     * @param id the id
     * @return the flower DBO
     * @throws DAOException the DAO exception
     */
    FlowerDBO findFlowerById(Long id) throws DAOException;

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
    List<FlowerDBO> findAllFlowers() throws DAOException;
    
    /**
     * Adds the flower.
     *
     * @param flowerDBO the flower DBO
     * @return true, if successful
     * @throws DAOException the DAO exception
     */
    boolean addFlower(FlowerDBO flowerDBO) throws DAOException;
}
