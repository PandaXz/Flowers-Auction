package com.belykh.finalProj.service;

import com.belykh.finalProj.service.Impl.UserServiceImpl;

public class ServiceFactory {
    private static ServiceFactory instance = new ServiceFactory();

    private final UserService userService = new UserServiceImpl();

    public static ServiceFactory getInstance() {
        return instance;
    }

    private ServiceFactory() {
    }

    public UserService getUserService() {
        return userService;
    }
}
