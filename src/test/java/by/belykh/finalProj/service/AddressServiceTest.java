package by.belykh.finalProj.service;

import com.belykh.finalProj.dao.AddressDAO;
import com.belykh.finalProj.dao.CityDAO;
import com.belykh.finalProj.dao.DAOFactory;
import com.belykh.finalProj.entity.Address;
import com.belykh.finalProj.entity.dbo.AddressDBO;
import com.belykh.finalProj.entity.dbo.CityDBO;
import com.belykh.finalProj.exception.DAOException;
import com.belykh.finalProj.exception.ServiceException;
import com.belykh.finalProj.service.AddressService;
import com.belykh.finalProj.service.Impl.AddressServiceImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

// TODO: Auto-generated Javadoc
/**
 * The Class AddressServiceTest.
 */
public class AddressServiceTest {
    private AddressService addressService;
    private AddressDAO addressDAO;
    private CityDAO cityDAO;


    /**
     * Sets the up.
     *
     * @throws Exception the exception
     */
    @BeforeClass
    public void setUp() throws Exception {
        AddressServiceImpl addressServiceImpl = new AddressServiceImpl();

        DAOFactory daoFactory = mock(DAOFactory.class);
        addressServiceImpl.daoFactory = daoFactory;

        addressService = addressServiceImpl;
        addressDAO = mock(AddressDAO.class);
        cityDAO = mock(CityDAO.class);

        when(daoFactory.getCityDAO()).thenReturn(cityDAO);
        when(daoFactory.getAddressDAO()).thenReturn(addressDAO);
    }

    /**
     * Find address by id test.
     *
     * @throws ServiceException the service exception
     * @throws DAOException the DAO exception
     */
    @Test
    public void findAddressById_Test() throws ServiceException, DAOException {
        Address address = new Address(1l,1l,"Test",1,"TestCity");
        AddressDBO addressDBO = new AddressDBO(1l,"Test",1,1l);
        CityDBO cityDBO = new CityDBO(1l,"TestCity");
        when(addressDAO.findAddressById(1l)).thenReturn(addressDBO);
        when(cityDAO.findCityById(1l)).thenReturn(cityDBO);
        Assert.assertEquals(addressService.findAddressById(1l),address);
    }

    /**
     * Find all cities test.
     *
     * @throws ServiceException the service exception
     * @throws DAOException the DAO exception
     */
    @Test
    public void findAllCities_Test() throws ServiceException, DAOException {
        CityDBO cityDBO = new CityDBO(1l,"TestCity");
        List<CityDBO> list = new ArrayList<>();
        list.add(cityDBO);
        list.add(cityDBO);
        when(cityDAO.findAllCities()).thenReturn(list);
        Assert.assertEquals(addressService.findAllCities(),list);
    }

    /**
     * Adds the address test.
     *
     * @throws ServiceException the service exception
     * @throws DAOException the DAO exception
     */
    @Test
    public void addAddress_Test() throws ServiceException, DAOException {

        AddressDBO addressDBO = new AddressDBO(1l,"Test",1,1l);

        when(addressDAO.findAddressByCityIdAndAddress(1l,"Test",1)).thenReturn(addressDBO);

        Assert.assertEquals(addressService.addAddress(1l,"Test",1),new Long(1l));
    }

    /**
     * Adds the city test.
     *
     * @throws ServiceException the service exception
     * @throws DAOException the DAO exception
     */
    @Test
    public void addCity_Test() throws ServiceException, DAOException {
        CityDBO cityDBO = new CityDBO(0l,"TestCity");

        when(cityDAO.addCity(cityDBO)).thenReturn(true);

        Assert.assertTrue(addressService.addCity("TestCity"));
    }

}
