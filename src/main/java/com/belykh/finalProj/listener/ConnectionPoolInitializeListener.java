package com.belykh.finalProj.listener;

import com.belykh.finalProj.pool.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

// TODO: Auto-generated Javadoc
/**
 * The listener interface for receiving connectionPoolInitialize events.
 * The class that is interested in processing a connectionPoolInitialize
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addConnectionPoolInitializeListener<code> method. When
 * the connectionPoolInitialize event occurs, that object's appropriate
 * method is invoked.
 *
 * @see ConnectionPoolInitializeEvent
 */
@WebListener
public class ConnectionPoolInitializeListener implements ServletContextListener {

    private static final Logger logger = LogManager.getLogger(ConnectionPoolInitializeListener.class);
    private static final int POOL_SIZE = 20;

    /* (non-Javadoc)
     * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {

        ConnectionPool.init(POOL_SIZE);

    }

    /* (non-Javadoc)
     * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {

        ConnectionPool.getInstance().destroy();

    }
}
