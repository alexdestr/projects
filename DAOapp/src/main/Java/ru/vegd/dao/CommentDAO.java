package ru.vegd.dao;

import ru.vegd.entity.Comment;

import java.sql.SQLException;
import java.util.List;

public interface CommentDAO {

    List getAll() throws SQLException;
    void add(Comment comment) throws SQLException;
    Comment read(long ID) throws  SQLException;
    void delete(long ID) throws SQLException;
    void update(Comment comment) throws SQLException;

}
