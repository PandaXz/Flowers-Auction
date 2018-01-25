package com.belykh.finalProj.dao.impl;

import com.belykh.finalProj.dao.CountryDAO;
import com.belykh.finalProj.entity.dbo.CountryDBO;
import com.belykh.finalProj.exception.DAOException;
import com.belykh.finalProj.pool.ConnectionPool;
import com.belykh.finalProj.pool.exception.ConnectionPoolException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by panda on 14.1.18.
 */
public class CountryDAOImpl implements CountryDAO {

    private static final String SQL_FIND_COUNTRY_BY_ID="SELECT `country`.`id`,`country`.`country_name` FROM `country` WHERE `country`.`id`=?";
    private static final String SQL_FIND_ALL_COUNTRIES="SELECT `country`.`id`,`country`.`country_name` FROM `country`";
    private static final String SQL_ADD_COUNTRY = "INSERT INTO `country` SET `country_name`=?";
    private static final String SQL_DELETE_COUNTRY = "DELETE FROM `country` WHERE `country`.`id`=?";

    private static final String COUNTRY_ID="id";
    private static final String COUNTRY_NAME="name";

    @Override
    public CountryDBO findCountryById(Long id) throws DAOException {
        try(Connection connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_FIND_COUNTRY_BY_ID)) {
            statement.setLong(1,id);
            ResultSet resultSet = statement.executeQuery();
            return createCountry(resultSet);
        } catch (SQLException |ConnectionPoolException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public List<CountryDBO> findAllCountries() throws DAOException {
        try(Connection connection = ConnectionPool.getInstance().getConnection();
            Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(SQL_FIND_ALL_COUNTRIES);
            return createCountryList(resultSet);
        } catch (SQLException |ConnectionPoolException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public boolean addCountry(CountryDBO country) throws DAOException {
        try(Connection connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_ADD_COUNTRY)) {
            setStatement(statement, country);
            return (statement.executeUpdate()!=0);
        } catch (SQLException|ConnectionPoolException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public boolean delete(Long id) throws DAOException {
        try(Connection connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_DELETE_COUNTRY)) {
            statement.setLong(1,id);
            return (statement.executeUpdate()!=0);
        } catch (SQLException|ConnectionPoolException e) {
            throw new DAOException(e);
        }
    }

    private List<CountryDBO> createCountryList(ResultSet resultSet) throws SQLException {
        List<CountryDBO> resultList = new ArrayList<>();
        while(resultSet.next()){
            resultList.add(createCountry(resultSet));
        }
        return resultList;
    }

    private CountryDBO createCountry(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getLong(COUNTRY_ID);
        String name = resultSet.getString(COUNTRY_NAME);
        return new CountryDBO(id,name);
    }
    private void setStatement(PreparedStatement ps,CountryDBO country) throws SQLException, DAOException {
        ps.setString(1, country.getName());
    }
}
