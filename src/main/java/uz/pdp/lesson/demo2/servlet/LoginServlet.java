package uz.pdp.lesson.demo2.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import uz.pdp.lesson.demo2.registration.User;
import uz.pdp.lesson.demo2.registration.UserService;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    private final UserService userService = UserService.getInstance();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        HttpSession session = request.getSession();

        User user = userService.logIn(email, password);

        PrintWriter writer = response.getWriter();

        String id = session.getId();
        Cookie cookie = new Cookie("JSESSIONID", id);
        cookie.setMaxAge(3600);
        response.addCookie(cookie);


        if (user != null) {
            session.setAttribute("userId", user.getId());
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
    <title>User Information</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .container {
            max-width: 600px;
            background-color: #ffffff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
            opacity: 0;
            transform: translateY(-20px);
            animation: fadeIn 1s forwards;
        }

        h1 {
            margin-top: 0;
            font-size: 28px;
            text-transform: uppercase;
            letter-spacing: 2px;
            color: #4CAF50;
            border-bottom: 2px solid #4CAF50;
            padding-bottom: 10px;
        }

        .button-container {
            display: flex;
            justify-content: space-between;
            margin-top: 20px;
        }

        .button-container a {
            text-decoration: none;
            display: inline-block;
            margin: 0 5px;
            padding: 17px 40px;
            border-radius: 50px;
            color: #722727;
            background-color: white;
            box-shadow: rgb(0 0 0 / 5%) 0 0 8px;
            letter-spacing: 1.5px;
            text-transform: uppercase;
            font-size: 15px;
            transition: all 0.5s ease;
        }

        .button-container a:hover {
            letter-spacing: 3px;
            background-color: hsl(261deg, 80%, 48%);
            color: #722727;
            box-shadow: rgb(93 24 220) 0px 7px 29px 0px;
        }

        .button-container a:active {
            letter-spacing: 3px;
            background-color: hsl(261deg, 80%, 48%);
            color: #722727;
            box-shadow: rgb(93 24 220) 0px 0px 0px 0px;
            transform: translateY(10px);
            transition: 100ms;
        }

        @keyframes fadeIn {
            to {
                opacity: 1;
                transform: translateY(0);
            }
        }
    </style>
</head>
"""+"""
<body>
    <div class="container">
        <h1>Welcome: %s %s</h1>
        <div class="button-container">
            <a href="/addTask">Add Task</a>
            <a href="/showTask">Show Task</a>
            <a href="/">Back to Home</a>
        </div>
    </div>
    <script>
        document.addEventListener('DOMContentLoaded', function () {
            const container = document.querySelector('.container');
            container.style.opacity = '1';
            container.style.transform = 'translateY(0)';
        });
    </script>
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
                            padding: 17px 40px;
                            border-radius: 50px;
                            cursor: pointer;
                            border: 0;
                            background-color: white;
                            box-shadow: rgb(0 0 0 / 5%) 0 0 8px;
                            letter-spacing: 1.5px;
                            text-transform: uppercase;
                            font-size: 15px;
                            transition: all 0.5s ease;
                        }
                        .button-container button:hover {
                            letter-spacing: 3px;
                            background-color: hsl(261deg 80% 48%);
                            color: hsl(0, 0%, 100%);
                            box-shadow: rgb(93 24 220) 0px 7px 29px 0px;
                        }
                        .button-container button:active {
                            letter-spacing: 3px;
                            background-color: hsl(261deg 80% 48%);
                            color: hsl(0, 0%, 100%);
                            box-shadow: rgb(93 24 220) 0px 0px 0px 0px;
                            transform: translateY(10px);
                            transition: 100ms;
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