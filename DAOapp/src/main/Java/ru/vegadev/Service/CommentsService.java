package ru.vegadev.Service;

import ru.vegadev.DAO.CommentsDAO;
import ru.vegadev.DBConnect.DBConnect;
import ru.vegadev.Entity.Comments;

import java.sql.Connection;
import java.sql.SQLException;
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


        return commentsList;
    }

    @Override
    public void add(Comments comments) throws SQLException {

    }

    @Override
    public Comments read(long ID) throws SQLException {
        return null;
    }

    @Override
    public void delete(long ID) throws SQLException {

    }

    @Override
    public void update(Comments comments) throws SQLException {

    }
}
