package ru.vegadev.Service;

import ru.vegadev.DAO.DAO;
import ru.vegadev.DBConnect.DBConnect;
import ru.vegadev.Entity.Users;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsersService extends DBConnect implements DAO {

    private Connection connection;

    // Connect //
    {
        try {
            connection = connectToDataBase();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List getAll() throws SQLException {

        List<Users> usersList = new ArrayList<>();

        String sql = "SELECT * FROM \"Users\" ";
        Statement statement = null;

        try {
         statement = connection.createStatement();


            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Users users = new Users();

                users.setUser_id(resultSet.getLong("user_id"));
                users.setLogin(resultSet.getString("login"));
                users.setHash_password(resultSet.getString("hash_password"));
                users.setUser_name(resultSet.getString("user_name"));
                users.setUser_last_name(resultSet.getString("user_last_name"));
                users.setDate_of_registration(resultSet.getDate("date_of_registration"));

                usersList.add(users);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usersList;
    }

    @Override
    public void add(Users users) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "INSERT INTO \"Users\" (user_id, login, hash_password, user_name, user_last_name, date_of_registration) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1,users.getUser_id());
            preparedStatement.setString(2,users.getLogin());
            preparedStatement.setString(3,users.getUser_name());
            preparedStatement.setString(4,users.getUser_last_name());
            preparedStatement.setDate(5,users.getDate_of_registration());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void read(long ID) throws SQLException {

    }

    @Override
    public void delete(long ID) throws SQLException {

    }

    @Override
    public void update(String s) throws SQLException {

    }
}
