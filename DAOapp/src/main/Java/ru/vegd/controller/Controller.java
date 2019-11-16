package ru.vegd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.vegd.dao.CommentDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

@org.springframework.stereotype.Controller
public class Controller {
    @Autowired
    CommentDAO commentDAO;

    @RequestMapping(value = "/h", method = RequestMethod.GET)
    public void showRegister(HttpServletRequest request, HttpServletResponse response) {
        try {
            System.out.println(commentDAO.getAll());
        } catch (SQLException e) {
            System.out.println("Osujdayu");
        }
    }
}
