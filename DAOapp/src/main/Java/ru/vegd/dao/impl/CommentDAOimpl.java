package ru.vegd.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.vegd.dao.CommentDAO;
import ru.vegd.entity.Comment;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CommentDAOimpl implements CommentDAO {

    private final static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(CommentDAOimpl.class.getName());
    @Autowired
    private DataSource dataSource;


    private static final String SQL_GETALL = "SELECT * FROM \"Comments\"";
    private static final String SQL_ADD = "INSERT INTO \"Comments\" (news_id, author_id, comment_text, creation_date) VALUES (?, ?, ?, ?)";
    private static final String SQL_READ = "SELECT * FROM \"Comments\" WHERE comments_id = ?";
    private static final String SQL_DELETE = "DELETE FROM \"Comments\" WHERE \"Comments\".\"comment_id\" = ?";
    private static final String SQL_UPDATE = "UPDATE \"Comments\" SET news_id = ?, author_id = ?, comment_text = ? WHERE comments_id = ?";

    @Override
    public List getAll() throws SQLException {

        List<Comment> commentList = new ArrayList<>();

        Connection connection = dataSource.getConnection();

        PreparedStatement preparedStatement = null;

        try  {
            preparedStatement = connection.prepareStatement(SQL_GETALL);


            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Comment comment = new Comment();

                comment.setComment_id(resultSet.getLong("comments_id"));
                comment.setNews_id(resultSet.getLong("news_id"));
                comment.setAuthor_id(resultSet.getLong("author_id"));
                comment.setComment_text(resultSet.getString("comment_text"));
                comment.setSending_date(resultSet.getTimestamp("creation_date"));

                commentList.add(comment);
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

        return commentList;
    }

    @Override
    public void add(Comment comment) throws SQLException {

        Connection connection = dataSource.getConnection();

        PreparedStatement preparedStatement = null;
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        try {
            preparedStatement = connection.prepareStatement(SQL_ADD);

            preparedStatement.setLong(1, comment.getNews_id());
            preparedStatement.setLong(2, comment.getAuthor_id());
            preparedStatement.setString(3, comment.getComment_text());
            preparedStatement.setTimestamp(4, timestamp);

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
    public Comment read(long ID) throws SQLException {

        Connection connection = dataSource.getConnection();

        PreparedStatement preparedStatement = null;


        Comment comment = new Comment();
        try {
            preparedStatement = connection.prepareStatement(SQL_READ);
            preparedStatement.setLong(1, ID);

            ResultSet resultSet = preparedStatement.executeQuery();

            comment.setComment_id(resultSet.getLong("comments_id"));
            comment.setNews_id(resultSet.getLong("news_id"));
            comment.setAuthor_id(resultSet.getLong("author_id"));
            comment.setComment_text(resultSet.getString("comment_text"));
            comment.setSending_date(resultSet.getTimestamp("creation_date"));

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
        return comment;
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
    public void update(Comment comment) throws SQLException {

        Connection connection = dataSource.getConnection();

        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(SQL_UPDATE);

            preparedStatement.setLong(1, comment.getNews_id());
            preparedStatement.setLong(2, comment.getAuthor_id());
            preparedStatement.setString(3, comment.getComment_text());
            preparedStatement.setLong(4, comment.getComment_id());

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
