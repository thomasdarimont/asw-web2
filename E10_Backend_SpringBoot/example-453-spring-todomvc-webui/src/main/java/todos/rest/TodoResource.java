package todos.rest;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import todos.Todo;
import todos.TodoService;

import java.net.URI;
import java.util.List;

/**
 * A simple {@link RestController} for managing Todo's.
 *
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
@RequestMapping(TodoResource.BASE_PATH)
@RequiredArgsConstructor
public class TodoResource {

    public static final String BASE_PATH = "resources/todos";

    private static final Logger LOGGER = LoggerFactory.getLogger(TodoResource.class);

    private final TodoService todos;

    /**
     * Creates a new {@link Todo}.
     *
     * @param todo
     * @param uriBuilder
     * @return
     */
    @PostMapping
    public ResponseEntity<Todo> create(@RequestBody Todo todo, UriComponentsBuilder uriBuilder) {

        LOGGER.info("New Todo: todo={}", todo);

        Todo saved = this.todos.save(todo);

        URI newLocation = uriBuilder.path(BASE_PATH + "/{id}").buildAndExpand(saved.getId()).toUri();
        return ResponseEntity.created(newLocation).build();
    }

    /**
     * List all {@link Todo Todo's}.
     *
     * @return
     */
    @GetMapping
    public ResponseEntity<List<Todo>> list() {

        LOGGER.info("List Todos");

        return ResponseEntity.ok(this.todos.findAll());
    }

    /**
     * Find a {@link Todo} by ID.
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<Todo> getById(@PathVariable("id") Long id) {

        LOGGER.info("Get Todo: id={}", id);

        Todo found = this.todos.getById(id);
        if (found == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(found);
    }

    /**
     * Update a {@link Todo} referenced by {@code id} with the representation given as {@code todo}.
     *
     * @param id
     * @param todo
     * @return
     */
    @PutMapping("/{id}")
    public ResponseEntity<Todo> update(@PathVariable("id") Long id, @RequestBody Todo todo) {

        LOGGER.info("Update/Replace Todo: id={} todo={}", id, todo);

        Todo updated = todos.update(id, todo);

        if (updated == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updated);
    }

    /**
     * Partially Update a {@link Todo} referenced by {@code id} with the representation given as {@code todo}.
     *
     * @param id
     * @param todo
     * @return
     */
    @PatchMapping("/{id}")
    public ResponseEntity<?> patch(@PathVariable Long id, @RequestBody Todo todo) {

        LOGGER.info("Update/Patch Todo: id={} todo={}", id, todo);

        Todo patched = todos.patchTodo(id, todo);

        if (patched == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(patched);
    }

    /**
     * Delete the {@link Todo} referenced by {@code id}.
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> remove(@PathVariable("id") Long id) {

        LOGGER.info("Remove Todo: id={}", id);

        if (todos.deleteById(id)) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

    /**
     * Search for {@link Todo Todo's} with the provided {@code example}.
     *
     * @param example
     * @return
     */
    @PostMapping("/search")
    public ResponseEntity<List<?>> search(@RequestBody Todo example) {

        LOGGER.info("Search Todo via POST: example={}", example);

        List<?> result = this.todos.findAllByExample(example);

        return ResponseEntity.ok(result);
    }

    /**
     * @see #search(Todo)
     * @param example
     * @return
     */
    @GetMapping("/search")
    public ResponseEntity<?> searchWithParams(Todo example) {

        LOGGER.info("Search Todo via GET: example={}", example);

        List<?> result = todos.findAllByExample(example);

        return ResponseEntity.ok(result);
    }
}
