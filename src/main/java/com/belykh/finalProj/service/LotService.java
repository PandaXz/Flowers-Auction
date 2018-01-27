package com.belykh.finalProj.service;

import com.belykh.finalProj.entity.LotHeader;
import com.belykh.finalProj.exception.ServiceException;

import java.util.List;

public interface LotService {
    List<LotHeader> findAcceptedLotHeaders() throws ServiceException;
    List<LotHeader> findAcceptedLotHeaders(Long ownerId) throws ServiceException;
    List<LotHeader> findSoldLotHeaders(Long ownerId) throws ServiceException;
    List<LotHeader> findDeniedLotHeaders(Long ownerId) throws ServiceException;
    List<LotHeader> findAddedLotHeaders(Long ownerId) throws ServiceException;

}
