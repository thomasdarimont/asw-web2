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
 * Simple REST Controller for the ToDo MVC API.
 * 
 * <pre>
 * {@code
 *
 *   # list all todos
 *   curl -s -H "Accept: application/json" http://localhost:8090/simple/todos
 *
 *   # Create new todo
 *   curl -s -X POST -H "Content-type: application/json" -d '{ "title":"Test TODO", "completed":false }' http://localhost:8090/simple/todos
 *
 *   # show todo with id 1
 *   curl -s -H "Accept: application/json" http://localhost:8090/simple/todos/1
 *   
 *   # mark todo 2 as completed
 *   curl -s -X PUT -H "Content-type: application/json" -d '{ "title": "Vorlesung halten", "completed":true }' http://localhost:8090/simple/todos/2
 *   
 *   # delete todo with id 1
 *   curl -s -X DELETE http://localhost:8090/simple/todos/1
 *
 *   # search for all todo's with titles beginning with 'test' via POST
 *   curl -s -H "Content-type: application/json" -d '{"title":"Feedback"}' http://localhost:8090/simple/todos/search
 *
 *   # search for all todo's with completed = true via GET and URL Parameters
 *   Windows: curl -s http://localhost:8090/simple/todos/search?completed=true
 *   Linux/OSX: curl -s http://localhost:8090/simple/todos/search\?completed=true
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
