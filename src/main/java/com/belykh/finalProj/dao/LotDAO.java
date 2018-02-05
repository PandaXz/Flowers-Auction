package com.belykh.finalProj.dao;

import com.belykh.finalProj.entity.dbo.LotDBO;
import com.belykh.finalProj.entity.dbo.LotState;
import com.belykh.finalProj.exception.DAOException;

import java.math.BigDecimal;

// TODO: Auto-generated Javadoc
/**
 * The Interface LotDAO.
 */
public interface LotDAO {

    /**
     * Find lot by id.
     *
     * @param id the id
     * @return the lot DBO
     * @throws DAOException the DAO exception
     */
    LotDBO findLotById(Long id) throws DAOException;
    
    /**
     * Change buyer and price.
     *
     * @param id the id
     * @param userId the user id
     * @param newPrice the new price
     * @return true, if successful
     * @throws DAOException the DAO exception
     */
    boolean changeBuyerAndPrice(Long id, Long userId, BigDecimal newPrice) throws DAOException;
    
    /**
     * Change state.
     *
     * @param id the id
     * @param state the state
     * @return true, if successful
     * @throws DAOException the DAO exception
     */
    boolean changeState(Long id,LotState state) throws DAOException;

    /**
     * Gets the last id.
     *
     * @return the last id
     * @throws DAOException the DAO exception
     */
    Long getLastId() throws DAOException;

    /**
     * Check unpaid lots.
     *
     * @throws DAOException the DAO exception
     */
    void checkUnpaidLots() throws DAOException;
    
    /**
     * Adds the lot.
     *
     * @param lotDBO the lot DBO
     * @return true, if successful
     * @throws DAOException the DAO exception
     */
    boolean addLot(LotDBO lotDBO) throws DAOException;
    
    /**
     * Delete.
     *
     * @param id the id
     * @return true, if successful
     * @throws DAOException the DAO exception
     */
    boolean delete(Long id) throws DAOException;
}
