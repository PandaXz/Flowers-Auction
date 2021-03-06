package com.belykh.flowerAuction.dao.impl;

import com.belykh.flowerAuction.dao.UserDAO;
import com.belykh.flowerAuction.entity.dto.UserDTO;
import com.belykh.flowerAuction.exception.DAOException;
import com.belykh.flowerAuction.pool.ConnectionPool;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The Class UserDAOImpl.
 */
public class UserDAOImpl implements UserDAO {

    private static final String SQL_FIND_USER_BY_LOGIN = "SELECT `user`.`id`, `user`.`first_name`, `user`.email, `user`.`password_hash`,`user`.`login`,`user`.`last_name`,`user`.`balance`,`user`.`role`\n" +
            "FROM user WHERE `user`.`login`=?";
    private static final String SQL_FIND_USER_BY_ID = "SELECT `user`.`id`, `user`.`first_name`, `user`.email, `user`.`password_hash`,`user`.`login`,`user`.`last_name`,`user`.`balance`,`user`.`role`\n" +
            "FROM user WHERE `user`.`id`=?";
    private static final String SQL_FIND_ALL_USERS = "SELECT `user`.`id`, `user`.`first_name`, `user`.email, `user`.`password_hash`,`user`.`login`,`user`.`last_name`,`user`.`balance`,`user`.`role` FROM user ";

    private static final String SQL_FIND_USER_ID_BY_LOGIN = "SELECT `user`.`id` FROM user WHERE `user`.`login`=?";
    private static final String SQL_ADD_USER = "INSERT INTO `user` (`login`, `password_hash`, `email`, `first_name`, `last_name`, `role`, `balance`) VALUES (?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE_PASSWORD = "UPDATE `user` SET `user`.`password_hash` = ? WHERE `user`.`login`=?";
    private static final String SQL_UPDATE_MONEY = "UPDATE `user` SET `user`.`balance` = ? WHERE `user`.`id`=?";
    private static final String SQL_UPDATE_USER_INFO = "UPDATE `user` SET `user`.`email` = ?,`user`.`first_name` = ?,`user`.`last_name` = ? WHERE `user`.`login`=?";
    private static final String SQL_DEPOSIT_MONEY = "UPDATE `user` SET `balance` = (`balance` + ?) WHERE `id` = ?";
    private static final String SQL_WITHDRAW_USER_MONEY = "UPDATE `user` SET `balance` = (`user`.`balance` - ?) WHERE `id` = ? AND `balance` >= ?";

    private static final String USER_ID = "id";
    private static final String USER_FIRST_NAME = "first_name";
    private static final String USER_EMAIL = "email";
    private static final String USER_PASSWORD = "password_hash";
    private static final String USER_LOGIN = "login";
    private static final String USER_LAST_NAME = "last_name";
    private static final String USER_BALANCE = "balance";
    private static final String USER_ROLE = "role";


    /* (non-Javadoc)
     * @see com.belykh.flowerAuction.dao.UserDAO#findAllUsers()
     */
    @Override
    public List<UserDTO> findAllUsers() throws DAOException {

        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_FIND_ALL_USERS)) {

            ResultSet resultSet = statement.executeQuery();
            return createUserList(resultSet);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }


    /* (non-Javadoc)
     * @see com.belykh.flowerAuction.dao.UserDAO#findUserByLogin(java.lang.String)
     */
    @Override
    public UserDTO findUserByLogin(String login) throws DAOException {
        UserDTO result = null;
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_FIND_USER_BY_LOGIN)) {
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {

                result = createUser(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return result;
    }

    /* (non-Javadoc)
     * @see com.belykh.flowerAuction.dao.UserDAO#findUserById(java.lang.Long)
     */
    @Override
    public UserDTO findUserById(Long id) throws DAOException {
        UserDTO result = null;
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_FIND_USER_BY_ID)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {

                result = createUser(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return result;
    }

    /* (non-Javadoc)
     * @see com.belykh.flowerAuction.dao.UserDAO#addUser(com.belykh.flowerAuction.entity.dto.UserDTO)
     */
    @Override
    public boolean addUser(UserDTO userDTO) throws DAOException {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_ADD_USER)) {
            setStatement(statement, userDTO);
            return (statement.executeUpdate() != 0);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    /* (non-Javadoc)
     * @see com.belykh.flowerAuction.dao.UserDAO#isLoginFree(java.lang.String)
     */
    @Override
    public boolean isLoginFree(String login) throws DAOException {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_FIND_USER_ID_BY_LOGIN)) {
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();
            return !resultSet.next();

        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    /* (non-Javadoc)
     * @see com.belykh.flowerAuction.dao.UserDAO#changePassword(java.lang.String, java.lang.String)
     */
    @Override
    public boolean changePassword(String login, String newPass) throws DAOException {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_PASSWORD)) {
            statement.setString(1, newPass);
            statement.setString(2, login);

            return (statement.executeUpdate() != 0);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }


    /* (non-Javadoc)
     * @see com.belykh.flowerAuction.dao.UserDAO#changeMoney(java.lang.Long, java.math.BigDecimal)
     */
    @Override
    public boolean changeMoney(Long id, BigDecimal money) throws DAOException {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_MONEY)) {
            statement.setBigDecimal(1, money);
            statement.setLong(2, id);
            return (statement.executeUpdate() != 0);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    /* (non-Javadoc)
     * @see com.belykh.flowerAuction.dao.UserDAO#payment(java.lang.Long, java.lang.Long, java.math.BigDecimal)
     */
    @Override
    public boolean payment(Long ownerId, Long buyerId, BigDecimal price) throws DAOException {
        boolean result;

        try {
            Connection connection = ConnectionPool.getInstance().getConnection();
            connection.setAutoCommit(false);
            try(PreparedStatement stDeposit = connection.prepareStatement(SQL_DEPOSIT_MONEY);
                PreparedStatement stWithdraw = connection.prepareStatement(SQL_WITHDRAW_USER_MONEY)) {
                stWithdraw.setBigDecimal(1,price);
                stWithdraw.setLong(2,buyerId);
                stWithdraw.setBigDecimal(3,price);

                result= (stWithdraw.executeUpdate() != 0);
                if(result) {
                    stDeposit.setBigDecimal(1, price);
                    stDeposit.setLong(2, ownerId);

                    if(result=( stDeposit.executeUpdate() != 0)){
                        connection.commit();
                    } else {
                        connection.rollback();
                    }
                }

            }catch (SQLException e){
                throw new DAOException(e);
            }finally {
                if (connection != null) {
                    try {
                        connection.setAutoCommit(true);
                        connection.close();
                    } catch (SQLException ignored) {

                    }
                }
            }

        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return result;
    }

    /* (non-Javadoc)
     * @see com.belykh.flowerAuction.dao.UserDAO#changeUserInfo(com.belykh.flowerAuction.entity.dto.UserDTO)
     */
    @Override
    public boolean changeUserInfo(UserDTO user) throws DAOException {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_USER_INFO)) {
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getFirstName());
            statement.setString(3, user.getLastName());
            statement.setString(4, user.getLogin());
            return (statement.executeUpdate() != 0);

        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    private void setStatement(PreparedStatement ps, UserDTO userDTO) throws SQLException, DAOException {
        ps.setString(1, userDTO.getLogin());
        ps.setString(2, userDTO.getPass());
        ps.setString(3, userDTO.getEmail());
        ps.setString(4, userDTO.getFirstName());
        ps.setString(5, userDTO.getLastName());
        ps.setString(6, ROLE.valueByNumber(userDTO.getRole()).name());
        ps.setBigDecimal(7, userDTO.getBalance());
    }

    private List<UserDTO> createUserList(ResultSet resultSet) throws SQLException {
        List<UserDTO> resultList = new ArrayList<>();
        while (resultSet.next()) {
            resultList.add(createUser(resultSet));
        }
        return resultList;
    }

    private UserDTO createUser(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getLong(USER_ID);
        String firstName = resultSet.getString(USER_FIRST_NAME);
        String email = resultSet.getString(USER_EMAIL);
        String password = resultSet.getString(USER_PASSWORD);
        String login = resultSet.getString(USER_LOGIN);
        String lastName = resultSet.getString(USER_LAST_NAME);
        BigDecimal balance = resultSet.getBigDecimal(USER_BALANCE);
        int role = ROLE.valueOf(resultSet.getString(USER_ROLE)).ordinal();
        return new UserDTO(id, login, password, email, firstName, lastName, role, balance);
    }

    private enum ROLE {
        GUEST,USER, ADMIN;

        public static ROLE valueByNumber(int number) throws DAOException {
            switch (number) {
                case (1): {
                    return USER;
                }
                case (2): {
                    return ADMIN;
                }
                default: {
                    throw new DAOException("Wrong role number");
                }
            }

        }
    }
}
