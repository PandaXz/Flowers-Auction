package by.belykh.finalProj.dao;

import com.belykh.flowerAuction.dao.LotHeaderDAO;
import com.belykh.flowerAuction.dao.impl.LotHeaderDAOImpl;
import com.belykh.flowerAuction.entity.dto.LotState;
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


public class LotHeaderDAOTest extends Assert {
    private ScriptRunner scriptRunner;
    private Connection connection;
    private LotHeaderDAO lotHeaderDAO;


    @BeforeClass
    public void setUp() throws Exception {
        lotHeaderDAO = new LotHeaderDAOImpl();
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
        scriptRunner.runScript(new InputStreamReader(ConnectionPool.class.getResourceAsStream("/insert/insert_lot.sql")));
        scriptRunner.runScript(new InputStreamReader(ConnectionPool.class.getResourceAsStream("/insert/insert_user.sql")));
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
    public void findLotHeadersByStateAndOwnerId_Test() throws DAOException {
        Assert.assertEquals(lotHeaderDAO.findLotHeadersByStateAndOwnerId(6l,LotState.ADDED).size(),1);
    }


    @Test
    public void findLotHeadersByStateAndBuyerId_Test() throws DAOException {
        Assert.assertEquals(lotHeaderDAO.findLotHeadersByStateAndBuyerId(5l,LotState.UNPAID).size(),1);
    }


    @Test
    public void findLotHeadersByState_Test() throws DAOException {
        Assert.assertEquals(lotHeaderDAO.findLotHeadersByState(LotState.ADDED).size(),2);
    }
}
