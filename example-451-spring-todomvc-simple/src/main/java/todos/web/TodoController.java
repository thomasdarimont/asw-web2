package todos.web;

import lombok.RequiredArgsConstructor;
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
import org.springframework.web.util.UriComponentsBuilder;
import todos.Todo;
import todos.TodoService;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

/**
 * <pre>
 * {@code
 *
 *   # list all todos
 *   curl -v -H "Accept: application/json" http://localhost:8090/todos
 *
 *   # Create new todo
 *   curl -v -X POST -H "Content-type: application/json" -d '{ "title":"Test TODO", "completed":false }' http://localhost:8090/todos
 *
 *   # show todo with id 1
 *   curl -v -H "Accept: application/json" http://localhost:8090/todos/1
 *
 *   # delete todo with id 1
 *   curl -v -X DELETE http://localhost:8090/todos/1
 *
 *   # search for all todo's with titles beginning with 'test'
 *   curl -v -d '{"title":"test"}' -H "Content-type: application/json" -H "Accept: application/json" http://localhost:8090/todos/search
 *
 *   # search for all todo's with completed = true
 *   curl -v -d '{"completed":true}' -H "Content-type: application/json" -H "Accept: application/json" http://localhost:8090/todos/search
 * }
 * </pre>
 */
@RestController
@RequestMapping("/todos")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todos;

    @GetMapping
    public ResponseEntity<?> list() {
        return ResponseEntity.ok(todos.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return todos.getById(id)
                .map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.notFound()::build);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid Todo todo, UriComponentsBuilder ucBuilder) {

        Todo saved = todos.create(todo);

        URI newLocation = ucBuilder.path("/todos/{id}").buildAndExpand(saved.getId()).toUri();
        return ResponseEntity.created(newLocation).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Todo todo) {

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
    public ResponseEntity<?> remove(@PathVariable Long id) {

        if (todos.deleteById(id)) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
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
