package todos.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import todos.Todo;
import todos.TodoService;

import java.net.URI;
import java.util.List;

/**
 * <pre>
 * {@code
 *
 *   # list all todos
 *   curl -v -H "Accept: application/json" http://localhost:8080/resources/todos
 *
 *   # Create new todo
 *   curl -v -X POST -H "Content-type: application/json" -d '{ "title":"Test TODO", "completed":false }' http://localhost:8080/resources/todos
 *
 *   # show todo with id 1
 *   curl -v -H "Accept: application/json" http://localhost:8080/resources/todos/1
 *
 *   # delete todo with id 1
 *   curl -v -X DELETE http://localhost:8080/resources/todos/1
 *
 *   # search for all todo's with titles beginning with 'test'
 *   curl -v -d '{"title":"test"}' -H "Content-type: application/json" -H "Accept: application/json" http://localhost:8080/resources/todos/search
 *
 *   # search for all todo's with completed = true
 *   curl -v -d '{"completed":true}' -H "Content-type: application/json" -H "Accept: application/json" http://localhost:8080/resources/todos/search
 * }
 * </pre>
 */
@RestController
@RequestMapping("resources/todos")
@RequiredArgsConstructor
public class TodoResource {

  private final TodoService todos;

  @PostMapping
  public ResponseEntity<Todo> create(@RequestBody Todo todo, UriComponentsBuilder uriBuilder) {

    Todo saved = this.todos.save(todo);

    URI newLocation = uriBuilder.path("resources/todo/{id}").buildAndExpand(saved.getId()).toUri();
    return ResponseEntity.created(newLocation).build();
  }

  @GetMapping
  public ResponseEntity<List<Todo>> list() {
    return ResponseEntity.ok(this.todos.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Todo> getById(@PathVariable("id") Long id) {

    Todo found = this.todos.getById(id);
    if (found == null) {
      return ResponseEntity.notFound().build();
    }

    return ResponseEntity.ok(found);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Todo> update(@PathVariable("id") Long id, @RequestBody Todo todo) {

    Todo updated = todos.update(id, todo);

    if (updated == null) {
      return ResponseEntity.notFound().build();
    }

    return ResponseEntity.ok(updated);
  }

  @PatchMapping("/{id}")
  public ResponseEntity<?> patch(@PathVariable Long id, @RequestBody Todo todo) {

    Todo patched = todos.patchTodo(id, todo);

    if (patched == null) {
      return ResponseEntity.notFound().build();
    }

    return ResponseEntity.ok(patched);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> remove(@PathVariable("id") Long id) {

    if (todos.deleteById(id)) {
      return ResponseEntity.noContent().build();
    }

    return ResponseEntity.notFound().build();
  }

  @PostMapping("/search")
  public ResponseEntity<List<?>> search(@RequestBody Todo example) {

    List<?> result = this.todos.findAllByExample(example);

    return ResponseEntity.ok(result);
  }

  @GetMapping("/search")
  public ResponseEntity<?> searchWithParams(Todo example) {

    List<?> result = todos.findAllByExample(example);

    return ResponseEntity.ok(result);
  }
}
