package com.belykh.finalProj.service;

import com.belykh.finalProj.entity.dbo.AuctionDBO;
import com.belykh.finalProj.exception.ServiceException;

import java.util.List;

public interface AuctionService {
    List<AuctionDBO> findAllAuctions() throws ServiceException;
    List<AuctionDBO> findActualAuctions() throws ServiceException;
}
