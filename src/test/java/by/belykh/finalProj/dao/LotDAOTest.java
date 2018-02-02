package by.belykh.finalProj.dao;

import com.belykh.finalProj.dao.LotDAO;
import com.belykh.finalProj.dao.impl.LotDAOImpl;
import com.belykh.finalProj.entity.dbo.LotDBO;
import com.belykh.finalProj.entity.dbo.LotState;
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
import java.time.LocalDateTime;
import java.util.Properties;


public class LotDAOTest extends Assert {

    private ScriptRunner scriptRunner;
    private Connection connection;
    private LotDAO lotDAO;

    @BeforeClass
    public void setUp() throws Exception {
        lotDAO = new LotDAOImpl();
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

    }

    @AfterClass
    public void tearDown() throws Exception {
        Reader reader = new InputStreamReader(ConnectionPool.class.getResourceAsStream("/Drop.sql"));
        scriptRunner.runScript(reader);
        connection.close();
        ConnectionPool.getInstance().destroy();
    }

    @Test
    public void findLotById_Test() throws  DAOException {
        Assert.assertEquals(lotDAO.findLotById(8l),new LotDBO(8l,5l,6l,1l,5l,new BigDecimal("40.0000"),new BigDecimal("120.0000"),LotState.UNPAID,10,LocalDateTime.parse("2018-02-01T20:00:00"),"Rose, blue, natural, pickup"));
    }

    @Test(dependsOnMethods = {"findLotById_Test"})
    public void changeBuyerAndPrice_Test() throws  DAOException {
        lotDAO.changeBuyerAndPrice(11l,6l,new BigDecimal(140.0000));
        Assert.assertEquals(lotDAO.findLotById(11l),new LotDBO(11l,6l,5l,3l,5l,new BigDecimal("40.0000"),new BigDecimal("140.0000"),LotState.ACCEPTED,13,LocalDateTime.parse("2018-02-16T20:00:00"),"Pickup"));
    }

    @Test(dependsOnMethods = {"findLotById_Test"})
    public void changeState_Test() throws  DAOException {
        lotDAO.changeState(11l,LotState.UNPAID);
        Assert.assertEquals(lotDAO.findLotById(11l),new LotDBO(11l,0l,5l,3l,5l,new BigDecimal("40.0000"),new BigDecimal("40.0000"),LotState.UNPAID,13,LocalDateTime.parse("2018-02-16T20:00:00"),"Pickup"));
    }

    @Test(dependsOnMethods = {"findLotById_Test"})
    public void delete_Test() throws  DAOException {
        lotDAO.delete(11l);
        Assert.assertEquals(lotDAO.findLotById(11l),null);
    }

    @Test(dependsOnMethods = {"findLotById_Test"})
    public void checkUnpaidLots_Test() throws  DAOException {
        lotDAO.checkUnpaidLots();
        Assert.assertEquals(lotDAO.findLotById(5l),new LotDBO(5l,5l,6l,1l,5l,new BigDecimal("40.0000"),new BigDecimal("120.0000"),LotState.UNPAID,10,LocalDateTime.parse("2018-02-01T20:00:00"),"Rose, blue, natural, pickup"));
    }

    @Test(dependsOnMethods = {"findLotById_Test"})
    public void addLot_Test() throws  DAOException {
        LotDBO lot =new LotDBO(15l,0l,6l,1l,5l,new BigDecimal("40.0000"),new BigDecimal("120.0000"),LotState.UNPAID,10,LocalDateTime.parse("2018-02-01T20:00:00"),"Rose, blue, natural, pickup");
        lotDAO.addLot(lot);
        Assert.assertEquals(lotDAO.findLotById(15l),lot);
    }
}
