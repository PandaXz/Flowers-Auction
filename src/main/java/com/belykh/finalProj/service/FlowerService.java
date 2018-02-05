package com.belykh.finalProj.service;

import com.belykh.finalProj.entity.dbo.FlowerDBO;
import com.belykh.finalProj.exception.ServiceException;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Interface FlowerService.
 */
public interface FlowerService {
    
    /**
     * Find flower by id.
     *
     * @param id the id
     * @return the flower DBO
     * @throws ServiceException the service exception
     */
    FlowerDBO findFlowerById(Long id) throws ServiceException;
    
    /**
     * Find all flowers.
     *
     * @return the list
     * @throws ServiceException the service exception
     */
    List<FlowerDBO> findAllFlowers() throws ServiceException;

    /**
     * Adds the flower.
     *
     * @param name the name
     * @return true, if successful
     * @throws ServiceException the service exception
     */
    boolean addFlower(String name) throws ServiceException;
}
