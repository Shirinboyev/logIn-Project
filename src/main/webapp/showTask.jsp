<%@ page import="java.util.List" %>
<%@ page import="java.util.Objects" %>
<%@ page import="uz.pdp.lesson.demo2.todo.TodoService" %>
<%@ page import="uz.pdp.lesson.demo2.todo.Todo" %>
<%@ page import="uz.pdp.lesson.demo2.servlet.LoginServlet" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Todo List</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #121212;
            color: #e0e0e0;
            padding: 20px;
        }

        .container {
            max-width: 600px;
            margin: 0 auto;
            background: #1e1e1e;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        }

        .header {
            text-align: center;
            margin-bottom: 20px;
        }

        .header h1 {
            font-size: 2em;
            margin: 0;
            color: #bb86fc;
        }

        .button-container {
            text-align: center;
            margin-bottom: 20px;
        }

        .animated-button {
            font-size: 16px;
            padding: 10px 20px;
            border: 2px solid #bb86fc;
            background-color: #bb86fc;
            color: white;
            cursor: pointer;
            outline: none;
            transition: background-color 0.4s, color 0.4s;
            border-radius: 5px;
            text-decoration: none;
            display: inline-block;
        }

        .animated-button:hover {
            background-color: #1e1e1e;
            color: #bb86fc;
        }

        .todo-item {
            background-color: #333;
            border-radius: 10px;
            margin: 10px 0;
            padding: 15px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.5);
            transition: transform 0.2s;
        }

        .todo-item:hover {
            transform: scale(1.02);
        }

        .todo-header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            cursor: pointer;
        }

        .todo-header h2 {
            margin: 0;
            font-size: 1.2em;
            color: #03dac6;
        }

        .todo-icon {
            font-size: 20px;
            color: #03dac6;
        }

        .todo-details {
            display: none;
            margin-top: 10px;
        }

        .todo-details p {
            margin: 5px 0;
            color: #03dac6;
        }

        .checkbox-container {
            display: flex;
            align-items: center;
        }

        .checkbox-container input[type="checkbox"] {
            margin-right: 10px;
            transform: scale(1.5);
        }

        .completed {
            text-decoration: line-through;
            color: #03dac6;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="header">
        <h1>My Todo List</h1>
        <div class="button-container">
            <a href="showTask" class="animated-button">Show Tasks</a>
        </div>
    </div>
    <%
        TodoService toDoService = new TodoService();
        List<Todo> list = toDoService.getAll();
        for (Todo todo : list) {
            if (Objects.equals(todo.owner_id, LoginServlet.USER.getId())) {
    %>
    <div class="todo-item <%= todo.completed ? "completed" : "" %>">
        <div class="todo-header">
            <h2><%= todo.task %></h2>
            <i class="fas fa-angle-down todo-icon"></i>
        </div>
        <div class="todo-details">
            <p><strong>Description:</strong> <%= todo.description %></p>
            <p><strong>Create Date:</strong> <%= todo.created_at %></p>
            <p><strong>Due Date:</strong> <%= todo.due_date %></p>
            <div class="checkbox-container">
                <input type="checkbox" <%= todo.completed ? "checked" : "" %> onclick="toggleCompleted(<%= todo.id %>, this.checked)">
                <label><%= todo.completed ? "Completed ✔️" : "Mark as completed" %></label>
            </div>
        </div>
    </div>
    <%
            }
        }
    %>
</div>

<script>
    document.querySelectorAll('.todo-header').forEach(header => {
        header.addEventListener('click', () => {
            const details = header.nextElementSibling;
            details.style.display = (details.style.display === 'none' || details.style.display === '') ? 'block' : 'none';
        });
    });

    function toggleCompleted(todoId, completed) {
        fetch('toggleCompleted', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ id: todoId, completed: completed })
        }).then(response => {
            if (response.ok) {
                location.reload();
            } else {
                alert('Failed to update the task status.');
            }
        });
    }
</script>
</body>
</html>
