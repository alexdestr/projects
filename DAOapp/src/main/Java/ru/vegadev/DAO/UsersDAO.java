package ru.vegadev.DAO;

import ru.vegadev.Entity.Users;

import java.sql.SQLException;
import java.util.List;

public interface UsersDAO {

    public List getAll() throws SQLException;
    public void add(Users users) throws SQLException;
    public Users read(long ID) throws  SQLException;
    public void delete(long ID) throws SQLException;
    public void update(Users users) throws SQLException;

}
