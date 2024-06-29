<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Task</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-color: #f4f4f4; /* Initial background color */
            animation: backgroundAnimation 10s ease infinite alternate; /* Background color animation */
            background-image: linear-gradient(45deg, rgba(255, 255, 255, 0.8), rgba(0, 0, 0, 0.8));
            background-size: 400% 400%;
            animation: gradientAnimation 15s ease infinite;
        }

        @keyframes gradientAnimation {
            0% {
                background-position: 0% 50%;
            }
            50% {
                background-position: 100% 50%;
            }
            100% {
                background-position: 0% 50%;
            }
        }

        .container {
            background-color: #fff;
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            max-width: 600px;
            margin: 20px;
            text-align: center;
            animation: fadeInUp 0.5s ease, pulse 2s ease infinite; /* Fade-in animation and pulse effect */
        }

        @keyframes fadeInUp {
            0% {
                opacity: 0;
                transform: translateY(20px);
            }
            100% {
                opacity: 1;
                transform: translateY(0);
            }
        }

        @keyframes pulse {
            0%, 100% {
                transform: scale(1);
            }
            50% {
                transform: scale(1.05);
            }
        }

        h1 {
            margin-bottom: 20px;
            font-size: 28px;
            color: #333;
        }

        .form-group {
            margin-bottom: 20px;
            text-align: left;
        }

        label {
            display: block;
            margin-bottom: 10px;
            color: #555;
        }

        input[type="text"], textarea, input[type="datetime-local"] {
            width: calc(100% - 30px);
            padding: 12px;
            border: 1px solid #ccc;
            border-radius: 6px;
            font-size: 16px;
        }

        textarea {
            height: 120px;
            resize: vertical;
        }

        button {
            padding: 14px 20px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 6px;
            cursor: pointer;
            font-size: 18px;
            transition: background-color 0.3s ease, transform 0.3s ease;
        }

        button:hover {
            background-color: #0056b3;
            transform: scale(1.05); /* Scale up slightly on hover */
        }

        #message {
            margin-top: 20px;
            font-size: 18px;
            color: #28a745;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Create Task</h1>
    <form id="taskForm" action="/succes.jsp" method="post">
        <div class="form-group">
            <label for="title">Title:</label>
            <input type="text" id="title" name="title" required>
        </div>
        <div class="form-group">
            <label for="description">Description:</label>
            <textarea id="description" name="description" required></textarea>
        </div>
        <div class="form-group">
            <label for="due_date">Due Date:</label>
            <input type="datetime-local" id="due_date" name="due_date" required>
        </div>
        <button type="submit">CREATE</button>
    </form>
</div>
</body>
</html>
