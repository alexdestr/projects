package ru.vegadev.DBConnect;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component("dbConnect")
public class DBConnect {

    private final String HOST = "jdbc:postgresql://127.0.0.1/postgres";
    private final String USERNAME = "postgres";
    private final String PASSWORD = "1234";

    public Connection connectToDataBase() throws SQLException {
        DriverManager.setLoginTimeout(4);

        final Connection connection = DriverManager.getConnection(HOST,USERNAME, PASSWORD);

        return connection;

    }

}
