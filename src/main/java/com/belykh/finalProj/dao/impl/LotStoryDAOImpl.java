package com.belykh.finalProj.dao.impl;

import com.belykh.finalProj.dao.LotStoryDAO;
import com.belykh.finalProj.entity.dbo.LotStoryDBO;
import com.belykh.finalProj.exception.DAOException;
import com.belykh.finalProj.pool.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by panda on 14.1.18.
 */
public class LotStoryDAOImpl implements LotStoryDAO {

    private static final String SQL_FIND_LOTSTORY_BY_LOT_ID = "SELECT `lot_story`.`id`,`lot_story`.`user_id_fk`,`lot_story`.lot_id_fk, `lot_story`.price FROM `lot_story` WHERE `lot_story`.`lot_id_fk`=?";
    private static final String SQL_ADD_LOTSTORY = "INSERT INTO `lot_story` (`user_id_fk`, `lot_id_fk`,`price`) VALUES (?,?.?)";

    private static final String LOTSTORY_ID="id";
    private static final String LOTSTORY_USER_ID="user_id_fk";
    private static final String LOTSTORY_LOT_ID="lot_id_fk";
    private static final String LOTSTORY_PRICE= "offer_lot.price";


    @Override
    public List<LotStoryDBO> findLotStoryByLotId(Long lotId) throws DAOException {
        try(Connection connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_FIND_LOTSTORY_BY_LOT_ID)) {
            statement.setLong(1,lotId);
            ResultSet resultSet = statement.executeQuery();
            return createLotStoriesList(resultSet);
        } catch (SQLException  e) {
            throw new DAOException(e);
        }
    }

    @Override
    public boolean addLotStory(LotStoryDBO lotStoryDBO) throws DAOException {
        try(Connection connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_ADD_LOTSTORY)) {
            setStatement(statement, lotStoryDBO);
            return (statement.executeUpdate()!=0);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }


    private List<LotStoryDBO> createLotStoriesList(ResultSet resultSet) throws SQLException {
        List<LotStoryDBO> resultList = new ArrayList<>();
        while(resultSet.next()){
            resultList.add(createLotStory(resultSet));
        }
        return resultList;
    }

    private LotStoryDBO createLotStory(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getLong(LOTSTORY_ID);
        Long userId = resultSet.getLong(LOTSTORY_USER_ID);
        Long lotId = resultSet.getLong(LOTSTORY_LOT_ID);
        Double price = resultSet.getDouble(LOTSTORY_PRICE);
        return new LotStoryDBO(id,userId,lotId,price);
    }
    private void setStatement(PreparedStatement ps, LotStoryDBO lotStoryDBO) throws SQLException, DAOException {
        ps.setLong(1, lotStoryDBO.getUserId());
        ps.setLong(2, lotStoryDBO.getLotId());
        ps.setDouble(3,lotStoryDBO.getPrice());
    }
}
