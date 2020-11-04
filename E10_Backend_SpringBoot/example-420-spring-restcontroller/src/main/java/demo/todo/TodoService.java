package demo.todo;

import java.util.List;

public interface TodoService {

	Todo patchTodo(Long id, Todo newTodo);

	Todo updateTodo(Long id, Todo newTodo);

	boolean deleteTodoById(Long id);

	Todo findTodoById(Long id);

	Todo save(Todo todo);

	List<Todo> findAllTodos();

}
