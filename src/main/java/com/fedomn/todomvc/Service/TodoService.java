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

    /**
     *
     * @param todo
     * @return added todo contains auto_increase_id
     * @throws SQLException
     */
    public Todo add(Todo todo) throws SQLException {
        return todoDao.add(todo);
    }

    public void update(Todo todo) throws SQLException {
        todoDao.update(todo);
    }

    public void deleteById(Integer id) throws SQLException {
        todoDao.deleteById(id);
    }

    public List<Todo> getTodoList() throws SQLException {
        return todoDao.getTodoList();
    }

    public Todo getTodoById(Integer id) throws SQLException {
        return todoDao.getTodoById(id);
    }
}
