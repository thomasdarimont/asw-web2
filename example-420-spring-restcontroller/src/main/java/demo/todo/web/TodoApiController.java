package demo.todo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.todo.Todo;
import demo.todo.TodoService;

/**
 * <pre>
 * {@code
 *
 *   # list all todos
 *   curl -v -H "Accept: application/json" http://localhost:8080/todos
 *
 *   # Create new todo
 *   curl -v -X POST -H "Content-type: application/json" -d '{ "title":"Test TODO", "completed":false }' http://localhost:8080/todos
 *
 *   # show todo with id 1
 *   curl -v -H "Accept: application/json" http://localhost:8080/todos/1
 *
 *   # delete todo with id 1
 *   curl -v -X DELETE http://localhost:8080/todos/1
 *   
 *   # update todo with id 3 (change completed=true) - note the whole representation changed!
 *   curl -v -X PUT -H "Content-type: application/json" -d '{ "title":"Task 3 Update", "completed":true }' http://localhost:8080/todos/3
 *   
 *   # update todo with id 3 (change title) - only the title changed!
 *   curl -v -X PATCH -H "Content-type: application/json" -d '{ "title": "Title via Patch" }' http://localhost:8080/todos/3
 * }
 * </pre>
 */
@RestController
@RequestMapping("/todos")
class TodoApiController {

	private final TodoService todoService;

	@Autowired
	public TodoApiController(TodoService todoService) {
		this.todoService = todoService;
	}

	@GetMapping
//	@RequestMapping(method=RequestMethod.GET)
	public List<Todo> findAllTodos() {
		return todoService.findAllTodos();
	}

	@PostMapping
	public Todo createTodo(@RequestBody Todo newTodo) {

		return todoService.save(new Todo(newTodo.getTitle()));
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findTodoById(@PathVariable Long id) {

		Todo todo = todoService.findTodoById(id);
		if (todo == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(todo);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteTodoById(@PathVariable Long id) {

		boolean removed = todoService.deleteTodoById(id);

		if (removed) {
			return ResponseEntity.status(HttpStatus.GONE).build();
		}

		return ResponseEntity.notFound().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateTodo(@PathVariable Long id, @RequestBody Todo newTodo) {

		Todo storedTodo = todoService.updateTodo(id, newTodo);

		if (storedTodo == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(storedTodo);
	}

	@PatchMapping("/{id}")
	public ResponseEntity<?> patchTodo(@PathVariable Long id, @RequestBody Todo newTodo) {

		Todo storedTodo = todoService.patchTodo(id, newTodo);

		if (storedTodo == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(storedTodo);
	}
}