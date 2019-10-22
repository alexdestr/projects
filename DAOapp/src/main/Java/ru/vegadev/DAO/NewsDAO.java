package ru.vegadev.DAO;

import ru.vegadev.Entity.News;
import ru.vegadev.Entity.Users;

import java.sql.SQLException;
import java.util.List;

public interface NewsDAO {

    public List getAll() throws SQLException;
    public void add(News news) throws SQLException;
    public News read(long ID) throws  SQLException;
    public void delete(long ID) throws SQLException;
    public void update(News news) throws SQLException;

}
