package ru.vegd.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.vegd.dao.NewDAO;
import ru.vegd.entity.New;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class NewDAOimpl implements NewDAO {

    private final static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(NewDAOimpl.class.getName());

    @Autowired
    DataSource dataSource;


    private static final String SQL_GETALL = "SELECT * FROM \"News\"";
    private static final String SQL_ADD = "INSERT INTO \"News\" (author_id, tittle, news_text, creation_date) VALUES ( ?, ?, ?, ?)";
    private static final String SQL_READ = "SELECT * FROM \"News\" WHERE news_id = ?";
    private static final String SQL_DELETE = "DELETE FROM \"News\" WHERE \"News\".\"news_id\" = ?";
    private static final String SQL_UPDATE = "UPDATE \"News\" SET author_id = ?, tittle = ?, news_text = ? WHERE news_id = ?";

    @Override
    public List getAll() throws SQLException {

        List<New> newList = new ArrayList<>();

        Connection connection = dataSource.getConnection();

        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(SQL_GETALL);


            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                New aNew = new New();

                aNew.setNews_id(resultSet.getLong("news_id"));
                aNew.setAuthor_id(resultSet.getLong("author_id"));
                aNew.setTittle(resultSet.getString("tittle"));
                aNew.setNews_text(resultSet.getString("news_text"));
                aNew.setPublic_date(resultSet.getTimestamp("public_date"));

                newList.add(aNew);
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

        return newList;
    }

    @Override
    public void add(New aNew) throws SQLException {

        Connection connection = dataSource.getConnection();

        PreparedStatement preparedStatement = null;
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        try {
            preparedStatement = connection.prepareStatement(SQL_ADD);

            preparedStatement.setLong(1, aNew.getAuthor_id());
            preparedStatement.setString(2, aNew.getTittle());
            preparedStatement.setString(3, aNew.getNews_text());
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
    public New read(long ID) throws SQLException {

        Connection connection = dataSource.getConnection();

        PreparedStatement preparedStatement = null;

        New aNew = new New();

        try {
            preparedStatement = connection.prepareStatement(SQL_READ);
            preparedStatement.setLong(1, ID);

            ResultSet resultSet = preparedStatement.executeQuery();

            aNew.setNews_id(resultSet.getLong("news_id"));
            aNew.setAuthor_id(resultSet.getLong("author_id"));
            aNew.setTittle(resultSet.getString("tittle"));
            aNew.setNews_text(resultSet.getString("news_text"));
            aNew.setPublic_date(resultSet.getTimestamp("public_date"));

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
        return aNew;
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
    public void update(New aNew) throws SQLException {

        Connection connection = dataSource.getConnection();

        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(SQL_UPDATE);

            preparedStatement.setLong(1, aNew.getAuthor_id());
            preparedStatement.setString(2, aNew.getTittle());
            preparedStatement.setString(3, aNew.getNews_text());
            preparedStatement.setLong(4, aNew.getNews_id());

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
