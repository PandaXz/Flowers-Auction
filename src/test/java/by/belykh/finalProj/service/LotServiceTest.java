package by.belykh.finalProj.service;

import com.belykh.flowerAuction.dao.*;
import com.belykh.flowerAuction.entity.Address;
import com.belykh.flowerAuction.entity.LotFull;
import com.belykh.flowerAuction.entity.LotHeader;
import com.belykh.flowerAuction.entity.UserInfo;
import com.belykh.flowerAuction.entity.dto.*;
import com.belykh.flowerAuction.exception.DAOException;
import com.belykh.flowerAuction.exception.ServiceException;
import com.belykh.flowerAuction.service.*;
import com.belykh.flowerAuction.service.Impl.LotServiceImpl;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;


public class LotServiceTest {


    private LotService lotService;
    private LotDAO lotDAO;
    private UserDAO userDAO;
    private LotHeaderDAO lotHeaderDAO;
    private LotStoryDAO lotStoryDAO;
    private Long lotId = 1l;
    private AddressService addressService;
    private FlowerService flowerService;
    private UserService userService;



    @BeforeClass
    public void setUp() throws Exception {
        LotServiceImpl lotServiceImpl = new LotServiceImpl();

        ServiceFactory serviceFactory = mock(ServiceFactory.class);
        DAOFactory daoFactory = mock(DAOFactory.class);
        lotServiceImpl.daoFactory = daoFactory;
        lotServiceImpl.serviceFactory = serviceFactory;

        lotService = lotServiceImpl;
        lotDAO = mock(LotDAO.class);
        userDAO = mock(UserDAO.class);
        lotHeaderDAO = mock(LotHeaderDAO.class);
        lotStoryDAO = mock(LotStoryDAO.class);
        addressService = mock(AddressService.class);
        flowerService = mock(FlowerService.class);
        userService = mock(UserService.class);

        when(daoFactory.getLotDAO()).thenReturn(lotDAO);
        when(daoFactory.getUserDAO()).thenReturn(userDAO);
        when(daoFactory.getLotHeaderDAO()).thenReturn(lotHeaderDAO);
        when(daoFactory.getLotStoryDAO()).thenReturn(lotStoryDAO);
        when(serviceFactory.getAddressService()).thenReturn(addressService);
        when(serviceFactory.getUserService()).thenReturn(userService);
        when(serviceFactory.getFlowerService()).thenReturn(flowerService);
    }


    @Test
    public void findLotHeadersByState_Test() throws ServiceException, DAOException {
        LotHeader lotHeader = new LotHeader(lotId, 1l, "Rose", 2l, "SuperUser", new BigDecimal("10.0000"), LotState.ADDED, 10, LocalDateTime.parse("2018-02-01T20:00:00"),"TestPath");
        List<LotHeader> list = new ArrayList<>();
        list.add(lotHeader);
        list.add(lotHeader);

        when(lotHeaderDAO.findLotHeadersByState(LotState.ADDED)).thenReturn(list);
        Assert.assertEquals(lotService.findLotHeadersByState(LotState.ADDED), list);
    }


    @Test
    public void findFullLotInfo_Test() throws ServiceException, DAOException {
        BigDecimal price = new BigDecimal("100.0000");
        LotDTO lot = new LotDTO(1l, null, 1l, 1l, 1l, price, price, LotState.ADDED, 10, LocalDateTime.parse("2018-02-01T20:00:00"), "Test","TestPath");
        FlowerDTO flower = new FlowerDTO(1L,"Test");
        UserInfo user = new UserInfo(5l, "SuperUser", "super.user@gmail.com", "Super", "User",  new BigDecimal("99900.0000"));
        Address address = new Address(1l,1l,"Test",1,"TestCity");
        when(lotDAO.findLotById(lotId)).thenReturn(lot);
        when(userService.findUserInfoById(1l)).thenReturn(user);
        when(flowerService.findFlowerById(1l)).thenReturn(flower);
        when(addressService.findAddressById(1l)).thenReturn(address);
        Assert.assertEquals(lotService.findFullLotInfo(lotId), new LotFull(lot.getId(), null, user, flower, address, lot.getStartPrice(), lot.getCurrentPrice(), lot.getState(), lot.getCount(), lot.getEnd(), lot.getDescription(),"TestPath") );
    }


    @Test
    public void denyLot_Test() throws ServiceException, DAOException {

        when(lotDAO.changeState(lotId, LotState.DENIED)).thenReturn(true);
        Assert.assertTrue(lotService.denyLot(lotId));
    }


    @Test
    public void findLotHeadersByStateAndId_Test() throws ServiceException, DAOException {
        LotHeader lotHeader = new LotHeader(lotId, 1l, "Rose", 2l, "SuperUser", new BigDecimal("10.0000"), LotState.ADDED, 10, LocalDateTime.parse("2018-02-01T20:00:00"),"TestPath");
        List<LotHeader> list = new ArrayList<>();
        list.add(lotHeader);
        list.add(lotHeader);

        when(lotHeaderDAO.findLotHeadersByStateAndBuyerId(1l, LotState.ADDED)).thenReturn(list);
        Assert.assertEquals(lotService.findLotHeadersByStateAndId(lotId, LotState.ADDED, true), list);
    }


    @Test
    public void findLotHeadersByStateAndId_Test1() throws ServiceException, DAOException {
        LotHeader lotHeader = new LotHeader(lotId, 1l, "Rose", 2l, "SuperUser", new BigDecimal("10.0000"), LotState.ADDED, 10, LocalDateTime.parse("2018-02-01T20:00:00"),"TestPath");
        List<LotHeader> list = new ArrayList<>();
        list.add(lotHeader);
        list.add(lotHeader);

        when(lotHeaderDAO.findLotHeadersByStateAndOwnerId(1l, LotState.ADDED)).thenReturn(list);
        Assert.assertEquals(lotService.findLotHeadersByStateAndId(1l, LotState.ADDED, false), list);
    }


    @Test
    public void deleteLot_Test() throws ServiceException, DAOException {

        when(lotDAO.delete(lotId)).thenReturn(true);
        LotDTO lot = new LotDTO();
        lot.setOwnerId(1l);
        when(lotDAO.findLotById(lotId)).thenReturn(lot);
        Assert.assertTrue(lotService.deleteLot(lotId, 1l));
    }


    @Test
    public void deleteLot_Test1() throws ServiceException, DAOException {

        when(lotDAO.delete(lotId)).thenReturn(true);
        Assert.assertTrue(lotService.deleteLot(lotId));
    }


    @Test
    public void buyLot_PositiveTest() throws ServiceException, DAOException {
        UserDTO user = new UserDTO();
        user.setBalance(new BigDecimal("130.0000"));
        BigDecimal price = new BigDecimal("100.0000");
        when(userDAO.findUserById(1l)).thenReturn(user);
        when(lotDAO.changeBuyerAndPrice(lotId, 1l, price)).thenReturn(true);
        when(lotStoryDAO.addLotStory(new LotStoryDTO(0l, 1l, lotId, price))).thenReturn(true);
        Assert.assertTrue(lotService.buyLot(lotId, 1l, price));
    }


    @Test
    public void buyLot_NegativeTest() throws ServiceException, DAOException {
        UserDTO user = new UserDTO();
        user.setBalance(new BigDecimal("90.0000"));
        BigDecimal price = new BigDecimal("100.0000");
        when(userDAO.findUserById(1l)).thenReturn(user);
        Assert.assertFalse(lotService.buyLot(lotId, 1l, price));
    }


    @Test
    public void payLot_Test() throws ServiceException, DAOException {
        BigDecimal price = new BigDecimal("100.0000");
        LotDTO lot = new LotDTO();
        lot.setOwnerId(1l);
        lot.setBuyerId(2l);
        lot.setCurrentPrice(price);
        when(lotDAO.findLotById(lotId)).thenReturn(lot);
        when(lotDAO.changeState(1l, LotState.SOLD)).thenReturn(true);
        when(userDAO.payment(1l, 2l, price)).thenReturn(true);
        Assert.assertTrue(lotService.payLot(lotId));
    }


    @Test
    public void offerLot_Test() throws ServiceException, DAOException, IOException {
        BigDecimal price = new BigDecimal("100.0000");
        Part image = mock(Part.class);
        String filePath = "TestFilePath";
        when(image.toString()).thenReturn("TestPath");
        doAnswer(new Answer<Void>() {
            @Override
            public Void answer(InvocationOnMock invocationOnMock) throws Throwable {
                return null;
            }
        }).when(image).write(filePath+ File.pathSeparator+1l +".jpg");
        when(addressService.addAddress(1l, "Test", 1)).thenReturn(1l);
        when(lotDAO.getLastId()).thenReturn(1l);
        when(lotDAO.addLot(new LotDTO(0l, null, 1l, 1l, 1l, price, price, LotState.ADDED, 10, LocalDateTime.parse("2018-02-01T20:00:00"), "Test","/auction/images/"+2l +".jpg"))).thenReturn(true);
        Assert.assertTrue(lotService.offerLot(1l, 1l, 1l, "Test", 1, price, 10, LocalDateTime.parse("2018-02-01T20:00:00"), "Test",image ,filePath ));
    }


    @Test
    public void approveLot_Test() throws ServiceException, DAOException {

        when(lotDAO.changeState(lotId, LotState.ACCEPTED)).thenReturn(true);
        Assert.assertTrue(lotService.approveLot(lotId));
    }

}
