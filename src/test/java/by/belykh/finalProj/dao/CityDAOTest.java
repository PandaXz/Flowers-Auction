package by.belykh.finalProj.dao;

import com.belykh.flowerAuction.dao.CityDAO;
import com.belykh.flowerAuction.dao.impl.CityDAOImpl;
import com.belykh.flowerAuction.entity.dto.CityDTO;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class CityDAOTest extends Assert {
    private ScriptRunner scriptRunner;
    private Connection connection;
    private CityDAO cityDAO;


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


    @BeforeMethod
    public void beforeMethodSetUp() throws Exception {
        scriptRunner.runScript(new InputStreamReader(ConnectionPool.class.getResourceAsStream("/insert/insert_city.sql")));

    }


    @AfterClass
    public void tearDown() throws Exception {
        Reader reader = new InputStreamReader(ConnectionPool.class.getResourceAsStream("/Drop.sql"));
        scriptRunner.runScript(reader);
        connection.close();
        ConnectionPool.getInstance().destroy();
    }



    @Test
    public void findCityById_Test() throws DAOException {
        Assert.assertEquals(cityDAO.findCityById(1l),new CityDTO(1l,"Minsk"));
    }


    @Test
    public void findAllCities_Test() throws DAOException {
        List<CityDTO> list= new ArrayList<>();
        list.add(new CityDTO(1l,"Minsk"));
        list.add(new CityDTO(2l,"Homyel"));
        list.add(new CityDTO(3l,"Vitebsk"));
        list.add(new CityDTO(4l,"Brest"));
        Assert.assertEquals(cityDAO.findCityById(1l),new CityDTO(1l,"Minsk"));
    }


    @Test
    public void addCity_Test() throws DAOException {

        CityDTO cityDTO = new CityDTO(5l,"Grodno");
        cityDAO.addCity(cityDTO);
        Assert.assertEquals(cityDAO.findCityById(5l), cityDTO);
    }


    @Test
    public void findCityByName_PositiveTest() throws  DAOException {
        Assert.assertTrue(cityDAO.findCityByName("Minsk"));
    }


    @Test
    public void findCityByName_NegativeTest() throws  DAOException {
        Assert.assertFalse(cityDAO.findCityByName("test"));
    }
}
