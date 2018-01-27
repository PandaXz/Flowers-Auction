package com.belykh.finalProj.service.Impl;

import com.belykh.finalProj.dao.DAOFactory;
import com.belykh.finalProj.dao.FlowerDAO;
import com.belykh.finalProj.entity.dbo.FlowerDBO;
import com.belykh.finalProj.exception.DAOException;
import com.belykh.finalProj.service.FlowerService;

public class FlowerServiceImpl implements FlowerService {
    @Override
    public FlowerDBO findFlowerById(Long id) {
        FlowerDBO result = null;
        FlowerDAO dao = DAOFactory.getInstance().getFlowerDAO();
        try {
            result = dao.findFlowerById(id);
        } catch (DAOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
