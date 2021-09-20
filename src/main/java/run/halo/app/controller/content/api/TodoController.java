package run.halo.app.controller.content.api;

import java.util.List;
import java.util.Optional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import run.halo.app.model.dto.TodoDTO;
import run.halo.app.model.entity.Todo;
import run.halo.app.model.params.TodoParam;
import run.halo.app.model.support.CreateCheck;
import run.halo.app.model.support.UpdateCheck;
import run.halo.app.service.TodoService;

/**
 * @author Jerry Su
 * @Date 2021/9/19 14:05
 */
@RestController("ApiTodoController")
@RequestMapping("/api/content/todo")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping("/add")
    public String addTodo(@RequestBody @Validated(CreateCheck.class) TodoParam todoParam) {
        todoService.addTodo(todoParam);
        return "success";
    }

    @GetMapping("/list")
    public List<TodoDTO> listTodo(TodoParam todoParam) {
        return todoService.listTodo(todoParam);
    }

    @PostMapping("/update")
    public String updateTodo(@RequestBody @Validated(UpdateCheck.class) TodoParam todoParam) {
        todoService.updateTodo(todoParam);
        return "success";
    }

    @GetMapping("/{id}")
    public TodoDTO getTodoByID(@PathVariable("id") Integer id) {
        Optional<Todo> todo = todoService.fetchById(id);
        return new TodoDTO().convertFrom(todo.orElseGet(Todo::new));
    }

    @DeleteMapping("/{id}")
    public String deleteTodo(@PathVariable("id") Integer id) {
        todoService.removeById(id);
        return "success";
    }
}
