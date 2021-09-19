package run.halo.app.service;

import run.halo.app.model.entity.Todo;
import run.halo.app.model.params.TodoParam;
import run.halo.app.service.base.CrudService;

/**
 * @author Jerry Su
 * @Date 2021/9/19 14:16
 */
public interface TodoService extends CrudService<Todo, Integer> {

    void addTodo(TodoParam todoParam);
}
