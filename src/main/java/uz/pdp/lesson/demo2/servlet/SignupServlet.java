package uz.pdp.lesson.demo2.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.pdp.lesson.demo2.registration.UserService;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SignupServlet", value = "/signup")
public class SignupServlet extends HttpServlet {
    private UserService userService = UserService.getInstance();

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

        req.getRequestDispatcher("/signup.jsp").forward(req, resp);

    }
}