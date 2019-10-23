package ru.vegadev.Service;

import ru.vegadev.DAO.TagsDAO;
import ru.vegadev.DBConnect.DBConnect;
import ru.vegadev.Entity.Comments;
import ru.vegadev.Entity.Tags;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TagsService extends DBConnect implements TagsDAO{

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

        List<Tags> tagsList = new ArrayList<>();

        String sql = "SELECT * FROM \"Tags\"";
        Statement statement = null;

        try {
            statement = connection.createStatement();


            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Tags tags = new Tags();

                tags.setNews_ID(resultSet.getLong("news_ID"));
                tags.setTags(resultSet.getString("tags"));

                tagsList.add(tags);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tagsList;
    }

    @Override
    public void add(Tags tags) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "INSERT INTO \"Tags\" (news_id, tags) VALUES ( ?, ?)";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, tags.getNews_ID());
            preparedStatement.setString(2, tags.getTags());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Tags read(long ID) throws SQLException {

        PreparedStatement preparedStatement = null;

        String sql = "SELECT * FROM \"Tags\" WHERE news_id = ?";
        Tags tags = new Tags();

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, ID);

            ResultSet resultSet = preparedStatement.executeQuery();

            tags.setNews_ID(resultSet.getLong("news_id"));
            tags.setTags(resultSet.getString("tags"));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tags;
    }

    @Override
    public void delete(long ID) throws SQLException {

        PreparedStatement preparedStatement = null;

        String sql;

        try {

            sql = "DELETE FROM \"Tags\" WHERE \"Tags\".\"news_id\" = ?";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, ID);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Tags tags) throws SQLException {

        PreparedStatement preparedStatement = null;

        String sql = "UPDATE \"Tags\" SET tags = ? WHERE news_id = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, tags.getTags());
            preparedStatement.setLong(2, tags.getNews_ID());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
