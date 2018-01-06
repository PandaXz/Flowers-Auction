package com.belykh.finalProj.pool;

import com.belykh.finalProj.pool.exception.ConnectionPoolException;

import java.io.IOException;
import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;

/**
 * Created by panda on 15.11.17.
 */
public class ConnectionPool {

    private static final String KEY_RESOURCE_PATH = "db.properties";
    private static final String KEY_DRIVER_NAME = "driver_name";
    private static final String KEY_CONNECTION_STRING = "connection_string";


    private ArrayBlockingQueue<ProxyConnection> connections;

    private ConnectionPool(final int poolSize) throws ConnectionPoolException {
        try {
            makeConnection(poolSize);
        } catch (IOException | ClassNotFoundException | SQLException e) {
            throw new ConnectionPoolException(e);
        }
    }

    public static void init(int poolSize) throws ConnectionPoolException {
        ConnectionPoolHolder.POOL_INSTANCE = new ConnectionPool(poolSize);
    }

    public void closeConnection(ProxyConnection connection) {
        connections.offer(connection);
    }

    public static ConnectionPool getInstance() {
        return ConnectionPoolHolder.POOL_INSTANCE;
    }

    public int getPoolSize() {
        return connections.size();
    }

    public Connection getConnection() throws ConnectionPoolException {
        try {
            return connections.take();
        } catch (InterruptedException e) {
            throw new ConnectionPoolException(e);
        }
    }

    public void destroy() throws ConnectionPoolException {
        int count = 0;
        for (ProxyConnection c : connections) {
            try {
                c.closeConnection();
                count++;
            } catch (SQLException e) {
                throw new ConnectionPoolException(e);
            }
        }
    }

    private void makeConnection(int poolSize) throws IOException, ClassNotFoundException, SQLException {
        Properties properties = new Properties();
        properties.load(getClass().getClassLoader().getResourceAsStream(KEY_RESOURCE_PATH));
        connections = new ArrayBlockingQueue<ProxyConnection>(poolSize);
        Class.forName(properties.getProperty(KEY_DRIVER_NAME));
        for (int i = 0; i < poolSize; i++) {
            ProxyConnection connection = new ProxyConnection(DriverManager.getConnection(properties.getProperty(KEY_CONNECTION_STRING), properties));
            connections.offer(connection);
        }
    }

    private static class ConnectionPoolHolder {
        public static ConnectionPool POOL_INSTANCE;
    }


    private class ProxyConnection implements Connection {

        private Connection connection;

        public ProxyConnection(Connection connection) {
            this.connection = connection;
        }

        public void closeConnection() throws SQLException {
            connection.close();
        }

        @Override
        public Statement createStatement() throws SQLException {
            return connection.createStatement();
        }

        @Override
        public void commit() throws SQLException {
            connection.commit();
        }

        @Override
        public void close() throws SQLException {
            ConnectionPool.this.closeConnection(this);
        }

        @Override
        public boolean isClosed() throws SQLException {
            return connection.isClosed();
        }


        @Override
        public PreparedStatement prepareStatement(String s) throws SQLException {
            return connection.prepareStatement(s);
        }

        @Override
        public CallableStatement prepareCall(String s) throws SQLException {
            return null;
        }

        @Override
        public String nativeSQL(String s) throws SQLException {
            return null;
        }

        @Override
        public void setAutoCommit(boolean b) throws SQLException {
            connection.setAutoCommit(b);
        }

        @Override
        public boolean getAutoCommit() throws SQLException {
            return false;
        }

        @Override
        public void rollback() throws SQLException {
            connection.rollback();
        }

        @Override
        public DatabaseMetaData getMetaData() throws SQLException {
            return null;
        }

        @Override
        public void setReadOnly(boolean b) throws SQLException {

        }

        @Override
        public boolean isReadOnly() throws SQLException {
            return false;
        }

        @Override
        public void setCatalog(String s) throws SQLException {

        }

        @Override
        public String getCatalog() throws SQLException {
            return null;
        }

        @Override
        public void setTransactionIsolation(int i) throws SQLException {

        }

        @Override
        public int getTransactionIsolation() throws SQLException {
            return 0;
        }

        @Override
        public SQLWarning getWarnings() throws SQLException {
            return null;
        }

        @Override
        public void clearWarnings() throws SQLException {

        }

        @Override
        public Statement createStatement(int i, int i1) throws SQLException {
            return null;
        }

        @Override
        public PreparedStatement prepareStatement(String s, int i, int i1) throws SQLException {
            return null;
        }

        @Override
        public CallableStatement prepareCall(String s, int i, int i1) throws SQLException {
            return null;
        }

        @Override
        public Map<String, Class<?>> getTypeMap() throws SQLException {
            return null;
        }

        @Override
        public void setTypeMap(Map<String, Class<?>> map) throws SQLException {

        }

        @Override
        public void setHoldability(int i) throws SQLException {

        }

        @Override
        public int getHoldability() throws SQLException {
            return 0;
        }

        @Override
        public Savepoint setSavepoint() throws SQLException {
            return null;
        }

        @Override
        public Savepoint setSavepoint(String s) throws SQLException {
            return null;
        }

        @Override
        public void rollback(Savepoint savepoint) throws SQLException {

        }

        @Override
        public void releaseSavepoint(Savepoint savepoint) throws SQLException {

        }

        @Override
        public Statement createStatement(int i, int i1, int i2) throws SQLException {
            return null;
        }

        @Override
        public PreparedStatement prepareStatement(String s, int i, int i1, int i2) throws SQLException {
            return null;
        }

        @Override
        public CallableStatement prepareCall(String s, int i, int i1, int i2) throws SQLException {
            return null;
        }

        @Override
        public PreparedStatement prepareStatement(String s, int i) throws SQLException {
            return null;
        }

        @Override
        public PreparedStatement prepareStatement(String s, int[] ints) throws SQLException {
            return null;
        }

        @Override
        public PreparedStatement prepareStatement(String s, String[] strings) throws SQLException {
            return null;
        }

        @Override
        public Clob createClob() throws SQLException {
            return null;
        }

        @Override
        public Blob createBlob() throws SQLException {
            return null;
        }

        @Override
        public NClob createNClob() throws SQLException {
            return null;
        }

        @Override
        public SQLXML createSQLXML() throws SQLException {
            return null;
        }

        @Override
        public boolean isValid(int i) throws SQLException {
            return false;
        }

        @Override
        public void setClientInfo(String s, String s1) throws SQLClientInfoException {

        }

        @Override
        public void setClientInfo(Properties properties) throws SQLClientInfoException {

        }

        @Override
        public String getClientInfo(String s) throws SQLException {
            return null;
        }

        @Override
        public Properties getClientInfo() throws SQLException {
            return null;
        }

        @Override
        public Array createArrayOf(String s, Object[] objects) throws SQLException {
            return null;
        }

        @Override
        public Struct createStruct(String s, Object[] objects) throws SQLException {
            return null;
        }

        @Override
        public void setSchema(String s) throws SQLException {

        }

        @Override
        public String getSchema() throws SQLException {
            return null;
        }

        @Override
        public void abort(Executor executor) throws SQLException {

        }

        @Override
        public void setNetworkTimeout(Executor executor, int i) throws SQLException {

        }

        @Override
        public int getNetworkTimeout() throws SQLException {
            return 0;
        }

        @Override
        public <T> T unwrap(Class<T> aClass) throws SQLException {
            return null;
        }

        @Override
        public boolean isWrapperFor(Class<?> aClass) throws SQLException {
            return false;
        }
    }
}
