package com.belykh.finalProj.service.Impl;

import com.belykh.finalProj.dao.DAOFactory;
import com.belykh.finalProj.dao.FlowerDAO;
import com.belykh.finalProj.entity.dbo.FlowerDBO;
import com.belykh.finalProj.exception.DAOException;
import com.belykh.finalProj.exception.ServiceException;
import com.belykh.finalProj.service.FlowerService;

import java.util.List;

public class FlowerServiceImpl implements FlowerService {
    @Override
    public FlowerDBO findFlowerById(Long id) throws ServiceException {
        FlowerDBO result = null;
        FlowerDAO dao = DAOFactory.getInstance().getFlowerDAO();
        try {
            result = dao.findFlowerById(id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return result;
    }

    @Override
    public List<FlowerDBO> findAllFlowers() throws ServiceException{
        List<FlowerDBO> result = null;
        FlowerDAO dao = DAOFactory.getInstance().getFlowerDAO();
        try {
            result = dao.findAllFlowers();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return result;
    }
}
