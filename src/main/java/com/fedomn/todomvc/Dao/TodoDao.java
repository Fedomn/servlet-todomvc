package com.fedomn.todomvc.Dao;

import com.fedomn.todomvc.Model.Todo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TodoDao extends Dao{

    public void add(Todo todo) throws SQLException {
        String sql = "INSERT INTO todo (title, completed) VALUES(?, ?);";

        preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1, todo.getTitle());
        preparedStatement.setBoolean(2, todo.getCompleted());
        preparedStatement.execute();
        close();
    }

    public void update(Todo todo) throws SQLException {
        String sql = " UPDATE todo SET title=?, completed=? WHERE id = ?";

        preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1, todo.getTitle());
        preparedStatement.setBoolean(2, todo.getCompleted());
        preparedStatement.setInt(3, todo.getId());
        preparedStatement.execute();
        close();
    }

    public void deleteById(Todo todo) throws SQLException {
        String sql = "delete from todo where id = ?";
        preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1, todo.getId());
        preparedStatement.execute();
        preparedStatement.close();
        close();
    }

    public List<Todo> query() throws SQLException {
        List<Todo> todoList = new ArrayList<>();

        String sql = "select * from todo";
        preparedStatement = conn.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            todoList.add(new Todo(resultSet.getInt("id"), resultSet.getString("title"), resultSet.getBoolean("completed")));
        }
        resultSet.close();
        close();
        return todoList;
    }
}
