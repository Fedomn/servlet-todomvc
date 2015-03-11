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
        Integer id = Integer.parseInt(req.getParameter("id"));
        try {
            new TodoService().deleteById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        out.print("delete success");
    }
}
