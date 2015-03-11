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

public class AddServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter out = resp.getWriter();
        String title = req.getParameter("title");
        Todo todoBefore = new Todo(title, false);
        Todo todo = null;

        try {
            todo = new TodoService().add(todoBefore);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String jsonTodo = JSON.toJSONString(todo);
        System.out.println("Add todo : " + jsonTodo);
        out.print(jsonTodo);
    }
}
