package com.belykh.finalProj.service.Impl;

import com.belykh.finalProj.dao.DAOFactory;
import com.belykh.finalProj.dao.FlowerDAO;
import com.belykh.finalProj.dao.LotDAO;
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
    public List<LotHeader> findAcceptedLotHeaders(Long id) throws ServiceException {
        List<LotHeader> result=null;
        LotDAO lotDAO = DAOFactory.getInstance().getLotDAO();
        try {
            List<LotDBO> listLots = lotDAO.findAllLotsByStateAndId(id, LotState.ACCEPTED);
            result=new ArrayList<>();
            FlowerDAO flowerDAO = DAOFactory.getInstance().getFlowerDAO();
            for (LotDBO lot:listLots) {
                FlowerDBO flower = flowerDAO.findFlowerById(lot.getFlowerId());
                result.add(new LotHeader(lot.getId(),flower.getId(),flower.getName(),lot.getCurrentPrice(),lot.getState(),lot.getCount()));
            }
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return result;
    }
}
