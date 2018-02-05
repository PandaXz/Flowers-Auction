package by.belykh.finalProj.dao;

import com.belykh.finalProj.dao.UserDAO;
import com.belykh.finalProj.dao.impl.UserDAOImpl;
import com.belykh.finalProj.entity.dbo.UserDBO;
import com.belykh.finalProj.exception.DAOException;
import com.belykh.finalProj.pool.ConnectionPool;
import com.ibatis.common.jdbc.ScriptRunner;
import com.mysql.jdbc.Driver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.InputStreamReader;
import java.io.Reader;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

// TODO: Auto-generated Javadoc
/**
 * The Class UserDAOTest.
 */
public class UserDAOTest extends Assert {
    private ScriptRunner scriptRunner;
    private Connection connection;
    private UserDAO userDAO;

    /**
     * Sets the up.
     *
     * @throws Exception the exception
     */
    @BeforeClass
    public void setUp() throws Exception {
        userDAO = new UserDAOImpl();
        Properties properties = new Properties();
        properties.load(ConnectionPool.class.getResourceAsStream("/db.properties"));
        DriverManager.registerDriver(new Driver());
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/?useUnicode=true&useSSL=false&serverTimezone=GMT",
                properties.getProperty("user"), properties.getProperty("password"));
        scriptRunner = new ScriptRunner(connection, false, true);
        scriptRunner.runScript(new InputStreamReader(ConnectionPool.class.getResourceAsStream("/Insert.sql")));
        ConnectionPool.init(20);
    }

    /**
     * Before method set up.
     *
     * @throws Exception the exception
     */
    @BeforeMethod
    public void beforeMethodSetUp() throws Exception {
        scriptRunner.runScript(new InputStreamReader(ConnectionPool.class.getResourceAsStream("/insert/insert_user.sql")));

    }

    /**
     * Tear down.
     *
     * @throws Exception the exception
     */
    @AfterClass
    public void tearDown() throws Exception {
        Reader reader = new InputStreamReader(ConnectionPool.class.getResourceAsStream("/Drop.sql"));
        scriptRunner.runScript(reader);
        connection.close();
        ConnectionPool.getInstance().destroy();
    }

    /**
     * Find all users test.
     *
     * @throws DAOException the DAO exception
     */
    @Test
    public void findAllUsers_Test() throws  DAOException {
        Assert.assertEquals(userDAO.findAllUsers().size(),4);
    }

    /**
     * Find user by login test.
     *
     * @throws DAOException the DAO exception
     */
    @Test
    public void findUserByLogin_Test() throws  DAOException {
        UserDBO user = new UserDBO(5l, "SuperUser", "827CCB0EEA8A706C4C34A16891F84E7B", "super.user@gmail.com", "Super", "User", 1, new BigDecimal("99900.0000"));
        Assert.assertEquals(userDAO.findUserByLogin("superUser"),user);
    }

    /**
     * Find user by id test.
     *
     * @throws DAOException the DAO exception
     */
    @Test
    public void findUserById_Test() throws  DAOException {
        UserDBO user = new UserDBO(5l, "SuperUser", "827CCB0EEA8A706C4C34A16891F84E7B", "super.user@gmail.com", "Super", "User", 1, new BigDecimal("99900.0000"));
        Assert.assertEquals(userDAO.findUserById(5l),user);
    }

    /**
     * Adds the user test.
     *
     * @throws DAOException the DAO exception
     */
    @Test
    public void addUser_Test() throws  DAOException {
        UserDBO user = new UserDBO(7l, "SuperPuperUser", "827CCB0EEA8A706C4C34A16891F84E7B", "super.user@gmail.com", "Super", "User", 1, new BigDecimal("0.0000"));
        userDAO.addUser(user);
        Assert.assertEquals(userDAO.findUserById(7l),user);
    }

    /**
     * Checks if is login free positive test.
     *
     * @throws DAOException the DAO exception
     */
    @Test
    public void isLoginFree_PositiveTest() throws  DAOException {
        Assert.assertTrue(userDAO.isLoginFree("SuperPuperUser"));
    }

    /**
     * Checks if is login free negative test.
     *
     * @throws DAOException the DAO exception
     */
    @Test
    public void isLoginFree_NegativeTest() throws  DAOException {
        Assert.assertFalse(userDAO.isLoginFree("SuperUser"));
    }

    /**
     * Change password test.
     *
     * @throws DAOException the DAO exception
     */
    @Test
    public void changePassword_Test() throws  DAOException {
        UserDBO user = new UserDBO(5l, "SuperUser", "AAAA", "super.user@gmail.com", "Super", "User", 1, new BigDecimal("99900.0000"));
        userDAO.changePassword("SuperUser","AAAA");
        Assert.assertEquals(userDAO.findUserById(5l),user);
    }

    /**
     * Change user info test.
     *
     * @throws DAOException the DAO exception
     */
    @Test
    public void changeUserInfo_Test() throws  DAOException {
        UserDBO user = new UserDBO(5l, "SuperUser", "827CCB0EEA8A706C4C34A16891F84E7B", "superPuper.user@gmail.com", "SuperPuper", "User", 1, new BigDecimal("99900.0000"));
        userDAO.changeUserInfo(user);
        Assert.assertEquals(userDAO.findUserById(5l),user);
    }

    /**
     * Change money test.
     *
     * @throws DAOException the DAO exception
     */
    @Test
    public void changeMoney_Test() throws  DAOException {
        UserDBO user = new UserDBO(5l, "SuperUser", "827CCB0EEA8A706C4C34A16891F84E7B", "super.user@gmail.com", "Super", "User", 1, new BigDecimal("100.0000"));
        userDAO.changeMoney(5l,new BigDecimal("100.0000"));
        Assert.assertEquals(userDAO.findUserById(5l),user);
    }
    
    /**
     * Payment positive test.
     *
     * @throws DAOException the DAO exception
     */
    @Test
    public void payment_PositiveTest() throws  DAOException {
        Assert.assertTrue(userDAO.payment(4l,5l,new BigDecimal(100)));
    }

    /**
     * Payment negative test.
     *
     * @throws DAOException the DAO exception
     */
    @Test
    public void payment_NegativeTest() throws  DAOException {
        Assert.assertFalse(userDAO.payment(5l,4l,new BigDecimal(100)));
    }

}
