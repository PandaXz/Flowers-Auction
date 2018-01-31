package com.belykh.finalProj.service.Impl;

import com.belykh.finalProj.dao.DAOFactory;
import com.belykh.finalProj.dao.LotDAO;
import com.belykh.finalProj.dao.LotStoryDAO;
import com.belykh.finalProj.dao.UserDAO;
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

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class LotServiceImpl implements LotService {



    @Override
    public List<LotHeader> findAcceptedLotHeaders() throws ServiceException {
        return findLotHeadersByState(LotState.ACCEPTED);
    }

    @Override
    public List<LotHeader> findAddedLotHeaders() throws ServiceException {
        return findLotHeadersByState(LotState.ADDED);
    }

    @Override
    public LotFull findFullLotInfo(Long id) throws ServiceException {
        checkUnpaidLots();
        LotFull result=null;
        LotDAO lotDAO = DAOFactory.getInstance().getLotDAO();
        try {
            LotDBO lot =  lotDAO.findLotById(id);
            if(lot!=null) {
                ServiceFactory serviceFactory = ServiceFactory.getInstance();
                FlowerDBO flower = serviceFactory.getFlowerService().findFlowerById(lot.getFlowerId());
                UserInfo owner = serviceFactory.getUserService().findUserInfoById(lot.getOwnerId());
                UserInfo buyer = serviceFactory.getUserService().findUserInfoById(lot.getBuyerId());
                Address address = serviceFactory.getAddressService().findAddressById(lot.getAddressId());
                result = new LotFull(lot.getId(),buyer,owner,flower,address,lot.getStartPrice(),lot.getCurrentPrice(),lot.getState(),lot.getCount(),lot.getEnd(),lot.getDescription());
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
        LotDAO dao = DAOFactory.getInstance().getLotDAO();
        try {
            LotDBO lot= dao.findLotById(id);
            if(lot.getOwnerId().equals(ownerId)) {
                result = dao.delete(id);
            }
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

        return result;
    }

    @Override
    public boolean buyLot(Long id, Long buyerId, Double price) throws ServiceException {
        checkUnpaidLots();
        boolean result = false;
        LotDAO dao = DAOFactory.getInstance().getLotDAO();
        LotStoryDAO lotStoryDAO = DAOFactory.getInstance().getLotStoryDAO();
        try {
            UserInfo user = ServiceFactory.getInstance().getUserService().findUserInfoById(buyerId);
            if(user.getMoney()>price) {
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
        LotDAO dao = DAOFactory.getInstance().getLotDAO();
        UserDAO userDAO = DAOFactory.getInstance().getUserDAO();
        try {
           LotDBO lot = dao.findLotById(lotId);
           if(userDAO.payment(lot.getOwnerId(),lot.getBuyerId(),lot.getCurrentPrice())){
              dao.changeState(lotId,LotState.SOLD);
              result=true;
           }
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

        return result;
    }


    @Override
    public boolean offerLot(Long ownerId, Long flowerId, Long cityId, String street, Integer houseNumber, double price, Integer count, LocalDateTime end, String description) throws ServiceException {
        boolean result = false;
        LotDAO dao = DAOFactory.getInstance().getLotDAO();
        AddressService service = ServiceFactory.getInstance().getAddressService();
        try {
            result= dao.addLot(new LotDBO(0l,null,ownerId,flowerId,service.addAddress(cityId,street,houseNumber),price,price,LotState.ADDED,count,end,description));
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

        return result;
    }

    @Override
    public boolean approveLot(Long lotId) throws ServiceException {
        boolean result = false;
        LotDAO dao = DAOFactory.getInstance().getLotDAO();
        try {
            result= dao.changeState(lotId,LotState.ACCEPTED);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

        return result;
    }

    @Override
    public boolean denyLot(Long lotId) throws ServiceException {
        boolean result = false;
        LotDAO dao = DAOFactory.getInstance().getLotDAO();
        try {
            result= dao.changeState(lotId,LotState.DENIED);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

        return result;
    }

    public List<LotHeader> findLotHeadersByStateAndOwnerId(Long ownerId,LotState state) throws ServiceException {
        checkUnpaidLots();
        List<LotHeader> result=null;
        LotDAO lotDAO = DAOFactory.getInstance().getLotDAO();
        try {
            List<LotDBO> listLots = lotDAO.findAllLotsByStateAndOwnerId(ownerId,state);
            result=new ArrayList<>();
            for (LotDBO lot:listLots) {
                FlowerDBO flower= ServiceFactory.getInstance().getFlowerService().findFlowerById(lot.getFlowerId());
                UserInfo user = ServiceFactory.getInstance().getUserService().findUserInfoById(lot.getOwnerId());
                result.add(new LotHeader(lot.getId(),flower.getId() ,flower.getName(),user.getId(),user.getLogin(),lot.getCurrentPrice(),lot.getState(),lot.getCount(),lot.getEnd()));
            }
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return result;
    }

    @Override
    public List<LotHeader> findLotHeadersByStateAndBuyerId(Long buyerId, LotState state) throws ServiceException {
        checkUnpaidLots();
        List<LotHeader> result=null;
        LotDAO lotDAO = DAOFactory.getInstance().getLotDAO();
        try {
            List<LotDBO> listLots = lotDAO.findAllLotsByStateAndBuyerId(buyerId,state);
            result=new ArrayList<>();
            for (LotDBO lot:listLots) {
                FlowerDBO flower= ServiceFactory.getInstance().getFlowerService().findFlowerById(lot.getFlowerId());
                UserInfo user = ServiceFactory.getInstance().getUserService().findUserInfoById(lot.getOwnerId());
                result.add(new LotHeader(lot.getId(),flower.getId() ,flower.getName(),user.getId(),user.getLogin(),lot.getCurrentPrice(),lot.getState(),lot.getCount(),lot.getEnd()));
            }
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return result;
    }

    private void checkUnpaidLots() throws ServiceException{
        LotDAO lotDAO = DAOFactory.getInstance().getLotDAO();
        try {
            lotDAO.checkUnpaidLots();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
    private List<LotHeader> findLotHeadersByState(LotState state) throws ServiceException {
        checkUnpaidLots();
        List<LotHeader> result=null;
        LotDAO lotDAO = DAOFactory.getInstance().getLotDAO();
        try {
            List<LotDBO> listLots = lotDAO.findAllLotsByState(state);
            result=new ArrayList<>();
            for (LotDBO lot:listLots) {
                FlowerDBO flower = ServiceFactory.getInstance().getFlowerService().findFlowerById(lot.getFlowerId());
                UserInfo user = ServiceFactory.getInstance().getUserService().findUserInfoById(lot.getOwnerId());
                result.add(new LotHeader(lot.getId(),flower.getId(),flower.getName(),user.getId(),user.getLogin(),lot.getCurrentPrice(),lot.getState(),lot.getCount(),lot.getEnd()));
            }
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return result;
    }
}
