package ru.vegadev.Service;

import ru.vegadev.DAO.DAO;
import ru.vegadev.DBConnect.DBConnect;
import ru.vegadev.Entity.Users;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
                users.setDate_of_registration(resultSet.getString("date_of_registration"));

                usersList.add(users);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usersList;
    }

    @Override
    public void add(Object o) throws SQLException {

    }

    @Override
    public void read(long ID) throws SQLException {

    }

    @Override
    public void delete(long ID) throws SQLException {

    }
}
