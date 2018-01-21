package com.belykh.finalProj.listener;

import com.belykh.finalProj.pool.ConnectionPool;
import com.belykh.finalProj.pool.exception.ConnectionPoolException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Created by panda on 15.11.17.
 */
@WebListener
public class ConnectionPoolInitializeListener implements ServletContextListener {

    private static final Logger logger = LogManager.getLogger(ConnectionPoolInitializeListener.class);
    private static final int POOL_SIZE = 20;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            ConnectionPool.init(POOL_SIZE);
        } catch (ConnectionPoolException e) {
            logger.log(Level.FATAL,e);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        try {
            ConnectionPool.getInstance().destroy();
        } catch (ConnectionPoolException e) {
            logger.log(Level.FATAL,e);
        }
    }
}
