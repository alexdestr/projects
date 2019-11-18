package ru.vegd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.vegd.dao.CommentDAO;
import ru.vegd.entity.Comment;

import java.sql.SQLException;

@SpringBootApplication
public class Application {

    private final static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(Application.class.getName());

    public static void main(String[] args) throws SQLException {
        SpringApplication.run(Application.class, args);
    }

}

//        DBConnect dbConnect = context.getBean("dbConnect", DBConnect.class);


        /*try {
            dbConnect.connectToDataBase();
        } catch (SQLException e) {
            System.out.println("Connection failed!");
        } finally {
            dbConnect.connectToDataBase().close();
            context.close();
        }*/

/*        UserDAOimpl usersService = new UserDAOimpl(); // переделать под Spring

        //      создание User

        User users = new User();
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

        NewDAOimpl newsService = new NewDAOimpl();
        for (int i = 0; i < newsService.getAll().size(); i++) {
            System.out.println(newsService.getAll().get(i));
        }

        New news = new New();
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