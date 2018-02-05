package com.belykh.finalProj.service.Impl;

import com.belykh.finalProj.dao.*;
import com.belykh.finalProj.entity.Address;
import com.belykh.finalProj.entity.LotFull;
import com.belykh.finalProj.entity.LotHeader;
import com.belykh.finalProj.entity.UserInfo;
import com.belykh.finalProj.entity.dbo.*;
import com.belykh.finalProj.exception.DAOException;
import com.belykh.finalProj.exception.ServiceException;
import com.belykh.finalProj.service.AddressService;
import com.belykh.finalProj.service.LotService;
import com.belykh.finalProj.service.ServiceFactory;

import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class LotServiceImpl.
 */
public class LotServiceImpl implements LotService {

    /** The dao factory. */
    public static DAOFactory daoFactory = new DAOFactory();
    
    /** The service factory. */
    public static ServiceFactory serviceFactory = new ServiceFactory();

    /* (non-Javadoc)
     * @see com.belykh.finalProj.service.LotService#findFullLotInfo(java.lang.Long)
     */
    @Override
    public LotFull findFullLotInfo(Long id) throws ServiceException {
        checkUnpaidLots();
        LotFull result = null;
        LotDAO lotDAO = daoFactory.getLotDAO();
        try {
            LotDBO lot = lotDAO.findLotById(id);
            if (lot != null) {
                FlowerDBO flower = serviceFactory.getFlowerService().findFlowerById(lot.getFlowerId());
                UserInfo owner = serviceFactory.getUserService().findUserInfoById(lot.getOwnerId());
                UserInfo buyer = serviceFactory.getUserService().findUserInfoById(lot.getBuyerId());
                Address address = serviceFactory.getAddressService().findAddressById(lot.getAddressId());
                result = new LotFull(lot.getId(), buyer, owner, flower, address, lot.getStartPrice(), lot.getCurrentPrice(), lot.getState(), lot.getCount(), lot.getEnd(), lot.getDescription(),lot.getFilePath());
            }
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return result;
    }

    /* (non-Javadoc)
     * @see com.belykh.finalProj.service.LotService#deleteLot(java.lang.Long, java.lang.Long)
     */
    @Override
    public boolean deleteLot(Long id, Long ownerId) throws ServiceException {
        checkUnpaidLots();
        boolean result = false;
        LotDAO dao = daoFactory.getLotDAO();
        try {
            LotDBO lot = dao.findLotById(id);
            if (lot.getOwnerId().equals(ownerId)) {
                result = dao.delete(id);
            }
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

        return result;
    }

    /* (non-Javadoc)
     * @see com.belykh.finalProj.service.LotService#deleteLot(java.lang.Long)
     */
    @Override
    public boolean deleteLot(Long id) throws ServiceException {
        checkUnpaidLots();
        boolean result = false;
        LotDAO dao = daoFactory.getLotDAO();
        try {
            result = dao.delete(id);

        } catch (DAOException e) {
            throw new ServiceException(e);
        }

        return result;
    }

    /* (non-Javadoc)
     * @see com.belykh.finalProj.service.LotService#buyLot(java.lang.Long, java.lang.Long, java.math.BigDecimal)
     */
    @Override
    public boolean buyLot(Long id, Long buyerId, BigDecimal price) throws ServiceException {
        checkUnpaidLots();
        boolean result = false;
        LotDAO dao = daoFactory.getLotDAO();
        LotStoryDAO lotStoryDAO = daoFactory.getLotStoryDAO();
        try {
            UserDBO user = daoFactory.getUserDAO().findUserById(buyerId);
            if (user.getBalance().compareTo(price) != -1) {
                result = dao.changeBuyerAndPrice(id, buyerId, price);
                if (result) {
                    lotStoryDAO.addLotStory(new LotStoryDBO(0l, buyerId, id, price));
                }
            }
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

        return result;
    }

    /* (non-Javadoc)
     * @see com.belykh.finalProj.service.LotService#payLot(java.lang.Long)
     */
    @Override
    public boolean payLot(Long lotId) throws ServiceException {
        boolean result = false;
        LotDAO dao = daoFactory.getLotDAO();
        UserDAO userDAO = daoFactory.getUserDAO();
        try {
            LotDBO lot = dao.findLotById(lotId);
            if (userDAO.payment(lot.getOwnerId(), lot.getBuyerId(), lot.getCurrentPrice())) {
                dao.changeState(lotId, LotState.SOLD);
                result = true;
            }
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

        return result;
    }


    /* (non-Javadoc)
     * @see com.belykh.finalProj.service.LotService#offerLot(java.lang.Long, java.lang.Long, java.lang.Long, java.lang.String, java.lang.Integer, java.math.BigDecimal, java.lang.Integer, java.time.LocalDateTime, java.lang.String, javax.servlet.http.Part, java.lang.String)
     */
    @Override
    public boolean offerLot(Long ownerId, Long flowerId, Long cityId, String street, Integer houseNumber, BigDecimal price, Integer count, LocalDateTime end, String description, Part image, String savePath) throws ServiceException {
        boolean result = false;
        LotDAO dao = daoFactory.getLotDAO();
        AddressService service = serviceFactory.getAddressService();
        try {
            Long lastId = dao.getLastId()+1l;
            String filePath = savePath + File.separator + lastId  + ".jpg";
            image.write(filePath);
            filePath = "/auction/images"+File.separator + lastId  + ".jpg";
            result = dao.addLot(new LotDBO(0l, null, ownerId, flowerId, service.addAddress(cityId, street, houseNumber), price, price, LotState.ADDED, count, end, description,filePath));
        } catch (DAOException | IOException e) {
            throw new ServiceException(e);
        }

        return result;
    }

    /* (non-Javadoc)
     * @see com.belykh.finalProj.service.LotService#approveLot(java.lang.Long)
     */
    @Override
    public boolean approveLot(Long lotId) throws ServiceException {
        boolean result = false;
        LotDAO dao = daoFactory.getLotDAO();
        try {
            result = dao.changeState(lotId, LotState.ACCEPTED);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

        return result;
    }

    /* (non-Javadoc)
     * @see com.belykh.finalProj.service.LotService#denyLot(java.lang.Long)
     */
    @Override
    public boolean denyLot(Long lotId) throws ServiceException {
        boolean result = false;
        LotDAO dao = daoFactory.getLotDAO();
        try {
            result = dao.changeState(lotId, LotState.DENIED);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

        return result;
    }


    /* (non-Javadoc)
     * @see com.belykh.finalProj.service.LotService#findLotHeadersByStateAndId(java.lang.Long, com.belykh.finalProj.entity.dbo.LotState, boolean)
     */
    @Override
    public List<LotHeader> findLotHeadersByStateAndId(Long id, LotState state, boolean isBuyer) throws ServiceException {
        checkUnpaidLots();
        List<LotHeader> result = null;
        LotHeaderDAO dao = daoFactory.getLotHeaderDAO();
        try {
            if (isBuyer) {
                result = dao.findLotHeadersByStateAndBuyerId(id, state);
            }else{
                result=dao.findLotHeadersByStateAndOwnerId(id,state);
            }
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return result;
    }

    private void checkUnpaidLots() throws ServiceException {
        LotDAO lotDAO = daoFactory.getLotDAO();
        try {
            lotDAO.checkUnpaidLots();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    /* (non-Javadoc)
     * @see com.belykh.finalProj.service.LotService#findLotHeadersByState(com.belykh.finalProj.entity.dbo.LotState)
     */
    public List<LotHeader> findLotHeadersByState(LotState state) throws ServiceException {
        checkUnpaidLots();
        List<LotHeader> result;
        LotHeaderDAO dao = daoFactory.getLotHeaderDAO();
        try {
            result = dao.findLotHeadersByState(state);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return result;
    }
}
