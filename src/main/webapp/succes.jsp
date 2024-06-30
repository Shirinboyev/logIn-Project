<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Todo Creation Success</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background: linear-gradient(270deg, #ff7e5f, #feb47b);
            background-size: 400% 400%;
            animation: gradient 15s ease infinite;
        }

        @keyframes gradient {
            0% { background-position: 0% 50%; }
            50% { background-position: 100% 50%; }
            100% { background-position: 0% 50%; }
        }

        h2 {
            font-size: 2em;
            color: #fff;
            animation: fadeIn 2s ease-in-out, bounce 2s infinite alternate;
        }

        @keyframes fadeIn {
            from { opacity: 0; }
            to { opacity: 1; }
        }

        @keyframes bounce {
            from { transform: translateY(0); }
            to { transform: translateY(-20px); }
        }
    </style>
    <script>
        // Redirect to another page after 3 seconds
        setTimeout(function() {
            window.location.href = '/login'; // Replace '/login' with the URL of the page you want to redirect to
        }, 3000); // Adjust delay time as needed (in milliseconds)
    </script>
</head>
<body>
<h2>Todo successfully created 🎉</h2>
</body>
</html>
