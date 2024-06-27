
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            color: #333;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh;
            margin: 0;
            background-size: cover;
            background-position: center;
            background-repeat: no-repeat;
            background-attachment: fixed;
            text-align: center;
        }

        header h1 {
            color: #fff;
            background: rgba(0, 0, 0, 0.6);
            padding: 20px;
            border-radius: 10px;
            font-size: 3em;
            margin-bottom: 40px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        }

        .button-container h3 {
            display: flex;
            gap: 20px;
            justify-content: center;
        }

        a {
            text-decoration: none;
            color: white;
        }

        button {
            background-color: #4CAF50;
            color: white;
            padding: 15px 30px;
            margin: 10px;
            border: none;
            border-radius: 10px;
            cursor: pointer;
            font-size: 1.2em;
            transition: background-color 0.3s ease, transform 0.3s ease;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        }

        button:hover {
            background-color: #45a049;
            transform: translateY(-3px);
        }

        a:hover {
            color: #ddd;
        }

        @media (max-width: 768px) {
            header h1 {
                font-size: 2em;
                padding: 15px;
            }

            .button-container h3 {
                flex-direction: column;
                gap: 10px;
            }

            button {
                width: 100%;
                padding: 15px;
            }
        }

    </style>
</head>
<body>
<header>
    <h1>Asosiy Oyna</h1>
</header>
<section>
    <div class="button-container">
        <h3>
            <a href="/login">
                <button type="submit">Login</button>
            </a>
            <a href="/signup">
                <button type="submit">SignUp</button>
            </a>
        </h3>
    </div>
</section>

</body>
</html>
