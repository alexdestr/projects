package ru.vegadev.Service;

import ru.vegadev.DAO.CommentsDAO;
import ru.vegadev.DBConnect.DBConnect;
import ru.vegadev.Entity.Comments;
import ru.vegadev.Entity.News;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommentsService extends DBConnect implements CommentsDAO {

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

        List<Comments> commentsList = new ArrayList<>();

        String sql = "SELECT * FROM \"News\"";
        Statement statement = null;

        try {
            statement = connection.createStatement();


            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Comments comments = new Comments();

                comments.setComment_id(resultSet.getLong("comment_id"));
                comments.setNews_id(resultSet.getLong("news_id"));
                comments.setAuthor_id(resultSet.getLong("author_id"));
                comments.setComment_text(resultSet.getString("comment_text"));
                comments.setSending_date(resultSet.getDate("sending_date"));

                commentsList.add(comments);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return commentsList;
    }

    @Override
    public void add(Comments comments) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "INSERT INTO \"Comments\" (comment_id, news_id, author_id, comment_text, sending_date) VALUES ( ?, ?, ?, ?, ?)";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, comments.getComment_id());
            preparedStatement.setLong(2, comments.getNews_id());
            preparedStatement.setLong(3, comments.getAuthor_id());
            preparedStatement.setString(4, comments.getComment_text());
            preparedStatement.setDate(5, comments.getSending_date());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Comments read(long ID) throws SQLException {

        PreparedStatement preparedStatement = null;

        String sql = "SELECT * FROM \"Comments\" WHERE comment_id = ?";
        Comments comments = new Comments();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, ID);

            ResultSet resultSet = preparedStatement.executeQuery();

            comments.setComment_id(resultSet.getLong("comment_id"));
            comments.setNews_id(resultSet.getLong("news_id"));
            comments.setAuthor_id(resultSet.getLong("author_id"));
            comments.setComment_text(resultSet.getString("comment_text"));
            comments.setSending_date(resultSet.getDate("sending_date"));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comments;
    }

    @Override
    public void delete(long ID) throws SQLException {

        PreparedStatement preparedStatement = null;

        String sql;

        try {

            sql = "DELETE FROM \"Comments\" WHERE \"Comments\".\"comment_id\" = ?";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, ID);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Comments comments) throws SQLException {

        PreparedStatement preparedStatement = null;

        String sql = "UPDATE \"Comments\" SET news_id = ?, author_id = ?, comment_text = ?, sending_date = ? WHERE comment_id = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, comments.getNews_id());
            preparedStatement.setLong(2, comments.getAuthor_id());
            preparedStatement.setString(3, comments.getComment_text());
            preparedStatement.setDate(4, comments.getSending_date());
            preparedStatement.setLong(5, comments.getComment_id());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
