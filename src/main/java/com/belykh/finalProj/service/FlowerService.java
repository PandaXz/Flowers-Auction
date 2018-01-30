package com.belykh.finalProj.service;

import com.belykh.finalProj.entity.dbo.FlowerDBO;
import com.belykh.finalProj.exception.ServiceException;

import java.util.List;

public interface FlowerService {
    FlowerDBO findFlowerById(Long id) throws ServiceException;
    List<FlowerDBO> findAllFlowers() throws ServiceException;
}
