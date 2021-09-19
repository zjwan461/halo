package run.halo.app.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import run.halo.app.model.entity.Todo;
import run.halo.app.model.params.TodoParam;
import run.halo.app.repository.TodoRepository;
import run.halo.app.service.TodoService;
import run.halo.app.service.base.AbstractCrudService;

import java.util.Date;

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
        Todo todo = todoParam.convertTo();
        if (StringUtils.isBlank(todo.getAbstractContent())) {
            todo.setAbstractContent(StringUtils.substring(todo.getContent(), 0, 20));
        }
        if (todo.getStartDate() == null) {
            todo.setStartDate(new Date());
        }
        this.create(todo);
    }
}
