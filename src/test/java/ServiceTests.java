import com.fedomn.todomvc.Model.Todo;
import com.fedomn.todomvc.Service.TodoService;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ServiceTests {

    private static Todo testTodo;

    @Test
    public void test_01_add_success() throws SQLException, ParseException {
        testTodo = new TodoService().add(new Todo("test-add", false));
    }

    @Test
    public void test_02_getTodoById_success() throws SQLException {
        Todo todo = new TodoService().getTodoById(testTodo.getId());
        assertEquals(todo, testTodo);
    }

    @Test
    public void test_03_update_success() throws SQLException {
        Todo todo = new Todo(testTodo.getId(), "test-Update", false);
        new TodoService().update(todo);
    }

    @Test
    public void test_04_deleteBdById_success() throws SQLException {
        Todo todo = new Todo(testTodo.getId(), "test-Update", false);
        new TodoService().deleteById(todo.getId());
    }


    @Test
    public void test_05_getTodoList_success() throws SQLException {
        List<Todo> queryTodo = new TodoService().getAll();
        for (Todo todo : queryTodo) {
            System.out.println(todo);
        }
    }

    @Test
    public void test_06_getAllCount_success() throws SQLException {
        Integer allCount = new TodoService().getAllCount();
        assertEquals(allCount, Integer.valueOf(3));
    }



}
