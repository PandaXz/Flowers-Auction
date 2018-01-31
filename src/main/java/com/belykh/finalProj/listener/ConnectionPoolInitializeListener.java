package com.belykh.finalProj.listener;

import com.belykh.finalProj.pool.ConnectionPool;
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

        ConnectionPool.init(POOL_SIZE);

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

        ConnectionPool.getInstance().destroy();

    }
}
