package uz.pdp.lesson.demo2.todo;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class Todo {
    private int id;
    private int fileId;
    private int owner_id;
    private String task;
    private String description;
    private LocalDateTime created_at;
    private LocalDateTime due_date;
    private boolean completed;

    public Todo(int owner_id, String task, String description, LocalDateTime due_date) {
        this.owner_id = owner_id;
        this.task = task;
        this.description = description;
        this.due_date = due_date;
        this.completed = false;
        this.created_at = LocalDateTime.now();
    }
}
