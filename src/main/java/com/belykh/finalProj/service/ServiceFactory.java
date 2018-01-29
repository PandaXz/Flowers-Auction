package com.belykh.finalProj.service;

import com.belykh.finalProj.dao.FlowerDAO;
import com.belykh.finalProj.service.Impl.AddressServiceImpl;
import com.belykh.finalProj.service.Impl.FlowerServiceImpl;
import com.belykh.finalProj.service.Impl.LotServiceImpl;
import com.belykh.finalProj.service.Impl.UserServiceImpl;

public class ServiceFactory {
    private static ServiceFactory instance = new ServiceFactory();

    private final UserService userService = new UserServiceImpl();

    private final LotService lotService = new LotServiceImpl();

    private final FlowerService flowerService = new FlowerServiceImpl();

    private final AddressService addressService = new AddressServiceImpl();

    public static ServiceFactory getInstance() {
        return instance;
    }

    private ServiceFactory() {
    }

    public AddressService getAddressService() {
        return addressService;
    }

    public FlowerService getFlowerService() {
        return flowerService;
    }

    public LotService getLotService() {
        return lotService;
    }


    public UserService getUserService() {
        return userService;
    }
}
