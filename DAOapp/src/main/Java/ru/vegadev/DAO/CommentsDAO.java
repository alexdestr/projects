package ru.vegadev.DAO;

import ru.vegadev.Entity.Comments;
import ru.vegadev.Entity.News;

import java.sql.SQLException;
import java.util.List;

public interface CommentsDAO {

    public List getAll() throws SQLException;
    public void add(Comments comments) throws SQLException;
    public Comments read(long ID) throws  SQLException;
    public void delete(long ID) throws SQLException;
    public void update(Comments comments) throws SQLException;

}
