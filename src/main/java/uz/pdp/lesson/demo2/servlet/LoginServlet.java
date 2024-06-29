package uz.pdp.lesson.demo2.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.pdp.lesson.demo2.registration.User;
import uz.pdp.lesson.demo2.registration.UserService;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    private UserService userService = new UserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = userService.logIn(email, password);

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        if (user != null) {
            writer.println(buildInfo(user));
        } else {
            writer.println(invalidUser());
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    static String buildInfo(User user) {
        return """
            <!DOCTYPE html>
            <html lang="en">
            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>User Information</title>j
                <style>
                    body {
                        font-family: Arial, sans-serif;
                        line-height: 1.6;
                        margin: 0;
                        padding: 0;
                        background-color: #f9f9f9;
                    }
                    .user-info {
                        max-width: 600px;
                        margin: 20px auto;
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
                    p {
                        margin: 10px 0;
                    }
                            
                    .user-info > p:first-child {
                        margin-top: 0;
                    }
                            
                    .return-button {
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
                            
                    .return-button:hover {
                        background-color: #006666;
                    }
                </style>
            </head>
                <body>
                    <div class="user-info">
                        <h2>Welcome %s %s</h2>
                        <a href = "/addTask"><button>Add Task</button></a>
                        <a href = "/showTask"><button>Show Task</button></a>
                    </div>
                </body>
                </html>
                """.formatted(user.getFirstname(), user.getLastname());
    }

    static String invalidUser() {
        return """
            <!DOCTYPE html>
            <html lang="en">
            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Error</title>
                <style>
                    body {
                        font-family: Arial, sans-serif;
                        line-height: 1.6;
                        margin: 0;
                        padding: 0;
                        background-color: #791c1c;
                        display: flex;
                        justify-content: center;
                        align-items: center;
                        height: 100vh;
                    }
                    .error-message {
                        padding: 20px;
                        background-color: #fff;
                        border-radius: 10px;
                        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                        text-align: center;
                        color: #333;
                        border: 1px solid #ddd;
                    }
                    h1 {
                        margin: 0;
                        color: #791c1c;
                    }
                    .return-button {
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
                    .return-button:hover {
                        background-color: #006666;
                    }
                    .button-container a {
                        text-decoration: none;
                    }
                    .button-container button {
                        display: inline-block;
                        margin-top: 20px;
                        padding: 10px 20px;
                        background-color: blue;
                        color: #fff;
                        border: none;
                        border-radius: 5px;
                        cursor: pointer;
                        font-size: 16px;
                        transition: background-color 0.3s ease;
                    }
                    .button-container button:hover {
                        background-color: darkblue;
                    }
                </style>
            </head>
            <body>
                <div class="error-message">
                    <h1>Email or password incorrect</h1>
                    <div class="button-container">
                        <a href="/">
                            <button type="button">Main Menu</button>
                        </a>
                    </div>
                </div>
            </body>
            </html>
            """;
    }
}
