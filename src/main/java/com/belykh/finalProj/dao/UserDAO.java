package com.belykh.finalProj.dao;

import com.belykh.finalProj.entity.dbo.UserDBO;
import com.belykh.finalProj.exception.DAOException;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by panda on 7.1.18.
 */
public interface UserDAO {
    List<UserDBO> findAllUsers() throws DAOException;

    UserDBO findUserByLogin(String login) throws DAOException;

    UserDBO findUserById(Long id) throws DAOException;

    boolean addUser(UserDBO userDBO) throws DAOException;

    boolean isLoginFree(String login) throws DAOException;

    boolean changePassword(String login, String newPass) throws DAOException;

    boolean changeUserInfo(UserDBO user) throws DAOException;

    boolean changeMoney(Long id, BigDecimal money) throws DAOException;

    boolean payment(Long ownerId, Long buyerId, BigDecimal price) throws DAOException;
}
