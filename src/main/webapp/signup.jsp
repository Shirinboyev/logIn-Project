<%--
  Created by IntelliJ IDEA.
  User: G'ayrat
  Date: 28/06/2024
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
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
            margin: 0;
            padding: 0;
            font-family: 'Helvetica Neue', sans-serif;
            background: linear-gradient(135deg, #71b7e6, #9b59b6);
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
            background: rgba(255, 255, 255, 0.9);
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0 4px 15px rgba(0, 0, 0, 0.2);
            width: 100%;
            max-width: 400px;
            text-align: center;
            animation: fadeInContainer 0.7s ease-in-out;
        }

        @keyframes fadeInContainer {
            from {
                opacity: 0;
                transform: translateY(-20px);
            }
            to {
                opacity: 1;
                transform: translateY(0);
            }
        }

        h2 {
            margin-bottom: 20px;
            color: #333;
            font-size: 24px;
            animation: slideInTitle 0.7s ease-in-out;
        }

        @keyframes slideInTitle {
            from {
                opacity: 0;
                transform: translateX(-50px);
            }
            to {
                opacity: 1;
                transform: translateX(0);
            }
        }

        label {
            display: block;
            margin-bottom: 5px;
            font-size: 14px;
            color: #555;
            text-align: left;
        }

        input {
            width: 100%;
            padding: 12px;
            border: 1px solid #ddd;
            border-radius: 6px;
            font-size: 14px;
            box-sizing: border-box;
            background-color: #fafafa;
            margin-bottom: 15px;
            transition: border-color 0.3s;
        }

        input:focus {
            border-color: #007bff;
            outline: none;
        }

        button {
            width: 100%;
            padding: 12px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 6px;
            cursor: pointer;
            font-size: 16px;
            transition: background-color 0.3s, transform 0.3s;
        }

        button:hover {
            background-color: #0056b3;
            transform: translateY(-1px);
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Sign Up</h2>
    <form id="signupForm" action="/signup" method="post">
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
</div>
</body>
</html>
