package com.belykh.flowerAuction.dao.impl;

import com.belykh.flowerAuction.dao.CityDAO;
import com.belykh.flowerAuction.entity.dto.CityDTO;
import com.belykh.flowerAuction.exception.DAOException;
import com.belykh.flowerAuction.pool.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The Class CityDAOImpl.
 */
public class CityDAOImpl implements CityDAO {

    private static final String SQL_FIND_CITY_BY_ID="SELECT `city`.`id`,`city`.`city_name` FROM `city` WHERE `city`.`id`=?";
    private static final String SQL_FIND_CITY_BY_NAME="SELECT `city`.`id`,`city`.`city_name` FROM `city` WHERE `city`.`city_name`=?";
    private static final String SQL_FIND_ALL_CITIES="SELECT `city`.`id`,`city`.`city_name` FROM `city` ";
    private static final String SQL_ADD_CITY = "INSERT INTO `city` SET `city_name`=?";

    private static final String CITY_ID = "id";
    private static final String CITY_NAME=  "city_name";

    /* (non-Javadoc)
     * @see com.belykh.flowerAuction.dao.CityDAO#findCityById(java.lang.Long)
     */
    @Override
    public CityDTO findCityById(Long id) throws DAOException {
        CityDTO result = null;
        try(Connection connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_FIND_CITY_BY_ID)) {
            statement.setLong(1,id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                result= createCity(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return result;
    }

    /* (non-Javadoc)
     * @see com.belykh.flowerAuction.dao.CityDAO#findCityByName(java.lang.String)
     */
    @Override
    public boolean findCityByName(String name) throws DAOException {
        boolean result;
        try(Connection connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_FIND_CITY_BY_NAME)) {
            statement.setString(1,name);
            ResultSet resultSet = statement.executeQuery();
            result= resultSet.next();
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return result;
    }

    /* (non-Javadoc)
     * @see com.belykh.flowerAuction.dao.CityDAO#findAllCities()
     */
    @Override
    public List<CityDTO> findAllCities() throws DAOException {
        try(Connection connection = ConnectionPool.getInstance().getConnection();
            Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(SQL_FIND_ALL_CITIES);
            return createCityList(resultSet);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }


    /* (non-Javadoc)
     * @see com.belykh.flowerAuction.dao.CityDAO#addCity(com.belykh.flowerAuction.entity.dto.CityDTO)
     */
    @Override
    public boolean addCity(CityDTO city) throws DAOException {
        try(Connection connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_ADD_CITY)) {
            setStatement(statement, city);
            return (statement.executeUpdate()!=0);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    private List<CityDTO> createCityList(ResultSet resultSet) throws SQLException {
        List<CityDTO> resultList = new ArrayList<>();
        while(resultSet.next()){
            resultList.add(createCity(resultSet));
        }
        return resultList;
    }

    private CityDTO createCity(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getLong(CITY_ID);
        String name = resultSet.getString(CITY_NAME);
        return new CityDTO(id,name);
    }
    private void setStatement(PreparedStatement ps, CityDTO city) throws SQLException {
        ps.setString(1, city.getName());
    }
}
