
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
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO todo_users(owner_id,task,description,due_date) VALUES(?,?,?,?)");
            preparedStatement.setInt(1, todo.owner_id);
            preparedStatement.setString(2, todo.task);
            preparedStatement.setString(3, todo.description);
            preparedStatement.setTimestamp(4, Timestamp.valueOf(todo.due_date));
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
                todo.id = rs.getInt("id");
                todo.owner_id = rs.getInt("owner_id");
                todo.task = rs.getString("task");
                todo.description = rs.getString("description");
                todo.created_at = rs.getTimestamp("created_at").toLocalDateTime();
                todo.due_date = rs.getTimestamp("due_date").toLocalDateTime();
                todo.completed = rs.getBoolean("completed");
                todos.add(todo);
            }
            return todos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
/*
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
    }*/

    /*    public void update(Todo task) {
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


        }*/
    public Connection getConnection() {
        try {
            return DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}