package com.belykh.finalProj.service;

import com.belykh.finalProj.entity.LotFull;
import com.belykh.finalProj.entity.LotHeader;
import com.belykh.finalProj.entity.dbo.LotState;
import com.belykh.finalProj.exception.ServiceException;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface LotService {
    List<LotHeader> findAcceptedLotHeaders() throws ServiceException;
    List<LotHeader> findAddedLotHeaders() throws ServiceException;

    boolean denyLot(Long lotId) throws ServiceException;

    List<LotHeader> findLotHeadersByStateAndOwnerId(Long ownerId, LotState state) throws ServiceException;
    List<LotHeader> findLotHeadersByStateAndBuyerId(Long buyerId,LotState state) throws ServiceException;
    LotFull findFullLotInfo(Long id) throws ServiceException;
    boolean deleteLot(Long id,Long ownerId) throws ServiceException;
    boolean buyLot(Long id, Long buyerId, BigDecimal price) throws ServiceException;
    boolean payLot(Long lotId) throws ServiceException;
    boolean offerLot(Long ownerId, Long flowerId, Long cityId, String street, Integer houseNumber, BigDecimal price, Integer count, LocalDateTime end, String description) throws ServiceException;
    boolean approveLot(Long lotId) throws ServiceException;
}
