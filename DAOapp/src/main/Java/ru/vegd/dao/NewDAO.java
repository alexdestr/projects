package ru.vegd.dao;

import ru.vegd.entity.New;

import java.sql.SQLException;
import java.util.List;

public interface NewDAO {

    List getAll() throws SQLException;
    void add(New aNew) throws SQLException;
    New read(long ID) throws  SQLException;
    void delete(long ID) throws SQLException;
    void update(New aNew) throws SQLException;

}
