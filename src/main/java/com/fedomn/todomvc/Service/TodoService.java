package com.fedomn.todomvc.Service;

import com.fedomn.todomvc.Dao.TodoDao;
import com.fedomn.todomvc.Model.Todo;

import java.sql.SQLException;
import java.util.List;

public class TodoService {
    private TodoDao todoDao;

    public TodoService() {
        todoDao = new TodoDao();
    }

    public Todo add(Todo todo) throws SQLException {
        return todoDao.add(todo);
    }

    public void update(Todo todo) throws SQLException {
        todoDao.update(todo);
    }

    public void updateAllState(Boolean state) throws SQLException {
        todoDao.updateAllState(state);
    }

    public void deleteById(Integer id) throws SQLException {
        todoDao.deleteById(id);
    }

    public List<Todo> getAll() throws SQLException {
        return todoDao.getTodoList("all");
    }

    public List<Todo> getActive() throws SQLException {
        return todoDao.getTodoList("active");
    }

    public List<Todo> getCompleted() throws SQLException {
        return todoDao.getTodoList("complete");
    }

    public Todo getTodoById(Integer id) throws SQLException {
        return todoDao.getTodoById(id);
    }

    public Integer getAllCount() throws SQLException {
        return todoDao.getTodoCount("all");
    }

    public Integer getActiveCount() throws SQLException {
        return todoDao.getTodoCount("active");
    }

    public Integer getCompletedCount() throws SQLException {
        return todoDao.getTodoCount("completed");
    }


}
