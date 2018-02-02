package by.belykh.finalProj.service;

import com.belykh.finalProj.dao.DAOFactory;
import com.belykh.finalProj.dao.LotDAO;
import com.belykh.finalProj.service.Impl.LotServiceImpl;
import com.belykh.finalProj.service.LotService;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LotServiceTest  extends Assert {


        private LotService lotService;
        private LotDAO lotDAO;

        @BeforeClass
        public void setUp() throws Exception {
            LotServiceImpl lotServiceImpl = new LotServiceImpl();

            DAOFactory daoFactory = mock(DAOFactory.class);

            lotServiceImpl.setDaoFactory(daoFactory);
            lotService =lotServiceImpl;
            lotDAO = mock(LotDAO.class);
            when(daoFactory.getLotDAO()).thenReturn(lotDAO);
        }

//    List<LotHeader> findLotHeadersByState(LotState state) throws ServiceException;
//    boolean denyLot(Long lotId) throws ServiceException;
//    List<LotHeader> findLotHeadersByStateAndId(Long id, LotState state, boolean isBuyer) throws ServiceException;
//    LotFull findFullLotInfo(Long id) throws ServiceException;
//    boolean deleteLot(Long id,Long ownerId) throws ServiceException;
//    boolean buyLot(Long id, Long buyerId, BigDecimal price) throws ServiceException;
//    boolean payLot(Long lotId) throws ServiceException;
//    boolean offerLot(Long ownerId, Long flowerId, Long cityId, String street, Integer houseNumber, BigDecimal price, Integer count, LocalDateTime end, String description) throws ServiceException;
//    boolean approveLot(Long lotId) throws ServiceException;



}
