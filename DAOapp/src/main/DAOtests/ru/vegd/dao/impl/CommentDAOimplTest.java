package ru.vegd.dao.impl;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.vegd.dao.CommentDAO;
import ru.vegd.entity.Comment;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/springTest.xml")
public class CommentDAOimplTest {

    @Autowired
    CommentDAO commentDAO;

    private final static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(CommentDAOimpl.class.getName());

    Comment comment = new Comment();
    private static String schema;
    private static PropertiesConfiguration config;

    static {
        try {
            config = new PropertiesConfiguration("C:\\Users\\Alex\\IdeaProjects\\DAOapp\\src\\main\\resources\\database.properties");
        } catch (ConfigurationException e) {
            logger.warn("config setting eror");
        }
    }

    @Before
    public void before() throws IOException {
        comment = new Comment();

        schema = "";
        config.setProperty("db.schema", "tests");
        try {
            config.save();
        } catch (ConfigurationException e) {
            logger.warn("Set property error");
        }
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
        System.out.println(commentDAO.getAll());
        Assert.assertEquals(comments.get(0), commentDAO.getAll().get(0));

    }

    @Test
    @Rollback(true)
    public void add() {
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

    @AfterAll
    public static void afterAll() {
        config.setProperty("db.schema", schema);
        try {
            config.save();
        } catch (ConfigurationException e) {
            logger.warn("Set property error");
        }
    }

}