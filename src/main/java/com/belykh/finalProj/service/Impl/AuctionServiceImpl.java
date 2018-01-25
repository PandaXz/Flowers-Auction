package com.belykh.finalProj.service.Impl;

import com.belykh.finalProj.dao.AuctionDAO;
import com.belykh.finalProj.dao.DAOFactory;
import com.belykh.finalProj.entity.dbo.AuctionDBO;
import com.belykh.finalProj.exception.DAOException;
import com.belykh.finalProj.exception.ServiceException;
import com.belykh.finalProj.service.AuctionService;

import java.util.List;

public class AuctionServiceImpl implements AuctionService {

    @Override
    public List<AuctionDBO> findAllAuctions() throws ServiceException {
        AuctionDAO dao = DAOFactory.getInstance().getAuctionDAO();
        try {
            return dao.findAllAuctions();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<AuctionDBO> findActualAuctions() throws ServiceException {
        AuctionDAO dao = DAOFactory.getInstance().getAuctionDAO();
        try {
            return dao.findActualAuctions();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
