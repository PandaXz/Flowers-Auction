package by.belykh.finalProj.dao;

import com.belykh.finalProj.dao.AddressDAO;
import com.belykh.finalProj.dao.impl.AddressDAOImpl;
import com.belykh.finalProj.entity.dbo.AddressDBO;
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
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class AddressDAOTest extends Assert {
    private ScriptRunner scriptRunner;
    private Connection connection;
    private AddressDAO addressDAO;

    @BeforeClass
    public void setUp() throws Exception {
        addressDAO = new AddressDAOImpl();
        Properties properties = new Properties();
        properties.load(ConnectionPool.class.getResourceAsStream("/db.properties"));
        DriverManager.registerDriver(new Driver());
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/?useUnicode=true&useSSL=false&serverTimezone=GMT",
                properties.getProperty("user"), properties.getProperty("password"));
        scriptRunner = new ScriptRunner(connection, false, true);
        scriptRunner.runScript(new InputStreamReader(ConnectionPool.class.getResourceAsStream("/Insert.sql")));
        ConnectionPool.init(20);
    }

    @BeforeMethod
    public void beforeMethodSetUp() throws Exception {
        scriptRunner.runScript(new InputStreamReader(ConnectionPool.class.getResourceAsStream("/insert/insert_address.sql")));

    }

    @AfterClass
    public void tearDown() throws Exception {
        Reader reader = new InputStreamReader(ConnectionPool.class.getResourceAsStream("/Drop.sql"));
        scriptRunner.runScript(reader);
        connection.close();
        ConnectionPool.getInstance().destroy();
    }

    @Test
    public void findAddressById_Test() throws DAOException {
        AddressDBO address = new AddressDBO(1l, "Lenina", 1, 1l);
        Assert.assertEquals(addressDAO.findAddressById(1l),address);
    }

    @Test
    public void findAddressByCityIdAndAddress_Test() throws DAOException {
        AddressDBO address = new AddressDBO(1l, "Lenina", 1, 1l);
        Assert.assertEquals(addressDAO.findAddressByCityIdAndAddress(1l,"Lenina", 1),address);
    }
    @Test()
    public void addAddress_Test() throws DAOException {
        AddressDBO address = new AddressDBO(7l, "Lenina", 1, 2l);
        addressDAO.addAddress(address);
        Assert.assertEquals(addressDAO.findAddressById(7l),address);
    }
}
