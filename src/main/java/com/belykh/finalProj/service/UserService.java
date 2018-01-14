package com.belykh.finalProj.service;

import com.belykh.finalProj.dao.DAOFactory;
import com.belykh.finalProj.dao.UserDAO;
import com.belykh.finalProj.entity.UserDBO;
import com.belykh.finalProj.exception.DAOException;
import com.belykh.finalProj.exception.ServiceException;
import com.belykh.finalProj.util.MD5Util;

/**
 * Created by panda on 7.1.18.
 */
public class UserService {

    public boolean Authorization(String login,String password) throws ServiceException {
        boolean result = false;
        String passHash = MD5Util.getInstance().getMD5Hash(password);
        UserDAO dao = DAOFactory.getInstance().getUserDAO();
        try {
            UserDBO userDBO = dao.findUserByLogin(login);
            if(userDBO !=null){
                result = userDBO.getPass().toUpperCase().equals(passHash.toUpperCase());
            }

        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return result;
    }
}
