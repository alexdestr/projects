package ru.vegd.dao;

import ru.vegd.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {

    List getAll() throws SQLException;
    void add(User user) throws SQLException;
    User read(long ID) throws  SQLException;
    void delete(long ID) throws SQLException;
    void update(User user) throws SQLException;

}
