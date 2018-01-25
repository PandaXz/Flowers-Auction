package com.belykh.finalProj.service;

import com.belykh.finalProj.entity.LotHeader;
import com.belykh.finalProj.exception.ServiceException;

import java.util.List;

public interface LotService {
    List<LotHeader> findAcceptedLotHeaders(Long id) throws ServiceException;
}
