package com.belykh.finalProj.dao;

import com.belykh.finalProj.entity.LotHeader;
import com.belykh.finalProj.entity.dbo.LotState;
import com.belykh.finalProj.exception.DAOException;

import java.util.List;

public interface LotHeaderDAO {
    List<LotHeader> findLotHeadersByStateAndOwnerId(Long ownerId, LotState state) throws DAOException;
    List<LotHeader> findLotHeadersByStateAndBuyerId(Long buyerId,LotState state) throws DAOException;
    List<LotHeader> findLotHeadersByState(LotState state) throws DAOException;
}
