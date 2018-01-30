package by.belykh.finalProj.dao;

import com.belykh.finalProj.dao.UserDAO;
import com.belykh.finalProj.dao.impl.UserDAOImpl;
import com.belykh.finalProj.exception.DAOException;
import com.belykh.finalProj.pool.ConnectionPool;
import com.belykh.finalProj.pool.exception.ConnectionPoolException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UserDAOImplTest extends Assert {
    @BeforeClass
    public void beforeClass() throws ConnectionPoolException {
        ConnectionPool.init(1);
    }
    @AfterClass
    public void afterClass() throws ConnectionPoolException {
        ConnectionPool.getInstance().destroy();
    }

    @Test
    public void findAllLotsByState() throws  DAOException {
        UserDAO dao = new UserDAOImpl();
        //System.out.print(dao.payment(3l,2l,100d));
    }
}
