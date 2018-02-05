package by.belykh.finalProj.dao;

import com.belykh.finalProj.dao.LotStoryDAO;
import com.belykh.finalProj.dao.impl.LotStoryDAOImpl;
import com.belykh.finalProj.entity.dbo.LotStoryDBO;
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
 * The Class LotStoryDAOTest.
 */
public class LotStoryDAOTest extends Assert {
    private ScriptRunner scriptRunner;
    private Connection connection;
        private LotStoryDAO lotStoryDAO;

    /**
     * Sets the up.
     *
     * @throws Exception the exception
     */
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

    /**
     * Before method set up.
     *
     * @throws Exception the exception
     */
    @BeforeMethod
    public void beforeMethodSetUp() throws Exception {
        scriptRunner.runScript(new InputStreamReader(ConnectionPool.class.getResourceAsStream("/insert/insert_lot_story.sql")));

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

//    boolean addLotStory(LotStoryDBO lotStoryDBO) throws DAOException;
//
//    List<LotStoryDBO> findLotStoriesByLotId(Long id) throws DAOException;

    /**
 * Find lot stories by lot id test.
 *
 * @throws DAOException the DAO exception
 */
@Test
    public void findLotStoriesByLotId_Test() throws  DAOException {
        Assert.assertEquals(lotStoryDAO.findLotStoriesByLotId(10L).size(),1);
    }

    /**
     * Adds the lot story test.
     *
     * @throws DAOException the DAO exception
     */
    @Test
    public void addLotStory_Test() throws  DAOException {
        lotStoryDAO.addLotStory(new LotStoryDBO(0L,1L,10L,new BigDecimal("100.0000")));
        Assert.assertEquals(lotStoryDAO.findLotStoriesByLotId(10L).size(),2);
    }
}
