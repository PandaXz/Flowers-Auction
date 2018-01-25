package com.belykh.finalProj.dao.impl;

import com.belykh.finalProj.dao.LotDAO;
import com.belykh.finalProj.entity.dbo.LotDBO;
import com.belykh.finalProj.entity.dbo.LotState;
import com.belykh.finalProj.exception.DAOException;
import com.belykh.finalProj.pool.ConnectionPool;
import com.belykh.finalProj.pool.exception.ConnectionPoolException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by panda on 14.1.18.
 */
public class LotDAOImpl implements LotDAO{

    private static final String SQL_FIND_LOT_BY_ID="SELECT `id`,`buyer_id_fk`,`owner_id_fk`,`flowerType_id_fk`,`address_id_fk`,`start_price`,`current_price`,`state`,`count`,`end_datetime`,`description` FROM `lot` WHERE `lot`.`id`=?";
    private static final String SQL_FIND_LOTS_BY_STATE="SELECT `id`,`buyer_id_fk`,`owner_id_fk`,`flowerType_id_fk`,`address_id_fk`,`start_price`,`current_price`,`state`,`count`,`end_datetime`,`description` FROM `lot` WHERE `lot`.`state`=?";
    private static final String SQL_FIND_ALL_LOTS="SELECT `id`,`buyer_id_fk`,`owner_id_fk`,`flowerType_id_fk`,`address_id_fk`,`start_price`,`current_price`,`state`,`count`,`end_datetime`,`description` FROM `lot`";
    private static final String SQL_ADD_LOT = "INSERT INTO `lot` (auction_id_fk, buyer_id_fk, owner_id_fk, flowerType_id_fk, address_id_fk, start_price, current_price,state, `count`,`end_datetime`, description) VALUES (?,?,?,?,?,?,?,?,?,?)";
    private static final String SQL_DELETE_LOT = "DELETE FROM `lot` WHERE `lot`.`id`=?";
    private static final String SQL_UPDATE_STATE = "UPDATE `lot` SET `lot`.`state` = ? WHERE `lot`.`id`=?";
    private static final String SQL_UPDATE_BUYER_AND_PRICE = "UPDATE `lot` SET `lot`.`buyer_id_fk` = ?, `lot`.`current_price`=? WHERE `lot`.`id`=?";


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
    private static final String LOT_DESCRIPTION="description";


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
        } catch (SQLException |ConnectionPoolException e) {
            throw new DAOException(e);
        }
        return result;
    }

    @Override
    public List<LotDBO> findAllLots() throws DAOException {
        try(Connection connection = ConnectionPool.getInstance().getConnection();
            Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(SQL_FIND_ALL_LOTS);
            return createLotsList(resultSet);
        } catch (SQLException |ConnectionPoolException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public List<LotDBO> findAllLotsByState(LotState state) throws DAOException {

        try(Connection connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_FIND_LOTS_BY_STATE)) {
            statement.setString(1,state.toString());
            ResultSet resultSet = statement.executeQuery();
            return createLotsList(resultSet);
        } catch (SQLException |ConnectionPoolException e) {
            throw new DAOException(e);
        }
    }


    @Override
    public boolean changeBuyerAndPrice(Long id,Long userId,Double newPrice) throws DAOException {
        try(Connection connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_BUYER_AND_PRICE)) {
            statement.setLong(1,id);
            statement.setLong(2,userId);
            statement.setDouble(3,newPrice);
            ResultSet resultSet = statement.executeQuery();
            return !resultSet.next();

        } catch (SQLException|ConnectionPoolException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public boolean changeState(Long id,LotState state) throws DAOException {
        try(Connection connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_STATE)) {
            statement.setLong(1,id);
            statement.setString(2,state.toString());
            ResultSet resultSet = statement.executeQuery();
            return !resultSet.next();

        } catch (SQLException|ConnectionPoolException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public boolean addLot(LotDBO lotDBO) throws DAOException {
        try(Connection connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_ADD_LOT)) {
            setStatement(statement, lotDBO);
            return (statement.executeUpdate()!=0);
        } catch (SQLException|ConnectionPoolException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public boolean delete(Long id) throws DAOException {
        try(Connection connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_DELETE_LOT)) {
            statement.setLong(1,id);
            return (statement.executeUpdate()!=0);
        } catch (SQLException|ConnectionPoolException e) {
            throw new DAOException(e);
        }
    }

    private List<LotDBO> createLotsList(ResultSet resultSet) throws SQLException {

        Logger logger = LogManager.getLogger(LotDAOImpl.class);
        List<LotDBO> resultList = new ArrayList<>();
        while(resultSet.next()){
            logger.debug("s");
            resultList.add(createLot(resultSet));
        }
        return resultList;
    }

    private LotDBO createLot(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getLong(LOT_ID);
        Long buyerId = resultSet.getLong(LOT_BUYER_ID);
        Long ownerId = resultSet.getLong(LOT_OWNER_ID);
        Long flowerId = resultSet.getLong(LOT_FLOWER_ID);
        Long addressId = resultSet.getLong(LOT_ADDRESS_ID);
        Double currentPrice = resultSet.getDouble(LOT_CURRENT_PRICE);
        Double startPrice = resultSet.getDouble(LOT_START_PRICE);
        LotState state = LotState.valueOf(resultSet.getString(LOT_STATE).toUpperCase());
        int count = resultSet.getInt(LOT_COUNT);
        Date end = resultSet.getDate(LOT_END);
        String description = resultSet.getString(LOT_DESCRIPTION);
        return new LotDBO(id,buyerId,ownerId,flowerId,addressId,startPrice,currentPrice,state,count,end,description);
    }
    private void setStatement(PreparedStatement ps, LotDBO lotDBO) throws SQLException {
        ps.setLong(1, lotDBO.getBuyerId());
        ps.setLong(2, lotDBO.getOwnerId());
        ps.setLong(3, lotDBO.getFlowerId());
        ps.setLong(4, lotDBO.getAddressId());
        ps.setDouble(5, lotDBO.getStartPrice());
        ps.setDouble(6, lotDBO.getCurrentPrice());
        ps.setString(7, lotDBO.getState().toString());
        ps.setInt(8,lotDBO.getCount());
        ps.setDate(9,new Date(lotDBO.getEnd().getTime()));
        ps.setString(10,lotDBO.getDescription());
    }
}
