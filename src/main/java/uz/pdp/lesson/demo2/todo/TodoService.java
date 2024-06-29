
package uz.pdp.lesson.demo2.todo;


import java.util.List;

public class TodoService {
    private final TodoRepository taskRepository = new TodoRepository();

    public void save(Todo task) {
        taskRepository.save(task);
    }

    public List<Todo> getAll() {
        return taskRepository.getAll();
    }
/*
    public Todo getById(int id) {
        return taskRepository.getById(id);
    }

    public void update(Todo task) {
        taskRepository.update(task);
    }

    public void delete(int id) {
        taskRepository.delete(id);
    }*/
}