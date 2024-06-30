package uz.pdp.lesson.demo2.todo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@NoArgsConstructor
public class Todo {
    public int id;
    public int owner_id;
    public String task;
    public String description;
    public LocalDateTime created_at;
    public LocalDateTime due_date;
    public boolean completed;

    public Todo(int owner_id, String task, String description, LocalDateTime due_date) {
        this.owner_id = owner_id;
        this.task = task;
        this.description = description;
        this.due_date = due_date;
        this.completed = false;
        this.created_at = LocalDateTime.now();
    }
}