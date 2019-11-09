package todos;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {

  private final TodoRepository repository;

  public Todo save(Todo todo) {
    return repository.save(todo);
  }

  public Todo getById(Long id) {
    return repository.getOne(id);
  }

  public List<Todo> findAll() {
    return repository.findAll();
  }

  public boolean deleteById(Long id) {

    Todo toDelete = repository.getOne(id);
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

    return repository.findAll(Example.of(todo));
  }
}
