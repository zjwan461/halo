package run.halo.app.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import run.halo.app.model.dto.TodoDTO;
import run.halo.app.model.entity.Todo;
import run.halo.app.model.params.TodoParam;
import run.halo.app.repository.TodoRepository;
import run.halo.app.service.TodoService;
import run.halo.app.service.base.AbstractCrudService;

/**
 * @author Jerry Su
 * @Date 2021/9/19 14:16
 */
@Service
public class TodoServiceImpl extends AbstractCrudService<Todo, Integer> implements TodoService {

    private final TodoRepository todoRepository;

    public TodoServiceImpl(TodoRepository todoRepository) {
        super(todoRepository);
        this.todoRepository = todoRepository;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void addTodo(TodoParam todoParam) {
        Todo todo = createTodo(todoParam);
        this.create(todo);
    }

    @NotNull
    protected Todo createTodo(TodoParam todoParam) {
        Todo todo = todoParam.convertTo();
        if (StringUtils.isBlank(todo.getAbstractContent())) {
            todo.setAbstractContent(StringUtils.substring(todo.getContent(), 0, 15));
        }
        if (todo.getStartDate() == null) {
            todo.setStartDate(new Date());
        }
        if (todo.getStatus() == null) {
            todo.setStatus(0); //0正常，1完成
        }
        if (todo.getTop() == null) {
            todo.setTop(0); //0正常，1，置顶}
        }
        return todo;
    }

    @Override
    public List<TodoDTO> listTodo(TodoParam todoParam) {
            Todo option = todoParam.convertTo();
        List<Todo> todos = todoRepository.findAll(Example.of(option),
            Sort.by(Sort.Direction.DESC, "top", "startDate"));
        // List<Todo> todos = listAll(Sort.by(Sort.Direction.DESC, "top", "startDate"));
        List<TodoDTO> list = new ArrayList<>();
        for (Todo todo : todos) {
            TodoDTO todoDTO = new TodoDTO();
            todoDTO.convertFrom(todo);
            list.add(todoDTO);
        }
        return list;
    }

    @Override
    public void updateTodo(TodoParam todoParam) {
        Todo todo = createTodo(todoParam);
        this.update(todo);
    }
}
