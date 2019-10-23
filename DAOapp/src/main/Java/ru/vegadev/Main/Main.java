package ru.vegadev.Main;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.vegadev.DBConnect.DBConnect;
import ru.vegadev.Entity.News;
import ru.vegadev.Entity.Users;
import ru.vegadev.Service.NewsService;
import ru.vegadev.Service.UsersService;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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

/*        UsersService usersService = new UsersService(); // переделать под Spring

        //      создание Users

        Users users = new Users();
        users.setLogin("NotUser");
        users.setHash_password("Not_hash_password");
        users.setUser_name("NotJohn");
        users.setUser_last_name("NotAlfred");
        long milis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(milis);
        users.setDate_of_registration(date);
//
//     usersService.add(users); // добавить пользователя в БД
//        usersService.delete(7); // удалить пользователя из БД
//        usersService.update(5, users);

        for (int i = 0; i < usersService.getAll().size(); i++) {
            System.out.println(usersService.getAll().get(i));
        }

        System.out.println("\n");

        NewsService newsService = new NewsService();
        for (int i = 0; i < newsService.getAll().size(); i++) {
            System.out.println(newsService.getAll().get(i));
        }

        News news = new News();
        news.setNews_id(21L);
        news.setAuthor_id(3L);
        news.setTittle("?");
        news.setNews_text("noonono");
        long milis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(milis);
        news.setPublic_date(date);
//        newsService.add(news);
//        newsService.delete(4L);
//       newsService.update(news);
*/


        dbConnect.connectToDataBase().close();

    }

}
