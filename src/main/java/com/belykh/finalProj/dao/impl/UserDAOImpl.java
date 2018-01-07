package com.belykh.finalProj.dao.impl;

import com.belykh.finalProj.dao.UserDAO;
import com.belykh.finalProj.entity.User;
import com.belykh.finalProj.exception.DAOException;
import com.belykh.finalProj.pool.ConnectionPool;
import com.belykh.finalProj.pool.exception.ConnectionPoolException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by panda on 6.1.18.
 */
public class UserDAOImpl implements UserDAO {

    private static final String SQL_GET_USER_BY_LOGIN = "SELECT `user`.`id`, `user`.`first_name`, `user`.email, `user`.`password_hash`,`user`.`login`,`user`.`last_name`,`user`.`money`,`user`.`role`\n" +
            "FROM user WHERE `user`.`login`=?";
    private static final String SQL_GET_USER_BY_ID = "SELECT `user`.`id`, `user`.`first_name`, `user`.email, `user`.`password_hash`,`user`.`login`,`user`.`last_name`,`user`.`money`,`user`.`role`\n" +
            "FROM user WHERE `user`.`id`=?";
    private static final String SQL_GET_MONEY_BY_LOGIN = "SELECT `user`.`money` FROM user WHERE `user`.`login`=?";
    private static final String SQL_DELETE_USER = "DELETE FROM `user` WHERE `user`.`login`=?";

    private static final String SQL_GET_USER_ID_BY_LOGIN = "SELECT `user`.`id` FROM user WHERE `user`.`login`=?";
    private static final String SQL_ADD_USER = "INSERT INTO `user` (`login`, `password_hash`, `email`, `first_name`, `last_name`, `role`, `money`) VALUES (?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE_PASSWORD = "UPDATE `user` SET `user`.`password_hash` = ? WHERE `user`.`login`=?";
    private static final String SQL_UPDATE_MONEY = "UPDATE `user` SET `user`.`money` = ? WHERE `user`.`login`=?";

    private static final String USER_ID = "id";
    private static final String USER_FIRST_NAME = "first_name";
    private static final String USER_EMAIL = "email";
    private static final String USER_PASSWORD = "password_hash";
    private static final String USER_LOGIN = "login";
    private static final String USER_LAST_NAME = "last_name";
    private static final String USER_MONEY = "money";
    private static final String USER_ROLE = "role";

    
    @Override public List<User> findAllUsers() throws DAOException {

        try(Connection connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_GET_USER_BY_LOGIN)) {

            ResultSet resultSet = statement.executeQuery();
            return createUserList(resultSet);
        } catch (SQLException|ConnectionPoolException e) {
            throw new DAOException(e);
        }
    }

    
    @Override public User findUserByLogin(String login) throws DAOException {
        User result =null;
        try(Connection connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_GET_USER_BY_LOGIN)) {
            statement.setString(1,login);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){

                result = createUser(resultSet);
            }
        } catch (SQLException|ConnectionPoolException e) {
            throw new DAOException(e);  
        }
        return result;
    }
    @Override public User findUserById(Long id) throws DAOException {
        User result =null;
        try(Connection connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_GET_USER_BY_ID)) {
            statement.setLong(1,id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){

                result = createUser(resultSet);
            }
        } catch (SQLException|ConnectionPoolException e) {
            throw new DAOException(e);
        }
        return result;
    }

    @Override public boolean addUser(User user) throws DAOException {
        try(Connection connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_ADD_USER)) {
            setStatement(statement,user);
            return (statement.executeUpdate()!=0);
        } catch (SQLException|ConnectionPoolException e) {
            throw new DAOException(e);
        }
    }

    @Override public boolean isLoginFree(String login) throws DAOException {
        try(Connection connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_GET_USER_ID_BY_LOGIN)) {
            statement.setString(1,login);
            ResultSet resultSet = statement.executeQuery();
            return !resultSet.next();

        } catch (SQLException|ConnectionPoolException e) {
            throw new DAOException(e);
        }
    }

    @Override public boolean updatePassword(String login, String newPass) throws DAOException {
        try(Connection connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_PASSWORD)) {
            statement.setString(1,newPass);
            statement.setString(2,login);
            ResultSet resultSet = statement.executeQuery();
            return !resultSet.next();

        } catch (SQLException|ConnectionPoolException e) {
            throw new DAOException(e);
        }
    }

    @Override public boolean deleteUser(String login) throws DAOException{
        try(Connection connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_DELETE_USER)) {
            statement.setString(1,login);
            return (statement.executeUpdate()!=0);
        } catch (SQLException|ConnectionPoolException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public long findUserMoney(String login) throws DAOException {
        try(Connection connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_GET_MONEY_BY_LOGIN)) {
            statement.setString(1,login);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){

                return resultSet.getLong(USER_MONEY);
            }
        } catch (SQLException|ConnectionPoolException e) {
            throw new DAOException(e);
        }
        return 0;
    }

    @Override
    public boolean changeMoney(long money,String login) throws DAOException {
        try(Connection connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_MONEY)) {
            statement.setLong(1,money);
            statement.setString(2,login);
            ResultSet resultSet = statement.executeQuery();
            return !resultSet.next();

        } catch (SQLException|ConnectionPoolException e) {
            throw new DAOException(e);
        }
    }

    private void setStatement(PreparedStatement ps,User user) throws SQLException, DAOException {
        ps.setString(1,user.getLogin());
        ps.setString(2,user.getPass());
        ps.setString(3,user.getEmail());
        ps.setString(4,user.getFirstName());
        ps.setString(5,user.getLastName());
        ps.setString(6,ROLE.valueByNumber(user.getRole()).name());
        ps.setLong(7,user.getMoney());
    }

    private List<User> createUserList(ResultSet resultSet) throws SQLException {
        List<User> resultList = new ArrayList<>();
        while(resultSet.next()){
            resultList.add(createUser(resultSet));
        }
        return resultList;
    }
    private User createUser(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getLong(USER_ID);
        String firstName = resultSet.getString(USER_FIRST_NAME);
        String email = resultSet.getString(USER_EMAIL);
        String password = resultSet.getString(USER_PASSWORD);
        String login = resultSet.getString(USER_LOGIN);
        String lastName = resultSet.getString(USER_LAST_NAME);
        Long money = resultSet.getLong(USER_MONEY);
        int role = ROLE.valueOf(resultSet.getString(USER_ROLE)).ordinal();
        return new User(id,login,password,email,firstName,lastName,role,money);
    }

    private enum ROLE{
        USER,ADMIN;

        public static ROLE valueByNumber(int number) throws DAOException {
            switch (number){
                case (0):{
                    return USER;
                }
                case (1):{
                    return ADMIN;
                }
                default:{
                    throw new DAOException("Wrong role number");
                }
            }

        }
    }
}
