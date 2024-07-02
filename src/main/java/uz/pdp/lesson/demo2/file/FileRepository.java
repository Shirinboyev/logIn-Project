package uz.pdp.lesson.demo2.file;

import java.sql.*;

public class FileRepository {
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

    public int save(File file) throws SQLException {
        Connection connection = getConnection();
        String sql = "INSERT INTO file (original_name, mime_type, new_name, file_data, upload_time) VALUES (?, ?, ?, ?, ?) RETURNING id";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, file.getOriginalName());
        preparedStatement.setString(2, file.getMimeType());
        preparedStatement.setString(3, file.getNewName());
        preparedStatement.setBytes(4, file.getFileData());
        preparedStatement.setTimestamp(5, Timestamp.valueOf(file.getUploadDate()));

        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getInt(1);
        } else {
            throw new SQLException("Failed to save file.");
        }
    }
    public File getFileById(int id) throws SQLException {
        Connection connection = getConnection();
        String sql = "SELECT * FROM file WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            File file = new File();
            file.setId(resultSet.getInt("id"));
            file.setOriginalName(resultSet.getString("original_name"));
            file.setMimeType(resultSet.getString("mime_type"));
            file.setNewName(resultSet.getString("new_name"));
            file.setFileData(resultSet.getBytes("file_data"));
            file.setUploadDate(resultSet.getTimestamp("upload_time").toLocalDateTime());
            return file;
        } else {
            throw new SQLException("File not found.");
        }
    }

    private Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
