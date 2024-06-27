package uz.pdp.lesson.demo2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SignupServlet", value = "/signup")
public class SignupServlet extends HttpServlet {
    private UserService userService = new UserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        int age = Integer.parseInt(request.getParameter("age"));

        String result = userService.signUp(firstname, lastname, email, password, age);

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        if ("Email already exists".equals(result)) {
            writer.println("""
                <html>
                <head>
                    <meta charset="UTF-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <title>Sign Up Error</title>
                    <style>
                        body {
                            display: flex;
                            justify-content: center;
                            align-items: center;
                            height: 100vh;
                            background-color: #f0f2f5;
                            font-family: Arial, sans-serif;
                        }
                        .message-box {
                            background: #fff;
                            padding: 20px;
                            border-radius: 8px;
                            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
                            text-align: center;
                            width: 300px;
                        }
                        .error {
                            color: red;
                            font-weight: bold;
                        }
                    </style>
                </head>
                <body>
                    <div class="message-box">
                        <p class="error">Email already exists</p>
                    </div>
                </body>
                </html>
            """);
        } else {
            writer.println("""
                <html>
                <head>
                    <meta charset="UTF-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <title>Sign Up Success</title>
                    <style>
                        body {
                            display: flex;
                            justify-content: center;
                            align-items: center;
                            height: 100vh;
                            background-color: #f0f2f5;
                            font-family: Arial, sans-serif;
                        }
                        .message-box {
                            background: #fff;
                            padding: 20px;
                            border-radius: 8px;
                            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
                            text-align: center;
                            width: 300px;
                        }
                        .success {
                            color: green;
                            font-weight: bold;
                        }
                        .continue-btn {
                            display: inline-block;
                            padding: 10px 20px;
                            margin-top: 20px;
                            background-color: #4CAF50;
                            color: white;
                            border: none;
                            border-radius: 4px;
                            text-decoration: none;
                        }
                        .continue-btn:hover {
                            background-color: #45a049;
                        }
                    </style>
                </head>
                <body>
                    <div class="message-box">
                        <p class="success">Congratulations, your account has been successfully created.</p>
                        <a href="/" class="continue-btn">Continue</a>
                    </div>
                </body>
                </html>
            """);
        }

        response.setHeader("Refresh", "3; URL=/");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.write("""
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
                """);
    }
}
