package com.belykh.finalProj.dao.impl;

import com.belykh.finalProj.dao.LotDAO;
import com.belykh.finalProj.entity.dbo.LotDBO;
import com.belykh.finalProj.entity.dbo.LotState;
import com.belykh.finalProj.exception.DAOException;
import com.belykh.finalProj.pool.ConnectionPool;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDateTime;

// TODO: Auto-generated Javadoc
/**
 * The Class LotDAOImpl.
 */
public class LotDAOImpl implements LotDAO{

    private static final String SQL_FIND_LOT_BY_ID="SELECT `id`,`buyer_id_fk`,`owner_id_fk`,`flowerType_id_fk`,`address_id_fk`,`start_price`,`current_price`,`state`,`count`,`end_datetime`,`description`,`image_path` FROM `lot` WHERE `lot`.`id`=?";
    private static final String SQL_ADD_LOT = "INSERT INTO `lot` ( owner_id_fk, flowerType_id_fk, address_id_fk, start_price, current_price,state, `count`,`end_datetime`, description,`image_path`) VALUES (?,?,?,?,?,?,?,?,?,?)";
    private static final String SQL_DELETE_LOT = "DELETE FROM `lot` WHERE `lot`.`id`=?";
    private static final String SQL_UPDATE_STATE = "UPDATE `lot` SET `lot`.`state` = ? WHERE `lot`.`id`=?";
    private static final String SQL_UPDATE_BUYER_AND_PRICE = "UPDATE `lot` SET `current_price`=?,`buyer_id_fk`=? WHERE `lot`.`id`=? AND `lot`.`current_price` < ? AND `lot`.`state`='ACCEPTED' ";
    private static final String SQL_CHECK_UNPAID_LOTS="UPDATE `lot` SET `state`='UNPAID' WHERE `lot`.`end_datetime`<=NOW() AND `lot`.`state`='ACCEPTED' ";
    private static final String SQL_GET_LAST_ID="SELECT id FROM lot ORDER BY id DESC LIMIT 1";

    private static final String LOT_ID="id";
    private static final String LOT_BUYER_ID="buyer_id_fk";
    private static final String LOT_OWNER_ID="owner_id_fk";
    private static final String LOT_FLOWER_ID="flowerType_id_fk";
    private static final String LOT_ADDRESS_ID="address_id_fk";
    private static final String LOT_START_PRICE="start_price";
    private static final String LOT_CURRENT_PRICE="current_price";
    private static final String LOT_STATE="state";
    private static final String LOT_COUNT="count";
    private static final String LOT_END="end_datetime";
    private static final String LOT_IMAGE_PATH="image_path";
    private static final String LOT_DESCRIPTION="description";


    /* (non-Javadoc)
     * @see com.belykh.finalProj.dao.LotDAO#findLotById(java.lang.Long)
     */
    @Override
    public LotDBO findLotById(Long id) throws DAOException {
        LotDBO result = null;
        try(Connection connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_FIND_LOT_BY_ID)) {
            statement.setLong(1,id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                result =createLot(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return result;
    }

    /* (non-Javadoc)
     * @see com.belykh.finalProj.dao.LotDAO#getLastId()
     */
    @Override
    public Long getLastId() throws DAOException {
        Long result = 0l;
        try(Connection connection = ConnectionPool.getInstance().getConnection();
            Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SQL_GET_LAST_ID);
            if(resultSet.next()){
                result =resultSet.getLong(LOT_ID);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return result;
    }

    /* (non-Javadoc)
     * @see com.belykh.finalProj.dao.LotDAO#checkUnpaidLots()
     */
    @Override
    public void checkUnpaidLots() throws DAOException {
        try(Connection connection = ConnectionPool.getInstance().getConnection();
            Statement statement = connection.createStatement()) {

            statement.executeUpdate(SQL_CHECK_UNPAID_LOTS);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    /* (non-Javadoc)
     * @see com.belykh.finalProj.dao.LotDAO#changeBuyerAndPrice(java.lang.Long, java.lang.Long, java.math.BigDecimal)
     */
    @Override
    public boolean changeBuyerAndPrice(Long id, Long userId, BigDecimal newPrice) throws DAOException {
        try(Connection connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_BUYER_AND_PRICE)) {
            statement.setBigDecimal(1,newPrice);
            statement.setLong(2,userId);
            statement.setLong(3,id);
            statement.setBigDecimal(4,newPrice);
            return (statement.executeUpdate()!=0);

        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    /* (non-Javadoc)
     * @see com.belykh.finalProj.dao.LotDAO#changeState(java.lang.Long, com.belykh.finalProj.entity.dbo.LotState)
     */
    @Override
    public boolean changeState(Long id,LotState state) throws DAOException {
        try(Connection connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_STATE)) {
            statement.setLong(2,id);
            statement.setString(1,state.toString());
            return (statement.executeUpdate()!=0);

        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    /* (non-Javadoc)
     * @see com.belykh.finalProj.dao.LotDAO#addLot(com.belykh.finalProj.entity.dbo.LotDBO)
     */
    @Override
    public boolean addLot(LotDBO lotDBO) throws DAOException {
        try(Connection connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_ADD_LOT)) {
            setStatement(statement, lotDBO);
            return (statement.executeUpdate()!=0);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    /* (non-Javadoc)
     * @see com.belykh.finalProj.dao.LotDAO#delete(java.lang.Long)
     */
    @Override
    public boolean delete(Long id) throws DAOException {
        try(Connection connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_DELETE_LOT)) {
            statement.setLong(1,id);
            return (statement.executeUpdate()!=0);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    private LotDBO createLot(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getLong(LOT_ID);
        Long buyerId = resultSet.getLong(LOT_BUYER_ID);
        Long ownerId = resultSet.getLong(LOT_OWNER_ID);
        Long flowerId = resultSet.getLong(LOT_FLOWER_ID);
        Long addressId = resultSet.getLong(LOT_ADDRESS_ID);
        BigDecimal currentPrice = resultSet.getBigDecimal(LOT_CURRENT_PRICE);
        BigDecimal startPrice = resultSet.getBigDecimal(LOT_START_PRICE);
        LotState state = LotState.valueOf(resultSet.getString(LOT_STATE).toUpperCase());
        int count = resultSet.getInt(LOT_COUNT);
        LocalDateTime end = resultSet.getTimestamp(LOT_END).toLocalDateTime();
        String description = resultSet.getString(LOT_DESCRIPTION);
        String filePath = resultSet.getString(LOT_IMAGE_PATH);
        return new LotDBO(id,buyerId,ownerId,flowerId,addressId,startPrice,currentPrice,state,count,end,description,filePath);
    }
    private void setStatement(PreparedStatement ps, LotDBO lotDBO) throws SQLException {
        ps.setLong(1, lotDBO.getOwnerId());
        ps.setLong(2, lotDBO.getFlowerId());
        ps.setLong(3, lotDBO.getAddressId());
        ps.setBigDecimal(4, lotDBO.getStartPrice());
        ps.setBigDecimal(5, lotDBO.getCurrentPrice());
        ps.setString(6, lotDBO.getState().toString());
        ps.setInt(7,lotDBO.getCount());
        ps.setTimestamp(8,Timestamp.valueOf(lotDBO.getEnd()));
        ps.setString(9,lotDBO.getDescription());
        ps.setString(10,lotDBO.getFilePath());
    }
}
