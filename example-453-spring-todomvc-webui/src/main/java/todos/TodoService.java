package todos;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.ignoreCase;
import static org.springframework.data.domain.ExampleMatcher.matching;

@Service
@RequiredArgsConstructor
public class TodoService {

    private static final ExampleMatcher MATCH_TITLE_CONTAINS_IGNORE_CASE = matching()
            .withMatcher("title", ignoreCase().contains());

    private final TodoRepository repository;

    public Todo save(Todo todo) {
        return repository.save(todo);
    }

    public Todo getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Todo> findAll() {
        return repository.findAll();
    }

    public boolean deleteById(Long id) {

        Todo toDelete = repository.findById(id).orElse(null);
        if (toDelete == null) {
            return false;
        }

        repository.delete(toDelete);
        return true;
    }

    public Todo update(Long id, Todo todo) {

        Todo updated = getById(id);
        if (updated == null) {
            return null;
        }

        if (todo.getCompleted() != null) {
            updated.setCompleted(todo.getCompleted());
        }

        if (todo.getTitle() != null) {
            updated.setTitle(todo.getTitle());
        }

        return repository.save(updated);
    }

    public List<?> findAllByExample(Todo todo) {

        if (todo.getId() != null) {
            return Collections.singletonList(getById(todo.getId()));
        }

        return repository.findAll(Example.of(todo, MATCH_TITLE_CONTAINS_IGNORE_CASE));
    }
}
