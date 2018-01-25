package by.belykh.finalProject.dao;

import com.belykh.finalProj.dao.impl.LotDAOImpl;
import com.belykh.finalProj.entity.dbo.LotState;
import com.belykh.finalProj.exception.DAOException;
import com.belykh.finalProj.exception.ServiceException;
import com.belykh.finalProj.pool.ConnectionPool;
import com.belykh.finalProj.pool.exception.ConnectionPoolException;
import com.belykh.finalProj.service.Impl.LotServiceImpl;
import com.belykh.finalProj.service.LotService;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LotDAOImplTest extends Assert {

    @BeforeClass
    public void beforeClass() throws ConnectionPoolException {
        ConnectionPool.init(1);
    }
    @AfterClass
    public void afterClass() throws ConnectionPoolException {
        ConnectionPool.getInstance().destroy();
    }

    @Test
    public void findAllLotsByState() throws  ServiceException {
        LotServiceImpl dao = new LotServiceImpl();
        System.out.print(dao.findAcceptedLotHeaders());
    }
}
