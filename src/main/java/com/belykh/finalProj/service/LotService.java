package com.belykh.finalProj.service;

import com.belykh.finalProj.entity.LotFull;
import com.belykh.finalProj.entity.LotHeader;
import com.belykh.finalProj.entity.dbo.LotState;
import com.belykh.finalProj.exception.ServiceException;

import javax.servlet.http.Part;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface LotService {

    List<LotHeader> findLotHeadersByState(LotState state) throws ServiceException;
    boolean denyLot(Long lotId) throws ServiceException;
    List<LotHeader> findLotHeadersByStateAndId(Long id, LotState state, boolean isBuyer) throws ServiceException;
    LotFull findFullLotInfo(Long id) throws ServiceException;
    boolean deleteLot(Long id,Long ownerId) throws ServiceException;

    boolean deleteLot(Long id) throws ServiceException;

    boolean buyLot(Long id, Long buyerId, BigDecimal price) throws ServiceException;
    boolean payLot(Long lotId) throws ServiceException;
    boolean offerLot(Long ownerId, Long flowerId, Long cityId, String street, Integer houseNumber, BigDecimal price, Integer count, LocalDateTime end, String description, Part image, String filePath) throws ServiceException;
    boolean approveLot(Long lotId) throws ServiceException;
}
