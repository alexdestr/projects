package ru.vegadev.DAO;

import ru.vegadev.Entity.Comments;
import ru.vegadev.Entity.Tags;

import java.sql.SQLException;
import java.util.List;

public interface TagsDAO {

    public List getAll() throws SQLException;
    public void add(Tags tags) throws SQLException;
    public Tags read(long ID) throws  SQLException;
    public void delete(long ID) throws SQLException;
    public void update(Tags tags) throws SQLException;

}
