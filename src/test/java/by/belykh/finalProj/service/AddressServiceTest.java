package by.belykh.finalProj.service;

import com.belykh.flowerAuction.dao.AddressDAO;
import com.belykh.flowerAuction.dao.CityDAO;
import com.belykh.flowerAuction.dao.DAOFactory;
import com.belykh.flowerAuction.entity.Address;
import com.belykh.flowerAuction.entity.dto.AddressDTO;
import com.belykh.flowerAuction.entity.dto.CityDTO;
import com.belykh.flowerAuction.exception.DAOException;
import com.belykh.flowerAuction.exception.ServiceException;
import com.belykh.flowerAuction.service.AddressService;
import com.belykh.flowerAuction.service.Impl.AddressServiceImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class AddressServiceTest {
    private AddressService addressService;
    private AddressDAO addressDAO;
    private CityDAO cityDAO;


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


    @Test
    public void findAddressById_Test() throws ServiceException, DAOException {
        Address address = new Address(1l,1l,"Test",1,"TestCity");
        AddressDTO addressDTO = new AddressDTO(1l,"Test",1,1l);
        CityDTO cityDTO = new CityDTO(1l,"TestCity");
        when(addressDAO.findAddressById(1l)).thenReturn(addressDTO);
        when(cityDAO.findCityById(1l)).thenReturn(cityDTO);
        Assert.assertEquals(addressService.findAddressById(1l),address);
    }


    @Test
    public void findAllCities_Test() throws ServiceException, DAOException {
        CityDTO cityDTO = new CityDTO(1l,"TestCity");
        List<CityDTO> list = new ArrayList<>();
        list.add(cityDTO);
        list.add(cityDTO);
        when(cityDAO.findAllCities()).thenReturn(list);
        Assert.assertEquals(addressService.findAllCities(),list);
    }


    @Test
    public void addAddress_Test() throws ServiceException, DAOException {

        AddressDTO addressDTO = new AddressDTO(1l,"Test",1,1l);

        when(addressDAO.findAddressByCityIdAndAddress(1l,"Test",1)).thenReturn(addressDTO);

        Assert.assertEquals(addressService.addAddress(1l,"Test",1),new Long(1l));
    }

    @Test
    public void addCity_Test() throws ServiceException, DAOException {
        CityDTO cityDTO = new CityDTO(0l,"TestCity");

        when(cityDAO.addCity(cityDTO)).thenReturn(true);

        Assert.assertTrue(addressService.addCity("TestCity"));
    }

}
