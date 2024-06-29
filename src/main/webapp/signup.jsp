<%--
  Created by IntelliJ IDEA.
  User: G'ayrat
  Date: 28/06/2024
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign Up</title>
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-color: #f0f2f5;
            font-family: Arial, sans-serif;
        }
        #signupForm {
            background: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            width: 300px;
        }
        h2 {
            text-align: center;
            color: #333;
        }
        label {
            display: block;
            margin-top: 10px;
            color: #555;
        }
        input {
            width: 100%;
            padding: 10px;
            margin-top: 5px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        .btn {
            width: 100%;
            padding: 10px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            margin-top: 15px;
        }
        .btn:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<form id="signupForm" action="/signup" method="post">
    <h2>Sign Up</h2>
    <label for="firstname">First Name:</label>
    <input type="text" id="firstname" name="firstname" required>
    <label for="lastname">Last Name:</label>
    <input type="text" id="lastname" name="lastname" required>
    <label for="signupEmail">Email:</label>
    <input type="email" id="signupEmail" name="email" required>
    <label for="signupPassword">Password:</label>
    <input type="password" id="signupPassword" name="password" required>
    <label for="age">Age:</label>
    <input type="number" id="age" name="age" required>
    <button type="submit" class="btn">Sign Up</button>
</form>
</body>

</body>
</html>
