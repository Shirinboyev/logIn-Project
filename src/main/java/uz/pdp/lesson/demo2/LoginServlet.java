package uz.pdp.lesson.demo2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    private UserService userService = new UserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = userService.logIn(email, password);

        if (user != null) {
            response.setContentType("text/html");
            PrintWriter writer = response.getWriter();
            writer.println(buildInfo(user));
        } else {
            response.getWriter().println("Invalid email or password");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.write("""
                <head>
                    <meta charset="UTF-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <title>Login</title>
                    <style>
                        body {
                            display: flex;
                            justify-content: center;
                            align-items: center;
                            height: 100vh;
                            background-color: #f0f2f5;
                            font-family: Arial, sans-serif;
                        }
                        #logInForm {
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
                    <form id="logInForm" action="/login" method="post">
                        <h2>Log In</h2>
                        <label for="logInEmail">Email:</label>
                        <input type="email" id="logInEmail" name="email" required>
                        <label for="logInPassword">Password:</label>
                        <input type="password" id="logInPassword" name="password" required>
                        <button type="submit" class="btn">Log In</button>
                    </form>
                </body>
                """);
    }

    static String buildInfo(User user) {
        return """
            <!DOCTYPE html>
            <html lang="en">
            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>User Information</title>
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
                        <p><strong>Firstname:</strong> %s</p>
                        <p><strong>Lastname:</strong> %s</p>
                        <p><strong>Email:</strong> %s</p>
                        <p><strong>Age:</strong> %d</p>
                    </div>
                </body>
                </html>
                """.formatted(user.getFirstname(), user.getLastname(), user.getFirstname(), user.getLastname(), user.getEmail(), user.getAge());
    }
}
