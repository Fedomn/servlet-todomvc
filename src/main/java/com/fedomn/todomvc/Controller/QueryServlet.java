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
        //prevent chinese garbled
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();
        List<Todo> todoList = null;

        String state = req.getParameter("state");
        switch (state) {
            case "active":
                try {
                    todoList = new TodoService().getActive();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "complete":

                break;
            default:
                try {
                    todoList = new TodoService().getAll();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }
        String jsonTodoList = JSON.toJSONString(todoList);
        System.out.println(jsonTodoList);
        out.print(jsonTodoList);
    }
}
