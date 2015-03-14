package com.fedomn.todomvc.Controller;

import com.fedomn.todomvc.Service.TodoService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class DeleteServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        String argument = req.getParameter("argument");
        Integer id = Integer.parseInt(req.getParameter("id"));

        if (argument != null && argument.equals("all-completed")) {
            deleteAllCompleted();
        } else {
            delete(id);
        }
        out.print("delete success");
    }


    private void delete(Integer id) {
        try {
            new TodoService().deleteById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("delete todo id: " + id);
    }

    private void deleteAllCompleted() {
        try {
            new TodoService().deleteAllCompleted();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("delete all completed");
    }
}
