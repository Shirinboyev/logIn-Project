package uz.pdp.lesson.demo2.todo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Todo {
    private int id;
    private int ownerId;
    private String title;
    private String description;
    private boolean isDone;
    private Timestamp date;

}
