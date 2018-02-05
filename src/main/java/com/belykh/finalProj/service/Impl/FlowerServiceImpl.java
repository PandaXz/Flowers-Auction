package com.belykh.finalProj.service.Impl;

import com.belykh.finalProj.dao.DAOFactory;
import com.belykh.finalProj.dao.FlowerDAO;
import com.belykh.finalProj.entity.dbo.FlowerDBO;
import com.belykh.finalProj.exception.DAOException;
import com.belykh.finalProj.exception.ServiceException;
import com.belykh.finalProj.service.FlowerService;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class FlowerServiceImpl.
 */
public class FlowerServiceImpl implements FlowerService {

    /** The dao factory. */
    public static DAOFactory daoFactory = new DAOFactory();


    /* (non-Javadoc)
     * @see com.belykh.finalProj.service.FlowerService#findFlowerById(java.lang.Long)
     */
    @Override
    public FlowerDBO findFlowerById(Long id) throws ServiceException {
        FlowerDBO result = null;
        FlowerDAO dao = daoFactory.getFlowerDAO();
        try {
            result = dao.findFlowerById(id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return result;
    }

    /* (non-Javadoc)
     * @see com.belykh.finalProj.service.FlowerService#findAllFlowers()
     */
    @Override
    public List<FlowerDBO> findAllFlowers() throws ServiceException{
        List<FlowerDBO> result = null;
        FlowerDAO dao = daoFactory.getFlowerDAO();
        try {
            result = dao.findAllFlowers();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return result;
    }
    
    /* (non-Javadoc)
     * @see com.belykh.finalProj.service.FlowerService#addFlower(java.lang.String)
     */
    @Override
    public  boolean addFlower(String name) throws ServiceException{
        boolean result = true;
        FlowerDAO dao = daoFactory.getFlowerDAO();
        try {
            if(dao.findFlowerByName(name)) {
                result = dao.addFlower(new FlowerDBO(0l, name));
            }
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

        return result;
    }
}
