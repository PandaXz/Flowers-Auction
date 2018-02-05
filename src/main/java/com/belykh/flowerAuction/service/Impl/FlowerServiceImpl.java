package com.belykh.flowerAuction.service.Impl;

import com.belykh.flowerAuction.dao.DAOFactory;
import com.belykh.flowerAuction.dao.FlowerDAO;
import com.belykh.flowerAuction.entity.dto.FlowerDTO;
import com.belykh.flowerAuction.exception.DAOException;
import com.belykh.flowerAuction.exception.ServiceException;
import com.belykh.flowerAuction.service.FlowerService;

import java.util.List;

/**
 * The Class FlowerServiceImpl.
 */
public class FlowerServiceImpl implements FlowerService {

    /** The dao factory. */
    public static DAOFactory daoFactory = new DAOFactory();


    /* (non-Javadoc)
     * @see com.belykh.flowerAuction.service.FlowerService#findFlowerById(java.lang.Long)
     */
    @Override
    public FlowerDTO findFlowerById(Long id) throws ServiceException {
        FlowerDTO result;
        FlowerDAO dao = daoFactory.getFlowerDAO();
        try {
            result = dao.findFlowerById(id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return result;
    }

    /* (non-Javadoc)
     * @see com.belykh.flowerAuction.service.FlowerService#findAllFlowers()
     */
    @Override
    public List<FlowerDTO> findAllFlowers() throws ServiceException{
        List<FlowerDTO> result;
        FlowerDAO dao = daoFactory.getFlowerDAO();
        try {
            result = dao.findAllFlowers();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return result;
    }
    
    /* (non-Javadoc)
     * @see com.belykh.flowerAuction.service.FlowerService#addFlower(java.lang.String)
     */
    @Override
    public  boolean addFlower(String name) throws ServiceException{
        boolean result = true;
        FlowerDAO dao = daoFactory.getFlowerDAO();
        try {
            if(dao.findFlowerByName(name)) {
                result = dao.addFlower(new FlowerDTO(0L, name));
            }
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

        return result;
    }
}
