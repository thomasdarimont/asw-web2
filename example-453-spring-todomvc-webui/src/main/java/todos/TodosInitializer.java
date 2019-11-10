package todos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class TodosInitializer {

    @Autowired
    public void init(TodoService todos) {
        todos.save(newTodo("Vorlesung vorbereiten"));
        todos.save(newTodo("Vorlesung halten"));
        todos.save(newTodo("Feedback sammeln"));
        todos.save(newTodo("Vorlesung nachbereiten"));
    }


    private Todo newTodo(String title) {
        Todo todo = new Todo();
        todo.setTitle(title);
        todo.setCompleted(false);
        return todo;
    }
}
