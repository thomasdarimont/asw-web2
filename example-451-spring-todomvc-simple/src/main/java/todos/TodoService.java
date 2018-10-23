package todos;

import java.util.List;
import java.util.Optional;

public interface TodoService {

    Todo create(Todo todo);

    Optional<Todo> getById(Long id);

    List<Todo> findAll();

    boolean deleteById(Long id);

    Todo update(Long id, Todo newTodo);

    Todo patchTodo(Long id, Todo newTodo);

    List<Todo> findAllByExample(Todo example);
}
