package com.belykh.flowerAuction.dao;

import com.belykh.flowerAuction.entity.dto.LotDTO;
import com.belykh.flowerAuction.entity.dto.LotState;
import com.belykh.flowerAuction.exception.DAOException;

import java.math.BigDecimal;

/**
 * The Interface LotDAO.
 */
public interface LotDAO {

    /**
     * Find lot by id.
     *
     * @param id the id
     * @return the lot DTO
     * @throws DAOException the DAO exception
     */
    LotDTO findLotById(Long id) throws DAOException;
    
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
     * @param lotDTO the lot DTO
     * @return true, if successful
     * @throws DAOException the DAO exception
     */
    boolean addLot(LotDTO lotDTO) throws DAOException;
    
    /**
     * Delete.
     *
     * @param id the id
     * @return true, if successful
     * @throws DAOException the DAO exception
     */
    boolean delete(Long id) throws DAOException;
}
