package com.belykh.finalProj.dao;

import com.belykh.finalProj.entity.dbo.LotDBO;
import com.belykh.finalProj.entity.dbo.LotState;
import com.belykh.finalProj.exception.DAOException;

import java.math.BigDecimal;

/**
 * Created by panda on 8.1.18.
 */
public interface LotDAO {

    LotDBO findLotById(Long id) throws DAOException;
    boolean changeBuyerAndPrice(Long id, Long userId, BigDecimal newPrice) throws DAOException;
    boolean changeState(Long id,LotState state) throws DAOException;
    void checkUnpaidLots() throws DAOException;
    boolean addLot(LotDBO lotDBO) throws DAOException;
    boolean delete(Long id) throws DAOException;
}
