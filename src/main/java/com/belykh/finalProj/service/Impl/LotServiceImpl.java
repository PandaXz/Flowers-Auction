package com.belykh.finalProj.service.Impl;

import com.belykh.finalProj.dao.*;
import com.belykh.finalProj.entity.Address;
import com.belykh.finalProj.entity.LotFull;
import com.belykh.finalProj.entity.LotHeader;
import com.belykh.finalProj.entity.UserInfo;
import com.belykh.finalProj.entity.dbo.FlowerDBO;
import com.belykh.finalProj.entity.dbo.LotDBO;
import com.belykh.finalProj.entity.dbo.LotState;
import com.belykh.finalProj.entity.dbo.LotStoryDBO;
import com.belykh.finalProj.exception.DAOException;
import com.belykh.finalProj.exception.ServiceException;
import com.belykh.finalProj.service.AddressService;
import com.belykh.finalProj.service.LotService;
import com.belykh.finalProj.service.ServiceFactory;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class LotServiceImpl implements LotService {

    private DAOFactory daoFactory = new DAOFactory();

    public void setDaoFactory(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public LotFull findFullLotInfo(Long id) throws ServiceException {
        checkUnpaidLots();
        LotFull result = null;
        LotDAO lotDAO = daoFactory.getLotDAO();
        try {
            LotDBO lot = lotDAO.findLotById(id);
            if (lot != null) {
                ServiceFactory serviceFactory = ServiceFactory.getInstance();
                FlowerDBO flower = serviceFactory.getFlowerService().findFlowerById(lot.getFlowerId());
                UserInfo owner = serviceFactory.getUserService().findUserInfoById(lot.getOwnerId());
                UserInfo buyer = serviceFactory.getUserService().findUserInfoById(lot.getBuyerId());
                Address address = serviceFactory.getAddressService().findAddressById(lot.getAddressId());
                result = new LotFull(lot.getId(), buyer, owner, flower, address, lot.getStartPrice(), lot.getCurrentPrice(), lot.getState(), lot.getCount(), lot.getEnd(), lot.getDescription());
            }
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return result;
    }

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

    @Override
    public boolean buyLot(Long id, Long buyerId, BigDecimal price) throws ServiceException {
        checkUnpaidLots();
        boolean result = false;
        LotDAO dao = daoFactory.getLotDAO();
        LotStoryDAO lotStoryDAO = daoFactory.getLotStoryDAO();
        try {
            UserInfo user = ServiceFactory.getInstance().getUserService().findUserInfoById(buyerId);
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


    @Override
    public boolean offerLot(Long ownerId, Long flowerId, Long cityId, String street, Integer houseNumber, BigDecimal price, Integer count, LocalDateTime end, String description) throws ServiceException {
        boolean result = false;
        LotDAO dao = daoFactory.getLotDAO();
        AddressService service = ServiceFactory.getInstance().getAddressService();
        try {
            result = dao.addLot(new LotDBO(0l, null, ownerId, flowerId, service.addAddress(cityId, street, houseNumber), price, price, LotState.ADDED, count, end, description));
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

        return result;
    }

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
