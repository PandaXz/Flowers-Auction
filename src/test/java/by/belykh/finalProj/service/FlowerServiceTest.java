package by.belykh.finalProj.service;

import com.belykh.finalProj.dao.DAOFactory;
import com.belykh.finalProj.dao.FlowerDAO;
import com.belykh.finalProj.entity.dbo.FlowerDBO;
import com.belykh.finalProj.exception.DAOException;
import com.belykh.finalProj.exception.ServiceException;
import com.belykh.finalProj.service.FlowerService;
import com.belykh.finalProj.service.Impl.FlowerServiceImpl;
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
        FlowerDBO flower = new FlowerDBO(1L,"Test");

        when(flowerDAO.findFlowerById(1l)).thenReturn(flower);
        Assert.assertEquals(flowerService.findFlowerById(1l),flower);
    }

    @Test
    public void findAllFlowers_Test() throws ServiceException, DAOException {
        FlowerDBO flower = new FlowerDBO(1L,"Test");
        List<FlowerDBO> list = new ArrayList<>();
        list.add(flower);
        list.add(flower);
        when(flowerDAO.findAllFlowers()).thenReturn(list);
        Assert.assertEquals(flowerService.findAllFlowers(),list);
    }

    @Test
    public void addFlower_Test() throws ServiceException, DAOException {
        FlowerDBO flower = new FlowerDBO(0L,"Test");
        when(flowerDAO.findFlowerByName("Test")).thenReturn(true);
        when(flowerDAO.addFlower(flower)).thenReturn(true);
        Assert.assertTrue(flowerService.addFlower("Test"));
    }
}
