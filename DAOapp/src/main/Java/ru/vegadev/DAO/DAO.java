package ru.vegadev.DAO;

import ru.vegadev.Entity.Users;

import java.sql.SQLException;
import java.util.List;

public interface DAO {

    public List getAll() throws SQLException;
    public void add(Users users) throws SQLException;
    public Users read(long ID) throws  SQLException;
    public void delete(long ID) throws SQLException;
    public void update(long ID, Users users) throws SQLException;

}
