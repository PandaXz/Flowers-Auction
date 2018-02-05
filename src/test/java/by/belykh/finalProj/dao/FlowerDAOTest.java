package by.belykh.finalProj.dao;

import com.belykh.flowerAuction.dao.FlowerDAO;
import com.belykh.flowerAuction.dao.impl.FlowerDAOImpl;
import com.belykh.flowerAuction.entity.dto.FlowerDTO;
import com.belykh.flowerAuction.exception.DAOException;
import com.belykh.flowerAuction.pool.ConnectionPool;
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


public class FlowerDAOTest extends Assert {
    private ScriptRunner scriptRunner;
    private Connection connection;
    private FlowerDAO flowerDAO;


    @BeforeClass
    public void setUp() throws Exception {
        flowerDAO = new FlowerDAOImpl();
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
        scriptRunner.runScript(new InputStreamReader(ConnectionPool.class.getResourceAsStream("/insert/insert_flowerType.sql")));

    }


    @AfterClass
    public void tearDown() throws Exception {
        Reader reader = new InputStreamReader(ConnectionPool.class.getResourceAsStream("/Drop.sql"));
        scriptRunner.runScript(reader);
        connection.close();
        ConnectionPool.getInstance().destroy();
    }


    @Test
    public void findFlowerById_Test() throws  DAOException {
        FlowerDTO flower = new FlowerDTO(1L,"Rose");
        Assert.assertEquals(flowerDAO.findFlowerById(1L),flower);
    }


    @Test
    public void findAllFlowers_Test() throws  DAOException {
        Assert.assertEquals(flowerDAO.findAllFlowers().size(),3);
    }


    @Test
    public void findFlowerByName_PositiveTest() throws  DAOException {
        Assert.assertTrue(flowerDAO.findFlowerByName("Rose"));
    }


    @Test
    public void findFlowerByName_NegativeTest() throws  DAOException {
        Assert.assertFalse(flowerDAO.findFlowerByName("test"));
    }


    @Test
    public void addFlower_Test() throws  DAOException {
        FlowerDTO flower = new FlowerDTO(4L,"Test");
        flowerDAO.addFlower(flower);
        Assert.assertEquals(flowerDAO.findFlowerById(4L),flower);
    }
}
