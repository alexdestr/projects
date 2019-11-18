package ru.vegd.dao.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import ru.vegd.dao.CommentDAO;
import ru.vegd.entity.Comment;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/springTest.xml")
public class CommentDAOimplTest {

    @Autowired
    CommentDAO commentDAO;

    private final static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(CommentDAOimpl.class.getName());

    Comment comment = new Comment();

    @Before
    public void before() {
        comment = new Comment();
    }

    @Test
    public void getAll() throws SQLException {
        List<Comment> comments = new ArrayList<>();
        comment.setComment_id(8L);
        comment.setNews_id(1L);
        comment.setAuthor_id(4L);
        comment.setComment_text("nice");
        comment.setSending_date(Timestamp.valueOf("2019-11-11 00:00:09.959"));
        comments.add(comment);
        /*Assert.assertEquals(comments.get(0), commentDAO.getAll().get(0));*/

    }

    @Test
    public void add() throws SQLException {

        comment.setNews_id(1L);
        comment.setAuthor_id(4L);
        comment.setComment_text("nice");
        commentDAO.add(comment);
        System.out.println(commentDAO.getAll());

    }

    @Test
    public void read() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void update() {
    }

}