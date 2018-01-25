package com.belykh.finalProj.dao;

import com.belykh.finalProj.entity.dbo.UserDBO;
import com.belykh.finalProj.exception.DAOException;

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

    boolean updatePassword(String login, String newPass) throws DAOException;

    boolean deleteUser(String login) throws DAOException;

    Double findUserMoney(String login) throws DAOException;

    boolean changeMoney(Double money,String login) throws  DAOException;
}
