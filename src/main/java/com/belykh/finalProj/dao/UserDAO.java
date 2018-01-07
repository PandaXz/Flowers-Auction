package com.belykh.finalProj.dao;

import com.belykh.finalProj.entity.User;
import com.belykh.finalProj.exception.DAOException;

import java.util.List;

/**
 * Created by panda on 7.1.18.
 */
public interface UserDAO {
    List<User> findAllUsers() throws DAOException;

    User findUserByLogin(String login) throws DAOException;

    User findUserById(Long id) throws DAOException;

    boolean addUser(User user) throws DAOException;

    boolean isLoginFree(String login) throws DAOException;

    boolean updatePassword(String login, String newPass) throws DAOException;

    boolean deleteUser(String login) throws DAOException;

    long findUserMoney(String login) throws DAOException;

    boolean changeMoney(long money,String login) throws  DAOException;
}
