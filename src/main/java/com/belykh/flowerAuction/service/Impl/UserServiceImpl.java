package com.belykh.flowerAuction.service.Impl;

import com.belykh.flowerAuction.dao.DAOFactory;
import com.belykh.flowerAuction.dao.UserDAO;
import com.belykh.flowerAuction.entity.UserInfo;
import com.belykh.flowerAuction.entity.dto.UserDTO;
import com.belykh.flowerAuction.exception.DAOException;
import com.belykh.flowerAuction.exception.ServiceException;
import com.belykh.flowerAuction.service.UserService;
import com.belykh.flowerAuction.util.MD5Util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * The Class UserServiceImpl.
 */
public class UserServiceImpl implements UserService {

    /** The dao factory. */
    public static DAOFactory daoFactory = new DAOFactory();


    /* (non-Javadoc)
     * @see com.belykh.flowerAuction.service.UserService#Authorization(java.lang.String, java.lang.String)
     */
    @Override
    public UserDTO Authorization(String login, String password) throws ServiceException {
        UserDTO result = null;
        String passHash = MD5Util.getInstance().getMD5Hash(password);
        UserDAO dao = daoFactory.getUserDAO();
        try {
            UserDTO userDTO = dao.findUserByLogin(login);
            if(userDTO !=null&& userDTO.getPass().toUpperCase().equals(passHash.toUpperCase())){
                result = userDTO;
            }

        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return result;
    }

    /* (non-Javadoc)
     * @see com.belykh.flowerAuction.service.UserService#SignUp(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public boolean SignUp(String login, String password, String passwordRepeat, String email, String firstName, String lastName) throws ServiceException {
        boolean result = false;
            if(password.equals(passwordRepeat)){
                UserDAO dao = daoFactory.getUserDAO();
                try {
                    if(dao.isLoginFree(login)){
                        UserDTO newUser = new UserDTO(0L,login,MD5Util.getInstance().getMD5Hash(password),email,firstName,lastName,1,new BigDecimal(0));
                        result= dao.addUser(newUser);
                    }
                } catch (DAOException e) {
                    throw new ServiceException(e);
                }
            }
        return result;
    }

    /* (non-Javadoc)
     * @see com.belykh.flowerAuction.service.UserService#findUsersInfo()
     */
    @Override
    public List<UserInfo> findUsersInfo() throws ServiceException {
        List<UserInfo> result = new ArrayList<>();
        UserDAO dao = daoFactory.getUserDAO();
        try {
            List<UserDTO> userList = dao.findAllUsers();
            for(UserDTO user:userList){
                result.add(new UserInfo(user.getId(),user.getLogin(),user.getEmail(),user.getFirstName(),user.getLastName(),user.getBalance()));
            }

        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return result;
    }

    /* (non-Javadoc)
     * @see com.belykh.flowerAuction.service.UserService#findUserInfo(java.lang.String)
     */
    @Override
    public UserInfo findUserInfo(String login) throws ServiceException {
        UserInfo result = null;
        UserDAO dao = daoFactory.getUserDAO();
        try {
            UserDTO user = dao.findUserByLogin(login);
            if(user !=null){
                result = new UserInfo(user.getId(),user.getLogin(),user.getEmail(),user.getFirstName(),user.getLastName(),user.getBalance());
            }

        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return result;
    }

    /* (non-Javadoc)
     * @see com.belykh.flowerAuction.service.UserService#findUserInfoById(java.lang.Long)
     */
    @Override
    public UserInfo findUserInfoById(Long id) throws ServiceException {
        UserInfo result = null;
        UserDAO dao = daoFactory.getUserDAO();
        try {
            UserDTO user = dao.findUserById(id);
            if(user !=null){
                result = new UserInfo(user.getId(),user.getLogin(),user.getEmail(),user.getFirstName(),user.getLastName(),user.getBalance());
            }

        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return result;
    }

    /* (non-Javadoc)
     * @see com.belykh.flowerAuction.service.UserService#changeUserInfo(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public boolean changeUserInfo(String login,String email, String firstName,String lastName) throws ServiceException {
        boolean result;
        UserDAO dao = daoFactory.getUserDAO();
        try {
            UserDTO user= dao.findUserByLogin(login);
            user.setEmail(email);
            user.setFirstName(firstName);
            user.setLastName(lastName);
            result= dao.changeUserInfo(user);

        } catch (DAOException e) {
            throw new ServiceException(e);
        }

        return result;
    }

    /* (non-Javadoc)
     * @see com.belykh.flowerAuction.service.UserService#changePassword(java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public boolean changePassword(String login, String newPass, String newPassRepeat) throws ServiceException {
        boolean result = false;
        if(newPass.equals(newPassRepeat)){
            UserDAO dao = daoFactory.getUserDAO();
            try {

                result = dao.changePassword(login, MD5Util.getInstance().getMD5Hash(newPass));

            } catch (DAOException e) {
                throw new ServiceException(e);
            }
        }
        return result;
    }

    /* (non-Javadoc)
     * @see com.belykh.flowerAuction.service.UserService#changeBalance(java.lang.Long, java.math.BigDecimal)
     */
    @Override
    public boolean changeBalance(Long id, BigDecimal balance) throws ServiceException {
        boolean result;
        UserDAO dao = daoFactory.getUserDAO();
        try {
            result = dao.changeMoney(id, balance);

        } catch (DAOException e) {
            throw new ServiceException(e);
        }

        return result;
    }

}
