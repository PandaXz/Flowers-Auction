package com.belykh.finalProj.service.Impl;

import com.belykh.finalProj.dao.DAOFactory;
import com.belykh.finalProj.dao.FlowerDAO;
import com.belykh.finalProj.dao.LotDAO;
import com.belykh.finalProj.entity.LotFull;
import com.belykh.finalProj.entity.LotHeader;
import com.belykh.finalProj.entity.dbo.FlowerDBO;
import com.belykh.finalProj.entity.dbo.LotDBO;
import com.belykh.finalProj.entity.dbo.LotState;
import com.belykh.finalProj.exception.DAOException;
import com.belykh.finalProj.exception.ServiceException;
import com.belykh.finalProj.service.LotService;

import java.util.ArrayList;
import java.util.List;

public class LotServiceImpl implements LotService {
    @Override
    public List<LotHeader> findAcceptedLotHeaders() throws ServiceException {
        List<LotHeader> result=null;
        LotDAO lotDAO = DAOFactory.getInstance().getLotDAO();
        try {
            List<LotDBO> listLots = lotDAO.findAllLotsByState(LotState.ACCEPTED);
            result=new ArrayList<>();
            FlowerDAO flowerDAO = DAOFactory.getInstance().getFlowerDAO();
            for (LotDBO lot:listLots) {
                FlowerDBO flower = flowerDAO.findFlowerById(lot.getFlowerId());
                result.add(new LotHeader(lot.getId(),flower.getId(),flower.getName(),lot.getCurrentPrice(),lot.getState(),lot.getCount(),lot.getEnd()));
            }
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return result;
    }

    @Override
    public List<LotHeader> findAcceptedLotHeaders(Long ownerId) throws ServiceException {
        return findLotHeadersByStateAndOwnerId(ownerId,LotState.ACCEPTED);
    }

    @Override
    public List<LotHeader> findSoldLotHeaders(Long ownerId) throws ServiceException {
        return findLotHeadersByStateAndOwnerId(ownerId,LotState.SOLD);
    }

    @Override
    public List<LotHeader> findDeniedLotHeaders(Long ownerId) throws ServiceException {
        return findLotHeadersByStateAndOwnerId(ownerId,LotState.DENIED);
    }

    @Override
    public List<LotHeader> findAddedLotHeaders(Long ownerId) throws ServiceException {
        return findLotHeadersByStateAndOwnerId(ownerId,LotState.ADDED);
    }

//    @Override
//    public LotFull findFullLotInfo(Long id) throws ServiceException {
//        LotFull result=null;
//        LotDAO lotDAO = DAOFactory.getInstance().getLotDAO();
//        FlowerDAO flowerDAO = DAOFactory.getInstance().getFlowerDAO();
//        try {
//            LotDBO lot =  lotDAO.findLotById(id);
//            FlowerDBO flower = flowerDAO.findFlowerById(lot.getFlowerId());
//
//        } catch (DAOException e) {
//            throw new ServiceException(e);
//        }
//        return result;
//    }

    private List<LotHeader> findLotHeadersByStateAndOwnerId(Long ownerId,LotState state) throws ServiceException {
        List<LotHeader> result=null;
        LotDAO lotDAO = DAOFactory.getInstance().getLotDAO();
        try {
            List<LotDBO> listLots = lotDAO.findAllLotsByStateAndOwnerId(ownerId,state);
            result=new ArrayList<>();
            FlowerDAO flowerDAO = DAOFactory.getInstance().getFlowerDAO();
            for (LotDBO lot:listLots) {
                FlowerDBO flower = flowerDAO.findFlowerById(lot.getFlowerId());
                result.add(new LotHeader(lot.getId(),flower.getId(),flower.getName(),lot.getCurrentPrice(),lot.getState(),lot.getCount(),lot.getEnd()));
            }
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return result;
    }
}
