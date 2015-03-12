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
        if (state.equals("active")) {
            try {
                todoList = new TodoService().getActiveTodoList();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else if (state.equals("complete")) {

        }else {
            try {
                todoList = new TodoService().getAllTodoList();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        String jsonTodoList = JSON.toJSONString(todoList);
        System.out.println(jsonTodoList);
        out.print(jsonTodoList);
    }
}
