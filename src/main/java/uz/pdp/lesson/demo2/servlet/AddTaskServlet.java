
package uz.pdp.lesson.demo2.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.pdp.lesson.demo2.todo.Todo;
import uz.pdp.lesson.demo2.todo.TodoService;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;

@WebServlet(name = "AddTaskServlet", value = "/addTask")
public class AddTaskServlet extends HttpServlet {
    private TodoService taskService = new TodoService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println(getTaskForm());

        request.getRequestDispatcher("/addTask.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("task");
        String description = request.getParameter("description");
        LocalDateTime dueDate = LocalDateTime.parse(request.getParameter("due_date"));

        taskService.save(new Todo(LoginServlet.USER.getId(),title,description,dueDate));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/succes.jsp");
        requestDispatcher.forward(request, response);
    }

    private String getTaskForm() {
        return """
            <!DOCTYPE html>
            <html lang="en">
            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Add Task</title>
                <style>
                    body {
                        font-family: Arial, sans-serif;
                        line-height: 1.6;
                        margin: 0;
                        padding: 0;
                        background-color: #f9f9f9;
                        display: flex;
                        justify-content: center;
                        align-items: center;
                        height: 100vh;
                    }
                    .task-form {
                        padding: 20px;
                        background-color: #fff;
                        border-radius: 10px;
                        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                        text-align: left;
                        color: #333;
                        border: 1px solid #ddd;
                    }
                    h2 {
                        margin-top: 0;
                        color: #006666;
                    }
                    label {
                        display: block;
                        margin-top: 10px;
                    }
                    input[type="text"], input[type="date"] {
                        width: 100%;
                        padding: 10px;
                        margin-top: 5px;
                        margin-bottom: 10px;
                        border: 1px solid #ddd;
                        border-radius: 5px;
                    }
                    button {
                        display: inline-block;
                        padding: 10px 20px;
                        background-color: darkcyan;
                        color: #fff;
                        border: none;
                        border-radius: 5px;
                        text-decoration: none;
                        cursor: pointer;
                        font-size: 16px;
                        transition: background-color 0.3s ease;
                    }
                    button:hover {
                        background-color: #006666;
                    }
                </style>
            </head>
            <body>
                <div class="task-form">
                    <h2>Add Task</h2>
                    <form method="post" action="/addTask">
                        <label for="title">Task Title</label>
                        <input type="text" id="title" name="title" required>
                        
                        <label for="description">Task Description</label>
                        <input type="text" id="description" name="description" required>
                        
                        <label for="date">Due Date</label>
                        <input type="date" id="date" name="date" required>
                        
                        <button type="submit">Add Task</button>
                    </form>
                </div>
            </body>
            </html>
            """;
    }

    private String taskAddedConfirmation() {
        return """
            <!DOCTYPE html>
            <html lang="en">
            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Task Added</title>
                <style>
                    body {
                        font-family: Arial, sans-serif;
                        line-height: 1.6;
                        margin: 0;
                        padding: 0;
                        background-color: #f9f9f9;
                        display: flex;
                        justify-content: center;
                        align-items: center;
                        height: 100vh;
                    }
                    .confirmation-message {
                        padding: 20px;
                        background-color: #fff;
                        border-radius: 10px;
                        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                        text-align: center;
                        color: #333;
                        border: 1px solid #ddd;
                    }
                    h2 {
                        margin-top: 0;
                        color: #006666;
                    }
                    a {
                        display: inline-block;
                        margin-top: 20px;
                        padding: 10px 20px;
                        background-color: darkcyan;
                        color: #fff;
                        border: none;
                        border-radius: 5px;
                        text-decoration: none;
                        cursor: pointer;
                        font-size: 16px;
                        transition: background-color 0.3s ease;
                    }
                    a:hover {
                        background-color: #006666;
                    }
                </style>
            </head>
            <body>
                <div class="confirmation-message">
                    <h2>Task Added Successfully</h2>
                    <a href="/addTask">Add Another Task</a>
                    <a href="/showTask">Show All Tasks</a>
                </div>
            </body>
            </html>
            """;
    }
}
