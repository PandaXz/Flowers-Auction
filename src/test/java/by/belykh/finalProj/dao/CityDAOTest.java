package by.belykh.finalProj.dao;

import com.belykh.finalProj.dao.CityDAO;
import com.belykh.finalProj.dao.impl.CityDAOImpl;
import com.belykh.finalProj.entity.dbo.CityDBO;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

// TODO: Auto-generated Javadoc
/**
 * The Class CityDAOTest.
 */
public class CityDAOTest extends Assert {
    private ScriptRunner scriptRunner;
    private Connection connection;
    private CityDAO cityDAO;

    /**
     * Sets the up.
     *
     * @throws Exception the exception
     */
    @BeforeClass
    public void setUp() throws Exception {
        cityDAO = new CityDAOImpl();
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
        scriptRunner.runScript(new InputStreamReader(ConnectionPool.class.getResourceAsStream("/insert/insert_city.sql")));

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
     * Find city by id test.
     *
     * @throws DAOException the DAO exception
     */
    @Test
    public void findCityById_Test() throws DAOException {
        Assert.assertEquals(cityDAO.findCityById(1l),new CityDBO(1l,"Minsk"));
    }

    /**
     * Find all cities test.
     *
     * @throws DAOException the DAO exception
     */
    @Test
    public void findAllCities_Test() throws DAOException {
        List<CityDBO> list= new ArrayList<>();
        list.add(new CityDBO(1l,"Minsk"));
        list.add(new CityDBO(2l,"Homyel"));
        list.add(new CityDBO(3l,"Vitebsk"));
        list.add(new CityDBO(4l,"Brest"));
        Assert.assertEquals(cityDAO.findCityById(1l),new CityDBO(1l,"Minsk"));
    }

    /**
     * Adds the city test.
     *
     * @throws DAOException the DAO exception
     */
    @Test
    public void addCity_Test() throws DAOException {

        CityDBO cityDBO= new CityDBO(5l,"Grodno");
        cityDAO.addCity(cityDBO);
        Assert.assertEquals(cityDAO.findCityById(5l),cityDBO);
    }

    /**
     * Find city by name positive test.
     *
     * @throws DAOException the DAO exception
     */
    @Test
    public void findCityByName_PositiveTest() throws  DAOException {
        Assert.assertTrue(cityDAO.findCityByName("Minsk"));
    }

    /**
     * Find city by name negative test.
     *
     * @throws DAOException the DAO exception
     */
    @Test
    public void findCityByName_NegativeTest() throws  DAOException {
        Assert.assertFalse(cityDAO.findCityByName("test"));
    }
}
