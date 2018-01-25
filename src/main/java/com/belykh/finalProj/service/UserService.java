package com.belykh.finalProj.service;

import com.belykh.finalProj.entity.dbo.UserDBO;
import com.belykh.finalProj.exception.ServiceException;

public interface UserService {
    UserDBO Authorization(String login, String password) throws ServiceException;
    boolean SignUp(String login, String password, String passwordRepeat,String email,String firstName,String lastName) throws ServiceException;
}
