package by.belykh.finalProj.dao;

import com.belykh.flowerAuction.dao.LotStoryDAO;
import com.belykh.flowerAuction.dao.impl.LotStoryDAOImpl;
import com.belykh.flowerAuction.entity.dto.LotStoryDTO;
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
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;


public class LotStoryDAOTest extends Assert {
    private ScriptRunner scriptRunner;
    private Connection connection;
    private LotStoryDAO lotStoryDAO;


    @BeforeClass
    public void setUp() throws Exception {
        lotStoryDAO = new LotStoryDAOImpl();
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
        scriptRunner.runScript(new InputStreamReader(ConnectionPool.class.getResourceAsStream("/insert/insert_lot_story.sql")));

    }


    @AfterClass
    public void tearDown() throws Exception {
        Reader reader = new InputStreamReader(ConnectionPool.class.getResourceAsStream("/Drop.sql"));
        scriptRunner.runScript(reader);
        connection.close();
        ConnectionPool.getInstance().destroy();
    }

    @Test
    public void findLotStoriesByLotId_Test() throws DAOException {
        Assert.assertEquals(lotStoryDAO.findLotStoriesByLotId(10L).size(), 1);
    }


    @Test
    public void addLotStory_Test() throws DAOException {
        lotStoryDAO.addLotStory(new LotStoryDTO(0L, 1L, 10L, new BigDecimal("100.0000")));
        Assert.assertEquals(lotStoryDAO.findLotStoriesByLotId(10L).size(), 2);
    }
}
