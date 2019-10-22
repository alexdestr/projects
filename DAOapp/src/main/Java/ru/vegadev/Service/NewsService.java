package ru.vegadev.Service;

import ru.vegadev.DAO.NewsDAO;
import ru.vegadev.DAO.UsersDAO;
import ru.vegadev.DBConnect.DBConnect;
import ru.vegadev.Entity.News;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NewsService extends DBConnect implements NewsDAO {

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

        List<News> newsList = new ArrayList<>();

        String sql = "SELECT * FROM \"News\" ";
        Statement statement = null;

        try {
            statement = connection.createStatement();


            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                News news = new News();

                news.setNews_id(resultSet.getLong("news_id"));
                news.setAuthor_id(resultSet.getLong("author_id"));
                news.setTittle(resultSet.getString("tittle"));
                news.setNews_text(resultSet.getString("news_text"));
                news.setPublic_date(resultSet.getDate("public_date"));

                newsList.add(news);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return newsList;
    }

    @Override
    public void add(News news) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "INSERT INTO \"News\" (author_id, tittle, news_text, public_date) VALUES ( ?, ?, ?, ?)";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, news.getAuthor_id());
            preparedStatement.setString(2, news.getTittle());
            preparedStatement.setString(3, news.getNews_text());
            preparedStatement.setDate(4, news.getPublic_date());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public News read(long ID) throws SQLException {

        PreparedStatement preparedStatement = null;

        String sql = "SELECT * FROM \"News\" WHERE news_id = ?";
        News news = new News();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, ID);

            ResultSet resultSet = preparedStatement.executeQuery();

            news.setNews_id(resultSet.getLong("news_id"));
            news.setAuthor_id(resultSet.getLong("author_id"));
            news.setTittle(resultSet.getString("tittle"));
            news.setNews_text(resultSet.getString("news_text"));
            news.setPublic_date(resultSet.getDate("public_date"));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return news;
    }

    @Override
    public void delete(long ID) throws SQLException {

        PreparedStatement preparedStatement = null;

        String sql;

        try {

            sql = "DELETE FROM \"News\" WHERE \"News\".\"news_id\" = ?";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, ID);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(News news) throws SQLException {

        PreparedStatement preparedStatement = null;

        String sql = "UPDATE \"News\" SET author_id = ?, tittle = ?, news_text = ?, public_date = ? WHERE news_id = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, news.getAuthor_id());
            preparedStatement.setString(2, news.getTittle());
            preparedStatement.setString(3, news.getNews_text());
            preparedStatement.setDate(4, news.getPublic_date());
            preparedStatement.setLong(5, news.getNews_id());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
