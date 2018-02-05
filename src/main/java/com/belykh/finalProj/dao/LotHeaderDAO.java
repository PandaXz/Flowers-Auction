package com.belykh.finalProj.dao;

import com.belykh.finalProj.entity.LotHeader;
import com.belykh.finalProj.entity.dbo.LotState;
import com.belykh.finalProj.exception.DAOException;

import java.util.List;

// TODO: Auto-generated Javadoc
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
