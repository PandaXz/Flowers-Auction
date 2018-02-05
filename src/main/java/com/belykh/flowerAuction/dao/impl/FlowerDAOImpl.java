package com.belykh.flowerAuction.dao.impl;

import com.belykh.flowerAuction.dao.FlowerDAO;
import com.belykh.flowerAuction.entity.dto.FlowerDTO;
import com.belykh.flowerAuction.exception.DAOException;
import com.belykh.flowerAuction.pool.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The Class FlowerDAOImpl.
 */
public class FlowerDAOImpl implements FlowerDAO {

    private static final String SQL_FIND_FLOWER_BY_ID="SELECT `flowerType`.`id`,`flowerType`.`name` FROM `flowerType` WHERE `flowerType`.`id`=?";
    private static final String SQL_FIND_FLOWER_BY_NAME="SELECT `flowerType`.`id`,`flowerType`.`name` FROM `flowerType` WHERE `flowerType`.`name`=?";
    private static final String SQL_FIND_ALL_FLOWERS="SELECT `flowerType`.`id`,`flowerType`.`name` FROM `flowerType` ";
    private static final String SQL_ADD_FLOWER = "INSERT INTO `flowerType` (`name`) VALUES (?)";

    private static final String FLOWER_ID="id";
    private static final String FLOWER_NAME="name";

    /* (non-Javadoc)
     * @see com.belykh.flowerAuction.dao.FlowerDAO#findFlowerById(java.lang.Long)
     */
    @Override
    public FlowerDTO findFlowerById(Long id) throws DAOException {
        FlowerDTO result = null;
        try(Connection connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_FIND_FLOWER_BY_ID)) {
            statement.setLong(1,id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                result =createFlower(resultSet);}
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return result;
    }

    /* (non-Javadoc)
     * @see com.belykh.flowerAuction.dao.FlowerDAO#findFlowerByName(java.lang.String)
     */
    @Override
    public boolean findFlowerByName(String name) throws DAOException {

        try(Connection connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_FIND_FLOWER_BY_NAME)) {
            statement.setString(1,name);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    /* (non-Javadoc)
     * @see com.belykh.flowerAuction.dao.FlowerDAO#findAllFlowers()
     */
    @Override
    public List<FlowerDTO> findAllFlowers() throws DAOException {
        try(Connection connection = ConnectionPool.getInstance().getConnection();
            Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(SQL_FIND_ALL_FLOWERS);
            return createFlowersList(resultSet);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    /* (non-Javadoc)
     * @see com.belykh.flowerAuction.dao.FlowerDAO#addFlower(com.belykh.flowerAuction.entity.dto.FlowerDTO)
     */
    @Override
    public boolean addFlower(FlowerDTO flowerDTO) throws DAOException {
        try(Connection connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_ADD_FLOWER)) {
            setStatement(statement, flowerDTO);
            return (statement.executeUpdate()!=0);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    private List<FlowerDTO> createFlowersList(ResultSet resultSet) throws SQLException {
        List<FlowerDTO> resultList = new ArrayList<>();
        while(resultSet.next()){
            resultList.add(createFlower(resultSet));
        }
        return resultList;
    }

    private FlowerDTO createFlower(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getLong(FLOWER_ID);
        String name = resultSet.getString(FLOWER_NAME);
        return new FlowerDTO(id,name);
    }
    private void setStatement(PreparedStatement ps, FlowerDTO flowerDTO) throws SQLException {
        ps.setString(1, flowerDTO.getName());
    }
}
