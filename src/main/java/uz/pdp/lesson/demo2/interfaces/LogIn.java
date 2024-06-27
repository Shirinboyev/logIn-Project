package uz.pdp.lesson.demo2.interfaces;

public interface LogIn {
    String LOGIN = "<head>\n" +
            "                    <meta charset=\"UTF-8\">\n" +
            "                    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
            "                    <title>Login</title>\n" +
            "                    <style>\n" +
            "                        body {\n" +
            "                            display: flex;\n" +
            "                            justify-content: center;\n" +
            "                            align-items: center;\n" +
            "                            height: 100vh;\n" +
            "                            background-color: #f0f2f5;\n" +
            "                            font-family: Arial, sans-serif;\n" +
            "                        }\n" +
            "                        #logInForm {\n" +
            "                            background: #fff;\n" +
            "                            padding: 20px;\n" +
            "                            border-radius: 8px;\n" +
            "                            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);\n" +
            "                            width: 300px;\n" +
            "                        }\n" +
            "                        h2 {\n" +
            "                            text-align: center;\n" +
            "                            color: #333;\n" +
            "                        }\n" +
            "                        label {\n" +
            "                            display: block;\n" +
            "                            margin-top: 10px;\n" +
            "                            color: #555;\n" +
            "                        }\n" +
            "                        input {\n" +
            "                            width: 100%;\n" +
            "                            padding: 10px;\n" +
            "                            margin-top: 5px;\n" +
            "                            border: 1px solid #ccc;\n" +
            "                            border-radius: 4px;\n" +
            "                        }\n" +
            "                        .btn {\n" +
            "                            width: 100%;\n" +
            "                            padding: 10px;\n" +
            "                            background-color: #4CAF50;\n" +
            "                            color: white;\n" +
            "                            border: none;\n" +
            "                            border-radius: 4px;\n" +
            "                            cursor: pointer;\n" +
            "                            margin-top: 15px;\n" +
            "                        }\n" +
            "                        .btn:hover {\n" +
            "                            background-color: #45a049;\n" +
            "                        }\n" +
            "                    </style>\n" +
            "                </head>\n" +
            "                <body>\n" +
            "                    <form id=\"logInForm\" action=\"/login\" method=\"post\">\n" +
            "                        <h2>Log In</h2>\n" +
            "                        <label for=\"logInEmail\">Email:</label>\n" +
            "                        <input type=\"email\" id=\"logInEmail\" name=\"email\" required>\n" +
            "                        <label for=\"logInPassword\">Password:</label>\n" +
            "                        <input type=\"password\" id=\"logInPassword\" name=\"password\" required>\n" +
            "                        <button type=\"submit\" class=\"btn\">Log In</button>\n" +
            "                    </form>\n" +
            "                </body>\n" +
            "                ";
}