package com.belykh.flowerAuction.service;

import com.belykh.flowerAuction.entity.dto.FlowerDTO;
import com.belykh.flowerAuction.exception.ServiceException;

import java.util.List;

/**
 * The Interface FlowerService.
 */
public interface FlowerService {
    
    /**
     * Find flower by id.
     *
     * @param id the id
     * @return the flower DTO
     * @throws ServiceException the service exception
     */
    FlowerDTO findFlowerById(Long id) throws ServiceException;
    
    /**
     * Find all flowers.
     *
     * @return the list of flowers
     * @throws ServiceException the service exception
     */
    List<FlowerDTO> findAllFlowers() throws ServiceException;

    /**
     * Adds the flower.
     *
     * @param name the name
     * @return true, if successful
     * @throws ServiceException the service exception
     */
    boolean addFlower(String name) throws ServiceException;
}
