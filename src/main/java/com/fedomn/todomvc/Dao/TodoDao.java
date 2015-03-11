package com.fedomn.todomvc.Dao;

import com.fedomn.todomvc.Model.Todo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TodoDao extends Dao{

    /**
     * return added todo contains auto_increase_id
     * @param todo
     * @return added todo contains auto_increase_id
     * @throws SQLException
     */
    public Todo add(Todo todo) throws SQLException {
        Integer autoIncKey = null;
        String sql = "INSERT INTO todo (title, completed) VALUES(?, ?);";

        preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, todo.getTitle());
        preparedStatement.setBoolean(2, todo.getCompleted());
        preparedStatement.execute();

        //get last insert data's auto_increase_id
        ResultSet resultSet = preparedStatement.getGeneratedKeys();
        while (resultSet.next()) {
            autoIncKey = resultSet.getInt(1);
        }

        return getTodoById(autoIncKey);
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

    public void deleteById(Integer id) throws SQLException {
        String sql = "delete from todo where id = ?";
        preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        preparedStatement.execute();
        close();
    }

    public List<Todo> getTodoList() throws SQLException {
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

    public Todo getTodoById(Integer id) throws SQLException {
        Todo todo = null;
        String sql = "select * from todo where id = ?";

        preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            todo = new Todo(resultSet.getInt("id"), resultSet.getString("title"), resultSet.getBoolean("completed"));
        }
        close();
        return todo;
    }
}
