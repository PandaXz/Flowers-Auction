package com.belykh.flowerAuction.dao;

import com.belykh.flowerAuction.entity.dto.LotStoryDTO;
import com.belykh.flowerAuction.exception.DAOException;

import java.util.List;

/**
 * The Interface LotStoryDAO.
 */
public interface LotStoryDAO {

    /**
     * Adds the lot story.
     *
     * @param lotStoryDTO the lot story DTO
     * @return true, if successful
     * @throws DAOException the DAO exception
     */
    boolean addLotStory(LotStoryDTO lotStoryDTO) throws DAOException;

    /**
     * Find lot stories by lot id.
     *
     * @param id the id
     * @return the list
     * @throws DAOException the DAO exception
     */
    List<LotStoryDTO> findLotStoriesByLotId(Long id) throws DAOException;
}
