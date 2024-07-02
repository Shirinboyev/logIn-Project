
package uz.pdp.lesson.demo2.todo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TodoRepository {
    private static final String URL = "jdbc:postgresql://localhost:5432/userdb";
    private static final String USER = "postgres";
    private static final String PASSWORD = "1111";

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new IllegalStateException("Failed to load PostgreSQL JDBC driver.", e);
        }
    }

    public void save(Todo todo) {
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO todo_users(owner_id,task,description,due_date,file_id) VALUES(?,?,?,?,?)");
            preparedStatement.setInt(1, todo.getOwner_id());
            preparedStatement.setString(2, todo.getTask());
            preparedStatement.setString(3, todo.getDescription());
            preparedStatement.setTimestamp(4, Timestamp.valueOf(todo.getDue_date()));
            preparedStatement.setInt(5,todo.getFileId());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public List<Todo> getAll() {
        Connection connection = getConnection();
        List<Todo> todos = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM todo_users");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Todo todo = new Todo();
                todo.setId(rs.getInt("id"));
                todo.setOwner_id(rs.getInt("owner_id"));
                todo.setTask(rs.getString("task"));
                todo.setFileId(rs.getInt("file_id"));
                todo.setDescription(rs.getString("description"));
                todo.setCreated_at(rs.getTimestamp("created_at").toLocalDateTime());
                todo.setDue_date(rs.getTimestamp("due_date").toLocalDateTime());
                todo.setCompleted(rs.getBoolean("completed"));
                todos.add(todo);
            }
            return todos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Connection getConnection() {
        try {
            return DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}