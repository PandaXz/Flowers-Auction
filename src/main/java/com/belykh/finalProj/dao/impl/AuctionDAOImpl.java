package com.belykh.finalProj.dao.impl;

import com.belykh.finalProj.dao.AuctionDAO;
import com.belykh.finalProj.entity.dbo.AuctionDBO;
import com.belykh.finalProj.exception.DAOException;
import com.belykh.finalProj.pool.ConnectionPool;
import com.belykh.finalProj.pool.exception.ConnectionPoolException;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by panda on 14.1.18.
 */
public class AuctionDAOImpl implements AuctionDAO {

    private static final String SQL_FIND_AUCTION_BY_ID="SELECT `auction`.`id`,`auction`.`start_datetime`,`auction`.`end_datetime`,`auction`.`description` FROM `auction` WHERE `auction`.`id`=?";
    private static final String SQL_FIND_ALL_AUCTIONS="SELECT `auction`.`id`,`auction`.`start_datetime`,`auction`.`end_datetime`,`auction`.`description` FROM `auction`";
    private static final String SQL_ADD_AUCTION = "INSERT INTO `auction` (start_datetime, end_datetime, description) VALUES (?,?,?)";
    private static final String SQL_DELETE_AUCTION = "DELETE FROM `auction` WHERE `auction`.`id`=?";
    private static final String SQL_FIND_ACTUAL_AUCTIONS="SELECT `auction`.`id`, `auction`.`start_datetime` , `auction`.`end_datetime` , `auction`.`description` FROM `auction` WHERE  NOW() <= `auction`.`end_datetime`";


    private static final String AUCTION_ID="id";
    private static final String AUCTION_START="start_datetime";
    private static final String AUCTION_END="end_datetime";
    private static final String AUCTION_DESCRIPTION="description";

    @Override
    public AuctionDBO findAuctionById(Long id) throws DAOException {
        try(Connection connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_FIND_AUCTION_BY_ID)) {
            statement.setLong(1,id);
            ResultSet resultSet = statement.executeQuery();
            return createAuction(resultSet);
        } catch (SQLException |ConnectionPoolException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public List<AuctionDBO> findAllAuctions() throws DAOException {
        try(Connection connection = ConnectionPool.getInstance().getConnection();
            Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(SQL_FIND_ALL_AUCTIONS);
            return createAuctionsList(resultSet);
        } catch (SQLException |ConnectionPoolException e) {
            throw new DAOException(e);
        }
    }


    @Override
    public List<AuctionDBO> findActualAuctions() throws DAOException {
        try(Connection connection = ConnectionPool.getInstance().getConnection();
            Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(SQL_FIND_ACTUAL_AUCTIONS);
            return createAuctionsList(resultSet);
        } catch (SQLException |ConnectionPoolException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public boolean addAuction(AuctionDBO auctionDBO) throws DAOException {
        try(Connection connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_ADD_AUCTION)) {
            setStatement(statement, auctionDBO);
            return (statement.executeUpdate()!=0);
        } catch (SQLException|ConnectionPoolException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public boolean delete(Long id) throws DAOException {
        try(Connection connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_DELETE_AUCTION)) {
            statement.setLong(1,id);
            return (statement.executeUpdate()!=0);
        } catch (SQLException|ConnectionPoolException e) {
            throw new DAOException(e);
        }
    }

    private List<AuctionDBO> createAuctionsList(ResultSet resultSet) throws SQLException {
        List<AuctionDBO> resultList = new ArrayList<>();
        while(resultSet.next()){
            resultList.add(createAuction(resultSet));
        }
        return resultList;
    }

    private AuctionDBO createAuction(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getLong(AUCTION_ID);
        Date start = resultSet.getDate(AUCTION_START);
        Date end = resultSet.getDate(AUCTION_END);
        String desc = resultSet.getString(AUCTION_DESCRIPTION);
        return new AuctionDBO(id,start,end,desc);
    }
    private void setStatement(PreparedStatement ps, AuctionDBO auctionDBO) throws SQLException, DAOException {
        ps.setDate(1, new java.sql.Date(auctionDBO.getStart().getTime()));
        ps.setDate(2,new java.sql.Date(auctionDBO.getEnd().getTime()));
        ps.setString(3,auctionDBO.getDescription());
    }
}
