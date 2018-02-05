package com.belykh.finalProj.dao;

import com.belykh.finalProj.entity.dbo.LotStoryDBO;
import com.belykh.finalProj.exception.DAOException;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Interface LotStoryDAO.
 */
public interface LotStoryDAO {

    /**
     * Adds the lot story.
     *
     * @param lotStoryDBO the lot story DBO
     * @return true, if successful
     * @throws DAOException the DAO exception
     */
    boolean addLotStory(LotStoryDBO lotStoryDBO) throws DAOException;

    /**
     * Find lot stories by lot id.
     *
     * @param id the id
     * @return the list
     * @throws DAOException the DAO exception
     */
    List<LotStoryDBO> findLotStoriesByLotId(Long id) throws DAOException;
}
