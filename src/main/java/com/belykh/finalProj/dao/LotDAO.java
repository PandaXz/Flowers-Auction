package com.belykh.finalProj.dao;

import com.belykh.finalProj.entity.dbo.LotDBO;
import com.belykh.finalProj.entity.dbo.LotState;
import com.belykh.finalProj.exception.DAOException;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by panda on 8.1.18.
 */
public interface LotDAO {

    LotDBO findLotById(Long id) throws DAOException;
    List<LotDBO> findAllLotsByState(LotState state) throws DAOException;
    List<LotDBO> findAllLotsByStateAndOwnerId(Long ownerId,LotState state) throws DAOException;
    boolean changeBuyerAndPrice(Long id, Long userId, BigDecimal newPrice) throws DAOException;
    boolean changeState(Long id,LotState state) throws DAOException;
    void checkUnpaidLots() throws DAOException;
    boolean addLot(LotDBO lotDBO) throws DAOException;
    boolean delete(Long id) throws DAOException;
    List<LotDBO> findAllLotsByStateAndBuyerId(Long buyerId, LotState state) throws DAOException;
}
