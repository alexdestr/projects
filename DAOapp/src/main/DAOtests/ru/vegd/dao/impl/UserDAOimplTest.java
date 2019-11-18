package ru.vegd.dao.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.vegd.dao.UserDAO;
import ru.vegd.entity.User;

import java.sql.SQLException;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/springTest.xml")
public class UserDAOimplTest {

    @Autowired
    UserDAO userDAO;

    User user;

    @Before
    public void before() {
        user = new User();
    }

    @Test
    public void getAll() {

    }

    @Test
    public void add() throws SQLException {
        user.setUser_id(1L);
        user.setLogin("VincentVega");
        user.setHash_password("hashpass");
        user.setUser_name("Alex");
        user.setUser_last_name("Vega");
        userDAO.add(user);
        Assert.assertEquals(user.getLogin(), userDAO.read(1).getLogin());
        Assert.assertEquals(user.getHash_password(), userDAO.read(1).getHash_password());
        Assert.assertEquals(user.getUser_name(), userDAO.read(1).getUser_name());
        Assert.assertEquals(user.getUser_last_name(), userDAO.read(1).getUser_last_name());

        userDAO.delete(1);
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