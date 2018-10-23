package todos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class TodosInitializer {

    @Autowired
    public void init(TodoService todos) {
        todos.create(newTodo("Vorlesung vorbereiten"));
        todos.create(newTodo("Vorlesung halten"));
        todos.create(newTodo("Feedback sammeln"));
        todos.create(newTodo("Vorlesung nachbereiten"));
    }


    private Todo newTodo(String title) {
        Todo todo = new Todo();
        todo.setTitle(title);
        todo.setCompleted(false);
        return todo;
    }
}
