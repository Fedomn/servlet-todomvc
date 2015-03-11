package com.fedomn.todomvc.Controller;

import com.fedomn.todomvc.Model.Todo;
import com.fedomn.todomvc.Service.TodoService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IndexServlet extends HttpServlet {

    private List<Todo> goddessList = new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            goddessList = new TodoService().query();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("goddessList", goddessList);
        req.getRequestDispatcher("WEB-INF/pages/userList.jsp").forward(req, resp);
    }
}
