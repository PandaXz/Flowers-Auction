package com.belykh.finalProj.service;

import com.belykh.finalProj.entity.UserInfo;
import com.belykh.finalProj.entity.dbo.UserDBO;
import com.belykh.finalProj.exception.ServiceException;

import java.math.BigDecimal;

public interface UserService {
    UserDBO Authorization(String login, String password) throws ServiceException;
    boolean SignUp(String login, String password, String passwordRepeat,String email,String firstName,String lastName) throws ServiceException;
    UserInfo findUserInfo(String login) throws ServiceException;
    UserInfo findUserInfoById(Long id) throws ServiceException;
    boolean changeUserInfo(String login,String email, String firstName,String lastName) throws ServiceException;
    boolean changePassword(String login,String newPass, String newPassRepeat) throws ServiceException;
    boolean changeBalance(Long id, BigDecimal balance) throws ServiceException;

}
