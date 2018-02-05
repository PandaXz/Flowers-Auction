package by.belykh.finalProj.service;

import com.belykh.flowerAuction.dao.DAOFactory;
import com.belykh.flowerAuction.dao.FlowerDAO;
import com.belykh.flowerAuction.entity.dto.FlowerDTO;
import com.belykh.flowerAuction.exception.DAOException;
import com.belykh.flowerAuction.exception.ServiceException;
import com.belykh.flowerAuction.service.FlowerService;
import com.belykh.flowerAuction.service.Impl.FlowerServiceImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FlowerServiceTest {
    private FlowerService flowerService;
    private FlowerDAO flowerDAO;



    @BeforeClass
    public void setUp() throws Exception {
        FlowerServiceImpl flowerServiceImpl = new FlowerServiceImpl();

        DAOFactory daoFactory = mock(DAOFactory.class);
        flowerServiceImpl.daoFactory = daoFactory;

        flowerService = flowerServiceImpl;
        flowerDAO = mock(FlowerDAO.class);

        when(daoFactory.getFlowerDAO()).thenReturn(flowerDAO);
    }



    @Test
    public void findFlowerById_Test() throws ServiceException, DAOException {
        FlowerDTO flower = new FlowerDTO(1L,"Test");

        when(flowerDAO.findFlowerById(1l)).thenReturn(flower);
        Assert.assertEquals(flowerService.findFlowerById(1l),flower);
    }


    @Test
    public void findAllFlowers_Test() throws ServiceException, DAOException {
        FlowerDTO flower = new FlowerDTO(1L,"Test");
        List<FlowerDTO> list = new ArrayList<>();
        list.add(flower);
        list.add(flower);
        when(flowerDAO.findAllFlowers()).thenReturn(list);
        Assert.assertEquals(flowerService.findAllFlowers(),list);
    }


    @Test
    public void addFlower_Test() throws ServiceException, DAOException {
        FlowerDTO flower = new FlowerDTO(0L,"Test");
        when(flowerDAO.findFlowerByName("Test")).thenReturn(true);
        when(flowerDAO.addFlower(flower)).thenReturn(true);
        Assert.assertTrue(flowerService.addFlower("Test"));
    }
}
