package com.belykh.finalProj.dao;

import com.belykh.finalProj.entity.dbo.UserDBO;
import com.belykh.finalProj.exception.DAOException;

import java.math.BigDecimal;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Interface UserDAO.
 */
public interface UserDAO {
    
    /**
     * Find all users.
     *
     * @return the list
     * @throws DAOException the DAO exception
     */
    List<UserDBO> findAllUsers() throws DAOException;

    /**
     * Find user by login.
     *
     * @param login the login
     * @return the user DBO
     * @throws DAOException the DAO exception
     */
    UserDBO findUserByLogin(String login) throws DAOException;

    /**
     * Find user by id.
     *
     * @param id the id
     * @return the user DBO
     * @throws DAOException the DAO exception
     */
    UserDBO findUserById(Long id) throws DAOException;

    /**
     * Adds the user.
     *
     * @param userDBO the user DBO
     * @return true, if successful
     * @throws DAOException the DAO exception
     */
    boolean addUser(UserDBO userDBO) throws DAOException;

    /**
     * Checks if is login free.
     *
     * @param login the login
     * @return true, if is login free
     * @throws DAOException the DAO exception
     */
    boolean isLoginFree(String login) throws DAOException;

    /**
     * Change password.
     *
     * @param login the login
     * @param newPass the new pass
     * @return true, if successful
     * @throws DAOException the DAO exception
     */
    boolean changePassword(String login, String newPass) throws DAOException;

    /**
     * Change user info.
     *
     * @param user the user
     * @return true, if successful
     * @throws DAOException the DAO exception
     */
    boolean changeUserInfo(UserDBO user) throws DAOException;

    /**
     * Change money.
     *
     * @param id the id
     * @param money the money
     * @return true, if successful
     * @throws DAOException the DAO exception
     */
    boolean changeMoney(Long id, BigDecimal money) throws DAOException;

    /**
     * Payment.
     *
     * @param ownerId the owner id
     * @param buyerId the buyer id
     * @param price the price
     * @return true, if successful
     * @throws DAOException the DAO exception
     */
    boolean payment(Long ownerId, Long buyerId, BigDecimal price) throws DAOException;
}
