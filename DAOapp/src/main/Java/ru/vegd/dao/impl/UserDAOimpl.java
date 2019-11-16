package ru.vegd.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.vegd.dao.UserDAO;
import ru.vegd.entity.User;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDAOimpl implements UserDAO {

    private final static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(UserDAOimpl.class.getName());

    @Autowired
    DataSource dataSource;

    private static final String SQL_GETALL = "SELECT * FROM \"Users\"";
    private static final String SQL_ADD = "INSERT INTO \"Users\" (login, hash_password, user_name, user_last_name, registration_date) VALUES (?, ?, ?, ?, ? )";
    private static final String SQL_READ = "SELECT * FROM \"Users\" WHERE user_id = ?";
    private static final String SQL_DELETE = "SELECT * FROM \"Users\" WHERE user_id = ?";
    private static final String SQL_UPDATE = "UPDATE \"Users\" SET login = ?, hash_password = ?, user_name = ?, user_last_name = ? WHERE user_id = ?";

    @Override
    public List getAll() throws SQLException {

        Connection connection = dataSource.getConnection();

        List<User> userList = new ArrayList<>();

        PreparedStatement preparedStatement = null;

        try {
          preparedStatement = connection.prepareStatement(SQL_GETALL);


            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                User user = new User();

                user.setUser_id(resultSet.getLong("user_id"));
                user.setLogin(resultSet.getString("login"));
                user.setHash_password(resultSet.getString("hash_password"));
                user.setUser_name(resultSet.getString("user_name"));
                user.setUser_last_name(resultSet.getString("user_last_name"));
                user.setDate_of_registration(resultSet.getTimestamp("registration_date"));

                userList.add(user);
            }

        } catch (SQLException e) {
            logger.warn("Request eror");
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (!connection.isClosed()) {
                connection.close();
            }
        }

        return userList;
    }

    @Override
    public void add(User user) throws SQLException {

        Connection connection = dataSource.getConnection();

        PreparedStatement preparedStatement = null;
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        try {
            preparedStatement = connection.prepareStatement(SQL_ADD);

            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getHash_password());
            preparedStatement.setString(3, user.getUser_name());
            preparedStatement.setString(4, user.getUser_last_name());
            preparedStatement.setTimestamp(5, timestamp);

            preparedStatement.executeUpdate();
            logger.info("Success adding");
        } catch (SQLException e) {
            logger.warn("Request eror");
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (!connection.isClosed()) {
                connection.close();
            }
        }
    }

    @Override
    public User read(long ID) throws SQLException {

        Connection connection = dataSource.getConnection();

        PreparedStatement preparedStatement = null;

        User user = new User();
        try {
            preparedStatement = connection.prepareStatement(SQL_READ);
            preparedStatement.setLong(1, ID);

            ResultSet resultSet = preparedStatement.executeQuery();

            user.setUser_id(resultSet.getLong("user_id"));
            user.setLogin(resultSet.getString("login"));
            user.setHash_password(resultSet.getString("hash_password"));
            user.setUser_name(resultSet.getString("user_name"));
            user.setUser_last_name(resultSet.getString("user_last_name"));
            user.setDate_of_registration(resultSet.getTimestamp("date_of_registration"));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.warn("Request eror");
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (!connection.isClosed()) {
                connection.close();
            }
        }
        return user;
    }

    @Override
    public void delete(long ID) throws SQLException {

        Connection connection = dataSource.getConnection();

        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(SQL_DELETE);

            preparedStatement.setLong(1, ID);

            preparedStatement.executeUpdate();
            logger.info("Success delete");
        } catch (SQLException e) {
            logger.warn("Request eror");
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (!connection.isClosed()) {
                connection.close();
            }
        }

    }

    @Override
    public void update(User user) throws SQLException {

        Connection connection = dataSource.getConnection();

        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(SQL_UPDATE);

            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getHash_password());
            preparedStatement.setString(3, user.getUser_name());
            preparedStatement.setString(4, user.getUser_last_name());
            preparedStatement.setLong(5, user.getUser_id());

            preparedStatement.executeUpdate();
            logger.info("Success update");
        } catch (SQLException e) {
            logger.warn("Request eror");
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (!connection.isClosed()) {
                connection.close();
            }
        }


    }
}
