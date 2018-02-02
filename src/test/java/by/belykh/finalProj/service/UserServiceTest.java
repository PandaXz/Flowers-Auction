package by.belykh.finalProj.service;

import com.belykh.finalProj.dao.DAOFactory;
import com.belykh.finalProj.dao.UserDAO;
import com.belykh.finalProj.entity.UserInfo;
import com.belykh.finalProj.entity.dbo.UserDBO;
import com.belykh.finalProj.exception.DAOException;
import com.belykh.finalProj.exception.ServiceException;
import com.belykh.finalProj.service.Impl.UserServiceImpl;
import com.belykh.finalProj.service.UserService;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserServiceTest extends Assert {

    private UserService userService;
    private UserDAO userDAO;

    @BeforeClass
    public void setUp() throws Exception {
        UserServiceImpl userServiceImpl = new UserServiceImpl();

        DAOFactory daoFactory = mock(DAOFactory.class);

        userServiceImpl.setDaoFactory(daoFactory);
        userService=userServiceImpl;
        userDAO = mock(UserDAO.class);
        when(daoFactory.getUserDAO()).thenReturn(userDAO);
    }


    @Test
    public void Authorization_Test() throws ServiceException, DAOException {
        UserDBO user = new UserDBO(5l, "SuperUser", "827CCB0EEA8A706C4C34A16891F84E7B", "super.user@gmail.com", "Super", "User", 1, new BigDecimal("99900.0000"));
        when(userDAO.findUserByLogin("SuperUser")).thenReturn(user);
        Assert.assertEquals(userService.Authorization("SuperUser","12345"),user);
    }

    @Test
    public void SignUp_Test() throws ServiceException, DAOException {
        UserDBO user = new UserDBO(0l, "SuperUser", "827CCB0EEA8A706C4C34A16891F84E7B", "super.user@gmail.com", "Super", "User", 1, new BigDecimal("0"));
        when(userDAO.addUser(user)).thenReturn(true);
        when(userDAO.isLoginFree("SuperUser")).thenReturn(true);
        Assert.assertTrue(userService.SignUp("SuperUser", "12345","12345", "super.user@gmail.com", "Super", "User"));
    }

    @Test
    public void findUserInfo_Test() throws ServiceException, DAOException {
        UserInfo user = new UserInfo(5l, "SuperUser", "super.user@gmail.com", "Super", "User",  new BigDecimal("99900.0000"));
        UserDBO userDBO = new UserDBO(5l, "SuperUser", "827CCB0EEA8A706C4C34A16891F84E7B", "super.user@gmail.com", "Super", "User", 1, new BigDecimal("99900.0000"));
        when(userDAO.findUserByLogin("SuperUser")).thenReturn(userDBO);
        Assert.assertEquals(userService.findUserInfo("SuperUser"),user);
    }

    @Test
    public void findUsersInfo_Test() throws ServiceException, DAOException {
        UserDBO user = new UserDBO(5l, "SuperUser", "827CCB0EEA8A706C4C34A16891F84E7B", "super.user@gmail.com", "Super", "User", 1, new BigDecimal("99900.0000"));
        List<UserDBO> list = new ArrayList<>();
        list.add(user);
        list.add(user);

        when(userDAO.findAllUsers()).thenReturn(list);
        Assert.assertEquals(userService.findUsersInfo().size(),2);
    }

    @Test
    public void findUserInfoById_Test() throws ServiceException, DAOException {
        UserInfo user = new UserInfo(5l, "SuperUser", "super.user@gmail.com", "Super", "User",  new BigDecimal("99900.0000"));
        UserDBO userDBO = new UserDBO(5l, "SuperUser", "827CCB0EEA8A706C4C34A16891F84E7B", "super.user@gmail.com", "Super", "User", 1, new BigDecimal("99900.0000"));
        when(userDAO.findUserById(5l)).thenReturn(userDBO);
        Assert.assertEquals(userService.findUserInfoById(5l),user);
    }

    @Test
    public void changeUserInfo_Test() throws ServiceException, DAOException {
        UserDBO userDBO = new UserDBO(5l, "SuperUser", "827CCB0EEA8A706C4C34A16891F84E7B", "super.user@gmail.com", "Super", "User", 1, new BigDecimal("99900.0000"));
        UserDBO userChanged = new UserDBO(5l, "SuperUser", "827CCB0EEA8A706C4C34A16891F84E7B", "Changed", "Changed", "Changed", 1, new BigDecimal("99900.0000"));

        when(userDAO.changeUserInfo(userChanged)).thenReturn(true);
        when(userDAO.findUserByLogin("SuperUser")).thenReturn(userDBO);
        Assert.assertTrue(userService.changeUserInfo("SuperUser", "Changed", "Changed", "Changed"));
    }

    @Test
    public void changePassword_PositiveTest() throws ServiceException, DAOException {
        when(userDAO.changePassword("SuperUser","827CCB0EEA8A706C4C34A16891F84E7B")).thenReturn(true);
        Assert.assertTrue(userService.changePassword("SuperUser", "12345", "12345"));
    }

    @Test
    public void changePassword_NegativeTest() throws ServiceException, DAOException {
        when(userDAO.changePassword("SuperUser","827CCB0EEA8A706C4C34A16891F84E7B")).thenReturn(true);
        Assert.assertFalse(userService.changePassword("SuperUser", "12344", "12345"));
    }

    @Test
    public void changeBalance_Test() throws ServiceException, DAOException {
        when(userDAO.changeMoney(0l,new BigDecimal(0.0))).thenReturn(true);
        Assert.assertTrue(userService.changeBalance(0l, new BigDecimal(0.0)));
    }


}
