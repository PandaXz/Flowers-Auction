package com.belykh.flowerAuction.dao;

import com.belykh.flowerAuction.entity.LotHeader;
import com.belykh.flowerAuction.entity.dto.LotState;
import com.belykh.flowerAuction.exception.DAOException;

import java.util.List;

/**
 * The Interface LotHeaderDAO.
 */
public interface LotHeaderDAO {
    
    /**
     * Find lot headers by state and owner id.
     *
     * @param ownerId the owner id
     * @param state the state
     * @return the list
     * @throws DAOException the DAO exception
     */
    List<LotHeader> findLotHeadersByStateAndOwnerId(Long ownerId, LotState state) throws DAOException;
    
    /**
     * Find lot headers by state and buyer id.
     *
     * @param buyerId the buyer id
     * @param state the state
     * @return the list
     * @throws DAOException the DAO exception
     */
    List<LotHeader> findLotHeadersByStateAndBuyerId(Long buyerId,LotState state) throws DAOException;
    
    /**
     * Find lot headers by state.
     *
     * @param state the state
     * @return the list
     * @throws DAOException the DAO exception
     */
    List<LotHeader> findLotHeadersByState(LotState state) throws DAOException;
}
