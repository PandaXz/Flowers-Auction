package com.belykh.flowerAuction.dao;

import com.belykh.flowerAuction.entity.dto.UserDTO;
import com.belykh.flowerAuction.exception.DAOException;

import java.math.BigDecimal;
import java.util.List;

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
    List<UserDTO> findAllUsers() throws DAOException;

    /**
     * Find user by login.
     *
     * @param login the login
     * @return the user DTO
     * @throws DAOException the DAO exception
     */
    UserDTO findUserByLogin(String login) throws DAOException;

    /**
     * Find user by id.
     *
     * @param id the id
     * @return the user DTO
     * @throws DAOException the DAO exception
     */
    UserDTO findUserById(Long id) throws DAOException;

    /**
     * Adds the user.
     *
     * @param userDTO the user DTO
     * @return true, if successful
     * @throws DAOException the DAO exception
     */
    boolean addUser(UserDTO userDTO) throws DAOException;

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
    boolean changeUserInfo(UserDTO user) throws DAOException;

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
