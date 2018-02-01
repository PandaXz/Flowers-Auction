package by.belykh.finalProj.dao;

import com.belykh.finalProj.exception.ServiceException;
import com.belykh.finalProj.pool.ConnectionPool;
import com.belykh.finalProj.service.Impl.LotServiceImpl;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LotDAOImplTest extends Assert {

    @BeforeClass
    public void beforeClass() {
        ConnectionPool.init(1);
    }
    @AfterClass
    public void afterClass() {
        ConnectionPool.getInstance().destroy();
    }

    @Test
    public void findAllLotsByState() throws  ServiceException {
        LotServiceImpl dao = new LotServiceImpl();
        //System.out.print(dao.findAcceptedLotHeaders());
    }
}