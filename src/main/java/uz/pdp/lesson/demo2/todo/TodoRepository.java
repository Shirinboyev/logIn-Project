package uz.pdp.lesson.demo2.todo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TodoRepository {
    private static final String URL = "jdbc:postgresql://localhost:5432/todoapp";
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

    public void save(Todo task) {
        String query = "INSERT INTO tasks (owner_id, title, description, is_done, date) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, task.getOwnerId());
            statement.setString(2, task.getTitle());
            statement.setString(3, task.getDescription());
            statement.setBoolean(4, task.isDone());
            statement.setTimestamp(5, task.getDate());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Todo> getAll() {
        List<Todo> tasks = new ArrayList<>();
        String query = "SELECT * FROM tasks";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Todo task = new Todo();
                task.setId(resultSet.getInt("id"));
                task.setOwnerId(resultSet.getInt("owner_id"));
                task.setTitle(resultSet.getString("title"));
                task.setDescription(resultSet.getString("description"));
                task.setDone(resultSet.getBoolean("is_done"));
                task.setDate(resultSet.getTimestamp("date"));
                tasks.add(task);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tasks;
    }

    public Todo getById(int id) {
        Todo task = null;
        String query = "SELECT * FROM tasks WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    task = new Todo();
                    task.setId(resultSet.getInt("id"));
                    task.setOwnerId(resultSet.getInt("owner_id"));
                    task.setTitle(resultSet.getString("title"));
                    task.setDescription(resultSet.getString("description"));
                    task.setDone(resultSet.getBoolean("is_done"));
                    task.setDate(resultSet.getTimestamp("date"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return task;
    }

    public void update(Todo task) {
        String query = "UPDATE tasks SET owner_id = ?, title = ?, description = ?, is_done = ?, date = ? WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, task.getOwnerId());
            statement.setString(2, task.getTitle());
            statement.setString(3, task.getDescription());
            statement.setBoolean(4, task.isDone());
            statement.setTimestamp(5, task.getDate());
            statement.setInt(6, task.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String query = "DELETE FROM tasks WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
