package com.belykh.finalProj.service;

import com.belykh.finalProj.entity.LotFull;
import com.belykh.finalProj.entity.LotHeader;
import com.belykh.finalProj.entity.dbo.LotState;
import com.belykh.finalProj.exception.ServiceException;

import java.util.List;

public interface LotService {
    List<LotHeader> findAcceptedLotHeaders() throws ServiceException;
    List<LotHeader> findLotHeadersByStateAndOwnerId(Long ownerId,LotState state) throws ServiceException;
    List<LotHeader> findLotHeadersByStateAndBuyerId(Long buyerId,LotState state) throws ServiceException;
    LotFull findFullLotInfo(Long id) throws ServiceException;
    boolean deleteLot(Long id,Long ownerId) throws ServiceException;
    boolean buyLot(Long id,Long buyerId,Double price) throws ServiceException;
    boolean payLot(Long lotId) throws ServiceException;
}
