package run.halo.app.controller.content.api;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import run.halo.app.model.dto.TodoDTO;
import run.halo.app.model.params.TodoParam;
import run.halo.app.model.support.CreateCheck;
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
    public TodoDTO addTodo(@RequestBody @Validated(CreateCheck.class) TodoParam todoParam) {
        todoService.addTodo(todoParam);
        return null;
    }
}
