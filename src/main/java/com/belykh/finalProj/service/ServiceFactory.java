package com.belykh.finalProj.service;

import com.belykh.finalProj.service.Impl.LotServiceImpl;
import com.belykh.finalProj.service.Impl.UserServiceImpl;

public class ServiceFactory {
    private static ServiceFactory instance = new ServiceFactory();

    private final UserService userService = new UserServiceImpl();

    private final LotService lotService = new LotServiceImpl();

    public static ServiceFactory getInstance() {
        return instance;
    }

    private ServiceFactory() {
    }

    public LotService getLotService() {
        return lotService;
    }


    public UserService getUserService() {
        return userService;
    }
}
