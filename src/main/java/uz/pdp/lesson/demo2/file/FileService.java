package uz.pdp.lesson.demo2.file;


import uz.pdp.lesson.demo2.todo.Todo;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FileService {
    private static final String URL = "jdbc:postgresql://localhost:5432/userdb";
    private static final String USER = "postgres";
    private static final String PASSWORD = "1111";

    private final FileRepository fileRepository = new FileRepository();

    public int save(File file) throws SQLException {
        return fileRepository.save(file);
    }
    public File getFileById(int id) throws SQLException {
        return fileRepository.getFileById(id);
    }

    private static final String SELECT_ALL_TODOS = "SELECT * FROM todos";

    public List<Todo> getAllTodos() {
        List<Todo> todos = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_TODOS)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String task = rs.getString("task");
                String description = rs.getString("description");
                LocalDateTime dueDate = rs.getTimestamp("due_date").toLocalDateTime();
                boolean completed = rs.getBoolean("completed");
                int fileId = rs.getInt("file_id");
                int ownerId = rs.getInt("owner_id");
                Todo todo = new Todo();
                todo.setId(id);
                todo.setTask(task);
                todo.setDescription(description);
                todo.setDue_date(dueDate);
                todo.setCompleted(completed);
                todo.setOwner_id(ownerId);
                todo.setFileId(fileId);
                todos.add(todo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return todos;
    }

}
