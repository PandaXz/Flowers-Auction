package com.belykh.finalProj.service.Impl;

import com.belykh.finalProj.dao.DAOFactory;
import com.belykh.finalProj.dao.UserDAO;
import com.belykh.finalProj.entity.UserDBO;
import com.belykh.finalProj.exception.DAOException;
import com.belykh.finalProj.exception.ServiceException;
import com.belykh.finalProj.service.UserService;
import com.belykh.finalProj.util.MD5Util;

/**
 * Created by panda on 7.1.18.
 */
public class UserServiceImpl implements UserService {

    @Override
    public UserDBO Authorization(String login, String password) throws ServiceException {
        UserDBO result = null;
        String passHash = MD5Util.getInstance().getMD5Hash(password);
        UserDAO dao = DAOFactory.getInstance().getUserDAO();
        try {
            UserDBO userDBO = dao.findUserByLogin(login);
            if(userDBO !=null&&userDBO.getPass().toUpperCase().equals(passHash.toUpperCase())){
                result = userDBO;
            }

        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return result;
    }

    @Override
    public boolean SignUp(String login, String password, String passwordRepeat, String email, String firstName, String lastName) throws ServiceException {
        boolean result = false;
            if(password.equals(passwordRepeat)){
                UserDAO dao = DAOFactory.getInstance().getUserDAO();
                try {
                    if(dao.isLoginFree(login)){
                        UserDBO newUser = new UserDBO(0l,login,MD5Util.getInstance().getMD5Hash(password),email,firstName,lastName,0,0d);
                        result= dao.addUser(newUser);
                    }
                } catch (DAOException e) {
                    throw new ServiceException(e);
                }
            }
        return result;
    }
}
