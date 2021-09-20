package run.halo.app.todo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import run.halo.app.model.entity.Todo;
import run.halo.app.model.params.TodoParam;
import run.halo.app.repository.TodoRepository;
import run.halo.app.service.TodoService;
import javax.annotation.Resource;
import java.util.List;

/**
 * @author Jerry Su
 * @Date 2021/9/19 21:32
 */
@SpringBootTest
public class TodoTest {

    @Resource
    private TodoService todoService;

    @Resource
    private TodoRepository todoRepository;

    @Test
    public void test1() {
        todoService.listTodo(new TodoParam()).forEach(System.out::println);
    }

    @Test
    public void test2() {
        Todo todo = todoService.getById(1);
        // todo.setId(1);
        todo.setTop(0);
        todoService.update(todo);
    }

    @Test
    public void test3() {
        Todo todo = new Todo();
        todo.setTitle("测试任务");
        List<Todo> all = todoRepository.findAll(Example.of(todo), Sort.by(Sort.Direction.DESC,"startDate"));
        all.forEach(System.out::println);
    }
}
