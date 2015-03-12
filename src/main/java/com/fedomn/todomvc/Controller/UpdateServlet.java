package com.fedomn.todomvc.Controller;

import com.fedomn.todomvc.Model.Todo;
import com.fedomn.todomvc.Service.TodoService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class UpdateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        String title = req.getParameter("title");
        Boolean state = Boolean.valueOf(req.getParameter("complete"));

        System.out.println("Update get id :" + id + " title : " + title + "complete: " + state);
        try {
            new TodoService().update(new Todo(id, title, state));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
