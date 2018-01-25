package com.belykh.finalProj.dao.impl;

import com.belykh.finalProj.dao.AddressDAO;
import com.belykh.finalProj.entity.dbo.AddressDBO;
import com.belykh.finalProj.exception.DAOException;
import com.belykh.finalProj.pool.ConnectionPool;
import com.belykh.finalProj.pool.exception.ConnectionPoolException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by panda on 14.1.18.
 */
public class AddressDAOImpl implements AddressDAO {

    private static final String SQL_FIND_ADDRESS_BY_ID="SELECT `address`.`id`,`address`.`street`,`address`.`house_number`,`address`.`city_id_fk` FROM `address` WHERE `address`.`id`=?";
    private static final String SQL_FIND_ALL_ADDRESSES="SELECT `address`.`id`,`address`.`street`,`address`.`house_number`,`address`.`city_id_fk` FROM `address`";
    private static final String SQL_FIND_ADDRESS_BY_CITY_ID="SELECT `address`.`id`,`address`.`street`,`address`.`house_number`,`address`.`city_id_fk` FROM `address` WHERE `city_id_fk`=?";
    private static final String SQL_ADD_ADDRESS = "INSERT INTO `address` ( `street`, `house_number`,`city_id_fk`) VALUES (?,?,?)";
    private static final String SQL_DELETE_ADDRESS = "DELETE FROM `address` WHERE `address`.`id`=?";


    private static final String ADDRESS_ID="id";
    private static final String ADDRESS_CITY_ID="city_id_fk";
    private static final String ADDRESS_STREET="street";
    private static final String ADDRESS_HOUSE="house_number";

    @Override
    public AddressDBO findAddressById(Long id) throws DAOException {
        AddressDBO result = null;
        try(Connection connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_FIND_ADDRESS_BY_ID)) {
            statement.setLong(1,id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                result= createAddress(resultSet);
            }
        } catch (SQLException |ConnectionPoolException e) {
            throw new DAOException(e);
        }
        return result;
    }

    @Override
    public List<AddressDBO> findAllAddresses() throws DAOException {
        try(Connection connection = ConnectionPool.getInstance().getConnection();
            Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(SQL_FIND_ALL_ADDRESSES);
            return createAddressList(resultSet);
        } catch (SQLException |ConnectionPoolException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public List<AddressDBO> findAddressesByCityId(Long cityId) throws DAOException {
        try(Connection connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_FIND_ADDRESS_BY_CITY_ID)) {
            statement.setLong(1,cityId);
            ResultSet resultSet = statement.executeQuery();
            return createAddressList(resultSet);
        } catch (SQLException |ConnectionPoolException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public boolean addAddress(AddressDBO addressDBO) throws DAOException {
        try(Connection connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_ADD_ADDRESS)) {
            setStatement(statement, addressDBO);
            return (statement.executeUpdate()!=0);
        } catch (SQLException|ConnectionPoolException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public boolean delete(Long id) throws DAOException {
        try(Connection connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_DELETE_ADDRESS)) {
            statement.setLong(1,id);
            return (statement.executeUpdate()!=0);
        } catch (SQLException|ConnectionPoolException e) {
            throw new DAOException(e);
        }
    }

    private List<AddressDBO> createAddressList(ResultSet resultSet) throws SQLException {
        List<AddressDBO> resultList = new ArrayList<>();
        while(resultSet.next()){
            resultList.add(createAddress(resultSet));
        }
        return resultList;
    }

    private AddressDBO createAddress(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getLong(ADDRESS_ID);
        String street = resultSet.getString(ADDRESS_STREET);
        int house = resultSet.getInt(ADDRESS_HOUSE);
        Long cityId = resultSet.getLong(ADDRESS_CITY_ID);
        return new AddressDBO(id,street,house,cityId);
    }
    private void setStatement(PreparedStatement ps, AddressDBO address) throws SQLException, DAOException {
        ps.setString(1, address.getStreet());
        ps.setInt(2,address.getHouseNumber());
        ps.setLong(3,address.getCityId());
    }
}
