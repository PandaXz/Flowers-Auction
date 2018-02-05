package com.belykh.flowerAuction.service;

import com.belykh.flowerAuction.entity.UserInfo;
import com.belykh.flowerAuction.entity.dto.UserDTO;
import com.belykh.flowerAuction.exception.ServiceException;

import java.math.BigDecimal;
import java.util.List;

/**
 * The Interface UserService.
 */
public interface UserService {

    /**
     * Authorization.
     *
     * @param login the login
     * @param password the password
     * @return the user DTO
     * @throws ServiceException the service exception
     */
    UserDTO Authorization(String login, String password) throws ServiceException;
    
    /**
     * Sign up.
     *
     * @param login the login
     * @param password the password
     * @param passwordRepeat the password repeat
     * @param email the email
     * @param firstName the first name
     * @param lastName the last name
     * @return true, if successful
     * @throws ServiceException the service exception
     */
    boolean SignUp(String login, String password, String passwordRepeat,String email,String firstName,String lastName) throws ServiceException;
    
    /**
     * Find user info.
     *
     * @param login the login
     * @return the user info
     * @throws ServiceException the service exception
     */
    UserInfo findUserInfo(String login) throws ServiceException;
    
    /**
     * Find users info.
     *
     * @return the list
     * @throws ServiceException the service exception
     */
    List<UserInfo> findUsersInfo() throws ServiceException;
    
    /**
     * Find user info by id.
     *
     * @param id the id
     * @return the user info
     * @throws ServiceException the service exception
     */
    UserInfo findUserInfoById(Long id) throws ServiceException;
    
    /**
     * Change user info.
     *
     * @param login the login
     * @param email the email
     * @param firstName the first name
     * @param lastName the last name
     * @return true, if successful
     * @throws ServiceException the service exception
     */
    boolean changeUserInfo(String login,String email, String firstName,String lastName) throws ServiceException;
    
    /**
     * Change password.
     *
     * @param login the login
     * @param newPass the new pass
     * @param newPassRepeat the new pass repeat
     * @return true, if successful
     * @throws ServiceException the service exception
     */
    boolean changePassword(String login,String newPass, String newPassRepeat) throws ServiceException;
    
    /**
     * Change balance.
     *
     * @param id the id
     * @param balance the balance
     * @return true, if successful
     * @throws ServiceException the service exception
     */
    boolean changeBalance(Long id, BigDecimal balance) throws ServiceException;

}
