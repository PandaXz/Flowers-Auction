package by.belykh.finalProj.service;

import com.belykh.flowerAuction.dao.DAOFactory;
import com.belykh.flowerAuction.dao.UserDAO;
import com.belykh.flowerAuction.entity.UserInfo;
import com.belykh.flowerAuction.entity.dto.UserDTO;
import com.belykh.flowerAuction.exception.DAOException;
import com.belykh.flowerAuction.exception.ServiceException;
import com.belykh.flowerAuction.service.Impl.UserServiceImpl;
import com.belykh.flowerAuction.service.UserService;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class UserServiceTest{

    private UserService userService;
    private UserDAO userDAO;


    @BeforeClass
    public void setUp() throws Exception {
        UserServiceImpl userServiceImpl = new UserServiceImpl();

        DAOFactory daoFactory = mock(DAOFactory.class);

        userServiceImpl.daoFactory=daoFactory;
        userService=userServiceImpl;
        userDAO = mock(UserDAO.class);
        when(daoFactory.getUserDAO()).thenReturn(userDAO);
    }



    @Test
    public void Authorization_Test() throws ServiceException, DAOException {
        UserDTO user = new UserDTO(5l, "SuperUser", "827CCB0EEA8A706C4C34A16891F84E7B", "super.user@gmail.com", "Super", "User", 1, new BigDecimal("99900.0000"));
        when(userDAO.findUserByLogin("SuperUser")).thenReturn(user);
        Assert.assertEquals(userService.Authorization("SuperUser","12345"),user);
    }


    @Test
    public void SignUp_Test() throws ServiceException, DAOException {
        UserDTO user = new UserDTO(0l, "SuperUser", "827CCB0EEA8A706C4C34A16891F84E7B", "super.user@gmail.com", "Super", "User", 1, new BigDecimal("0"));
        when(userDAO.addUser(user)).thenReturn(true);
        when(userDAO.isLoginFree("SuperUser")).thenReturn(true);
        Assert.assertTrue(userService.SignUp("SuperUser", "12345","12345", "super.user@gmail.com", "Super", "User"));
    }


    @Test
    public void findUserInfo_Test() throws ServiceException, DAOException {
        UserInfo user = new UserInfo(5l, "SuperUser", "super.user@gmail.com", "Super", "User",  new BigDecimal("99900.0000"));
        UserDTO userDTO = new UserDTO(5l, "SuperUser", "827CCB0EEA8A706C4C34A16891F84E7B", "super.user@gmail.com", "Super", "User", 1, new BigDecimal("99900.0000"));
        when(userDAO.findUserByLogin("SuperUser")).thenReturn(userDTO);
        Assert.assertEquals(userService.findUserInfo("SuperUser"),user);
    }


    @Test
    public void findUsersInfo_Test() throws ServiceException, DAOException {
        UserDTO user = new UserDTO(5l, "SuperUser", "827CCB0EEA8A706C4C34A16891F84E7B", "super.user@gmail.com", "Super", "User", 1, new BigDecimal("99900.0000"));
        List<UserDTO> list = new ArrayList<>();
        list.add(user);
        list.add(user);

        when(userDAO.findAllUsers()).thenReturn(list);
        Assert.assertEquals(userService.findUsersInfo().size(),2);
    }


    @Test
    public void findUserInfoById_Test() throws ServiceException, DAOException {
        UserInfo user = new UserInfo(5l, "SuperUser", "super.user@gmail.com", "Super", "User",  new BigDecimal("99900.0000"));
        UserDTO userDTO = new UserDTO(5l, "SuperUser", "827CCB0EEA8A706C4C34A16891F84E7B", "super.user@gmail.com", "Super", "User", 1, new BigDecimal("99900.0000"));
        when(userDAO.findUserById(5l)).thenReturn(userDTO);
        Assert.assertEquals(userService.findUserInfoById(5l),user);
    }


    @Test
    public void changeUserInfo_Test() throws ServiceException, DAOException {
        UserDTO userDTO = new UserDTO(5l, "SuperUser", "827CCB0EEA8A706C4C34A16891F84E7B", "super.user@gmail.com", "Super", "User", 1, new BigDecimal("99900.0000"));
        UserDTO userChanged = new UserDTO(5l, "SuperUser", "827CCB0EEA8A706C4C34A16891F84E7B", "Changed", "Changed", "Changed", 1, new BigDecimal("99900.0000"));

        when(userDAO.changeUserInfo(userChanged)).thenReturn(true);
        when(userDAO.findUserByLogin("SuperUser")).thenReturn(userDTO);
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
