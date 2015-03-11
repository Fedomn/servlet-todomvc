package com.fedomn.todomvc.Service;

import com.fedomn.todomvc.Dao.TodoDao;
import com.fedomn.todomvc.Model.Todo;

import java.sql.SQLException;
import java.util.List;

public class TodoService {
    TodoDao todoDao;

    public TodoService() {
        todoDao = new TodoDao();
    }

    public void add(Todo todo) throws SQLException {
        todoDao.add(todo);
    }

    public void update(Todo todo) throws SQLException {
        todoDao.update(todo);
    }

    public void deleteById(Todo todo) throws SQLException {
        todoDao.deleteById(todo);
    }

    public List<Todo> query() throws SQLException {
        return todoDao.query();
    }
}
