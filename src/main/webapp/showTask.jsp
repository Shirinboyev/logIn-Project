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
        <h1>Todo List</h1>
    </div>
    <ul class="todo-list">
        <%
            @SuppressWarnings("unchecked")
            List<Todo> todos = (List<Todo>) request.getAttribute("todoList");
            if (todos != null) {
                for (Todo todo : todos) {
        %>
        <li class="todo-item">
            <div class="todo-header">
                <h2><%= todo.getTask() %></h2>
                <i class="fas fa-chevron-down todo-icon"></i>
            </div>
            <div class="todo-details">
                <p><strong>Description:</strong> <%= todo.getDescription() %></p>
                <p><strong>Due Date:</strong> <%= todo.getDue_date() %></p>
                <a href="/downloadPage?fileId=<%=todo.getFileId()%>" class="download-link">Download</a>
                <div class="checkbox-container">
                    <input type="checkbox" onclick="toggleCompleted(<%= todo.getId() %>, this.checked)" <%= todo.isCompleted() ? "checked" : "" %>>
                    <label>Completed</label>
                </div>
            </div>
        </li>
        <%
            }
        } else {
        %>
        <p>No todos available.</p>
        <%
            }
        %>
    </ul>
</div>

<script>
    document.querySelectorAll('.todo-header').forEach(header => {
        header.addEventListener('click', () => {
            const details = header.nextElementSibling;
            details.style.display = details.style.display === 'block' ? 'none' : 'block';
        });
    });

    function toggleCompleted(todoId, isCompleted) {
        fetch(`/completeTask?id=${todoId}&completed=${isCompleted}`, {
            method: 'POST',
        }).then(() => {
            location.reload();
        }).catch(error => {
            console.error('Error:', error);
        });
    }
</script>
</body>
</html>
