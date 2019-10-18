package ru.vegadev.DAO;

import java.sql.SQLException;
import java.util.List;

public interface DAO {

    public List getAll() throws SQLException;
    public void add(Object o) throws SQLException;
    public void read(long ID) throws  SQLException;
    public void delete(long ID) throws SQLException;

}
