package com.belykh.flowerAuction.dao.impl;

import com.belykh.flowerAuction.dao.AddressDAO;
import com.belykh.flowerAuction.entity.dto.AddressDTO;
import com.belykh.flowerAuction.exception.DAOException;
import com.belykh.flowerAuction.pool.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The Class AddressDAOImpl.
 */
public class AddressDAOImpl implements AddressDAO {

    private static final String SQL_FIND_ADDRESS_BY_ID="SELECT `address`.`id`,`address`.`street`,`address`.`house_number`,`address`.`city_id_fk` FROM `address` WHERE `address`.`id`=?";
    private static final String SQL_FIND_ADDRESS_BY_CITY_ID_AND_ADDRESS="SELECT `address`.`id`,`address`.`street`,`address`.`house_number`,`address`.`city_id_fk` FROM `address` WHERE `city_id_fk`=? AND `street`=? AND `house_number`=?";
    private static final String SQL_ADD_ADDRESS = "INSERT INTO `address` ( `street`, `house_number`,`city_id_fk`) VALUES (?,?,?)";

    private static final String ADDRESS_ID="id";
    private static final String ADDRESS_CITY_ID="city_id_fk";
    private static final String ADDRESS_STREET="street";
    private static final String ADDRESS_HOUSE="house_number";

    /* (non-Javadoc)
     * @see com.belykh.flowerAuction.dao.AddressDAO#findAddressById(java.lang.Long)
     */
    @Override
    public AddressDTO findAddressById(Long id) throws DAOException {
        AddressDTO result = null;
        try(Connection connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_FIND_ADDRESS_BY_ID)) {
            statement.setLong(1,id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                result= createAddress(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return result;
    }

    /* (non-Javadoc)
     * @see com.belykh.flowerAuction.dao.AddressDAO#findAddressByCityIdAndAddress(java.lang.Long, java.lang.String, int)
     */
    @Override
    public AddressDTO findAddressByCityIdAndAddress(Long cityId, String street, int houseNumber) throws DAOException {
        try(Connection connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_FIND_ADDRESS_BY_CITY_ID_AND_ADDRESS)) {
            statement.setLong(1,cityId);
            statement.setString(2,street);
            statement.setInt(3,houseNumber);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()) {
                return createAddress(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return null;
    }

    /* (non-Javadoc)
     * @see com.belykh.flowerAuction.dao.AddressDAO#addAddress(com.belykh.flowerAuction.entity.dto.AddressDTO)
     */
    @Override
    public boolean addAddress(AddressDTO addressDTO) throws DAOException {
        try(Connection connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_ADD_ADDRESS)) {
            setStatement(statement, addressDTO);
            return (statement.executeUpdate()!=0);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }


    private AddressDTO createAddress(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getLong(ADDRESS_ID);
        String street = resultSet.getString(ADDRESS_STREET);
        int house = resultSet.getInt(ADDRESS_HOUSE);
        Long cityId = resultSet.getLong(ADDRESS_CITY_ID);
        return new AddressDTO(id,street,house,cityId);
    }
    private void setStatement(PreparedStatement ps, AddressDTO address) throws SQLException {
        ps.setString(1, address.getStreet());
        ps.setInt(2,address.getHouseNumber());
        ps.setLong(3,address.getCityId());
    }
}
