package ru.vegadev.Main;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.vegadev.DBConnect.DBConnect;
import ru.vegadev.Entity.Users;
import ru.vegadev.Service.UsersService;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );

        DBConnect dbConnect = context.getBean("dbConnect", DBConnect.class);

        try {
            dbConnect.connectToDataBase();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connection failed!");
        }

        UsersService usersService = new UsersService(); // переделать под Spring

        for (int i = 0; i < usersService.getAll().size(); i++) {
            System.out.println(usersService.getAll().get(i));
        }



        dbConnect.connectToDataBase().close();

    }
}
