package demo.todo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Component;

@Component
class SimpleTodoService implements TodoService {

	private static final AtomicLong ID_GENERATOR = new AtomicLong();

	private List<Todo> todos = new ArrayList<>();

	public SimpleTodoService() {
		save(new Todo("Task 1"));
		save(new Todo("Task 2"));
		save(new Todo("Task 3"));
	}

	@Override
	public List<Todo> findAllTodos() {
		return todos;
	}

	@Override
	public Todo save(Todo todo) {
		todo.setId(ID_GENERATOR.incrementAndGet());
		todos.add(todo);
		return todo;
	}

	@Override
	public Todo findTodoById(Long id) {
		return todos.stream().filter(t -> t.getId().equals(id)).findFirst().orElse(null);
	}

	@Override
	public boolean deleteTodoById(Long id) {
		return todos.removeIf(t -> t.getId().equals(id));
	}

	@Override
	public Todo updateTodo(Long id, Todo newTodo) {

		Todo storedTodo = findTodoById(id);
		if (storedTodo == null) {
			return null;
		}

		storedTodo.setTitle(newTodo.getTitle());
		storedTodo.setCompleted(newTodo.getCompleted());

		return storedTodo;
	}

	@Override
	public Todo patchTodo(Long id, Todo newTodo) {

		Todo storedTodo = findTodoById(id);
		if (storedTodo == null) {
			return null;
		}

		if (newTodo.getTitle() != null) {
			storedTodo.setTitle(newTodo.getTitle());
		}

		if (newTodo.getCompleted() != null) {
			storedTodo.setCompleted(newTodo.getCompleted());
		}

		return storedTodo;
	}

}
