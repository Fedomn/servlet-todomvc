import com.fedomn.todomvc.Model.Todo;
import com.fedomn.todomvc.Service.TodoService;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ServiceTests {

    @Test
    public void test_01_add_success() throws SQLException, ParseException {
        Todo todo = new Todo(5, "test-add", false);
        new TodoService().add(todo);
    }



    @Test
    public void test_02_query_success() throws SQLException {
        List<Todo> queryTodo = new TodoService().query();
        for (Todo todo : queryTodo) {
            System.out.println(todo);
        }
    }

    @Test
    public void test_03_update_success() throws SQLException {
        Todo todo = new Todo(5, "test-Update", false);
        new TodoService().update(todo);
    }

    @Test
    public void test_04_deleteBdById_success() throws SQLException {
        Todo todo = new Todo(5, "test-Update", false);
        new TodoService().deleteById(todo);
    }
}
