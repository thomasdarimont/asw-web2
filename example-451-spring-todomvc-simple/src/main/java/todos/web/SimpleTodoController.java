package todos.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import todos.Todo;
import todos.TodoService;

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
 *   # search for all todo's with titles beginning with 'test'
 *   curl -v -d '{"title":"test"}' -H "Content-type: application/json" -H "Accept: application/json" http://localhost:8080/todos/search
 *
 *   # search for all todo's with completed = true
 *   curl -v -d '{"title":"test"}' -H "Content-type: application/json" -H "Accept: application/json" http://localhost:8080/todos/search
 * }
 * </pre>
 */
@RestController
@RequestMapping("/simple/todos")
@RequiredArgsConstructor
public class SimpleTodoController {

	private final TodoService todos;

	@GetMapping
	public List<Todo> list() {
		return todos.findAll();
	}

	@GetMapping("/{id}")
	public Todo getById(@PathVariable Long id) {
		return todos.getById(id).get();
	}

	@PostMapping
	public Todo create(@RequestBody @Valid Todo todo) {
		return todos.create(todo);
	}

	@PutMapping("/{id}")
	public Todo update(@PathVariable Long id, @RequestBody Todo todo) {
		return todos.update(id, todo);
	}

	@DeleteMapping("/{id}")
	public void remove(@PathVariable Long id) {
		todos.deleteById(id);
	}

	@PostMapping("/search")
	public ResponseEntity<?> search(@RequestBody Todo example) {

		List<?> result = todos.findAllByExample(example);

		return ResponseEntity.ok(result);
	}

	@GetMapping("/search")
	public ResponseEntity<?> searchWithParams(Todo example) {

		List<?> result = todos.findAllByExample(example);

		return ResponseEntity.ok(result);
	}
}
