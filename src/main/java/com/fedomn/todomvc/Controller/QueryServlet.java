package com.fedomn.todomvc.Controller;

import com.alibaba.fastjson.JSON;
import com.fedomn.todomvc.Model.Todo;
import com.fedomn.todomvc.Service.TodoService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

public class QueryServlet extends HttpServlet{


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String jsonData = "";
        //prevent chinese garbled
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();

        String state = req.getParameter("state");
        String argument = req.getParameter("argument");
        System.out.println(state+" "+argument);

        if (argument.equals("list")) {
            try {
                jsonData = JSON.toJSONString(getList(state));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (argument.equals("count")) {
            try {
                jsonData = JSON.toJSONString(getCount(state));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println(jsonData);
        out.print(jsonData);
    }


    private Integer getCount(String state) throws SQLException {
        switch (state) {
            case "active":
                return new TodoService().getActiveCount();
            case "completed":
                return new TodoService().getCompletedCount();
            default:
                return new TodoService().getAllCount();
        }
    }


    private List<Todo> getList(String state) throws SQLException {
        switch (state) {
            case "active":
                return new TodoService().getActive();
            case "completed":
                return new TodoService().getCompleted();
            default:
                return new TodoService().getAll();
        }
    }
}
