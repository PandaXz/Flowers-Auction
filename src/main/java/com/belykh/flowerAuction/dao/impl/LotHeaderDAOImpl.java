package com.belykh.flowerAuction.dao.impl;

import com.belykh.flowerAuction.dao.LotHeaderDAO;
import com.belykh.flowerAuction.entity.LotHeader;
import com.belykh.flowerAuction.entity.dto.LotState;
import com.belykh.flowerAuction.exception.DAOException;
import com.belykh.flowerAuction.pool.ConnectionPool;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * The Class LotHeaderDAOImpl.
 */
public class LotHeaderDAOImpl implements LotHeaderDAO {

    private static final String SQL_FIND_LOTHEADERS_BY_STATE_AND_BUYER_ID = "SELECT `lot`.`id`, `lot`.`owner_id_fk`, `owner`.`login` AS `ownerName`, `lot`.`flowerType_id_fk`, " +
            "  `flower`.`name` AS `flowerName`, `lot`.`current_price`, `lot`.`state`, `lot`.`count`,`lot`.`end_datetime`, `lot`.`image_path` " +
            "FROM `lot` JOIN `flowerType` AS `flower` ON `lot`.`flowerType_id_fk` = `flower`.`id` " +
            "            JOIN `user` AS `owner` ON `lot`.`owner_id_fk` = `owner`.`id` " +
            "WHERE `lot`.`buyer_id_fk` = ? AND `lot`.`state` = ?";

    private static final String SQL_FIND_LOTHEADERS_BY_STATE_AND_OWNER_ID = "SELECT `lot`.`id`, `lot`.`owner_id_fk`, `owner`.`login` AS `ownerName`, `lot`.`flowerType_id_fk`, " +
            "  `flower`.`name` AS `flowerName`, `lot`.`current_price`, `lot`.`state`, `lot`.`count`,`lot`.`end_datetime`,`lot`.`image_path` " +
            "FROM `lot` JOIN `flowerType` AS `flower` ON `lot`.`flowerType_id_fk` = `flower`.`id` " +
            "            JOIN `user` AS `owner` ON `lot`.`owner_id_fk` = `owner`.`id` " +
            "WHERE `lot`.`owner_id_fk` = ? AND `lot`.`state` = ?";

    private static final String SQL_FIND_LOTHEADERS_BY_STATE = "SELECT `lot`.`id`, `lot`.`owner_id_fk`, `owner`.`login` AS `ownerName`, `lot`.`flowerType_id_fk`, " +
            "  `flower`.`name` AS `flowerName`, `lot`.`current_price`, `lot`.`state`, `lot`.`count`,`lot`.`end_datetime`,`lot`.`image_path` " +
            "FROM `lot` JOIN `flowerType` AS `flower` ON `lot`.`flowerType_id_fk` = `flower`.`id` " +
            "            JOIN `user` AS `owner` ON `lot`.`owner_id_fk` = `owner`.`id` " +
            "WHERE `lot`.`state` = ?";

    private static final String LOT_ID = "id";
    private static final String LOT_FLOWER_NAME = "flowerName";
    private static final String LOT_OWNER_ID = "owner_id_fk";
    private static final String LOT_FLOWER_ID = "flowerType_id_fk";
    private static final String LOT_OWNER_NAME = "ownerName";
    private static final String LOT_CURRENT_PRICE = "current_price";
    private static final String LOT_STATE = "state";
    private static final String LOT_COUNT = "count";
    private static final String LOT_IMAGE_PATH="image_path";
    private static final String LOT_END = "end_datetime";

    /* (non-Javadoc)
     * @see com.belykh.flowerAuction.dao.LotHeaderDAO#findLotHeadersByStateAndOwnerId(java.lang.Long, com.belykh.flowerAuction.entity.dto.LotState)
     */
    @Override
    public List<LotHeader> findLotHeadersByStateAndOwnerId(Long ownerId, LotState state) throws DAOException {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_FIND_LOTHEADERS_BY_STATE_AND_OWNER_ID)) {
            statement.setString(2, state.toString());
            statement.setLong(1, ownerId);
            ResultSet resultSet = statement.executeQuery();
            return createLotHeaderList(resultSet);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    /* (non-Javadoc)
     * @see com.belykh.flowerAuction.dao.LotHeaderDAO#findLotHeadersByStateAndBuyerId(java.lang.Long, com.belykh.flowerAuction.entity.dto.LotState)
     */
    @Override
    public List<LotHeader> findLotHeadersByStateAndBuyerId(Long buyerId, LotState state) throws DAOException {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_FIND_LOTHEADERS_BY_STATE_AND_BUYER_ID)) {
            statement.setLong(1, buyerId);
            statement.setString(2, state.toString());
            ResultSet resultSet = statement.executeQuery();
            return createLotHeaderList(resultSet);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    /* (non-Javadoc)
     * @see com.belykh.flowerAuction.dao.LotHeaderDAO#findLotHeadersByState(com.belykh.flowerAuction.entity.dto.LotState)
     */
    @Override
    public List<LotHeader> findLotHeadersByState(LotState state) throws DAOException {
        try(Connection connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_FIND_LOTHEADERS_BY_STATE)) {
            statement.setString(1,state.toString());
            ResultSet resultSet = statement.executeQuery();
            return createLotHeaderList(resultSet);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    private List<LotHeader> createLotHeaderList(ResultSet resultSet) throws SQLException {

        List<LotHeader> resultList = new ArrayList<>();
        while(resultSet.next()){
            resultList.add(createLotHeader(resultSet));
        }
        return resultList;
    }

    private LotHeader createLotHeader(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getLong(LOT_ID);
        String ownerName = resultSet.getString(LOT_OWNER_NAME);
        Long ownerId = resultSet.getLong(LOT_OWNER_ID);
        Long flowerId = resultSet.getLong(LOT_FLOWER_ID);
        String flowerName = resultSet.getString(LOT_FLOWER_NAME);
        BigDecimal currentPrice = resultSet.getBigDecimal(LOT_CURRENT_PRICE);
        LotState state = LotState.valueOf(resultSet.getString(LOT_STATE).toUpperCase());
        int count = resultSet.getInt(LOT_COUNT);
        LocalDateTime end = resultSet.getTimestamp(LOT_END).toLocalDateTime();
        String filePath = resultSet.getString(LOT_IMAGE_PATH);
        return new LotHeader(id,flowerId,flowerName,ownerId,ownerName,currentPrice,state,count,end,filePath);
    }
}
