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
        Boolean state = Boolean.valueOf(req.getParameter("state"));
        String argument = req.getParameter("argument");

        if (argument != null && argument.equals("all")) {
            updateAllState(state);
        } else {
            update(new Todo(id, title, state));
        }
    }

    private void update(Todo todo) {
        System.out.println("Update id :" + todo.getId() + " title : " + todo.getId() + " completed: " + todo.getCompleted());
        try {
            new TodoService().update(todo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void updateAllState(Boolean state) {
        System.out.println("Update list completed: " + state);
        try {
            new TodoService().updateAllState(state);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
