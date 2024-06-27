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
            background-image: url('rain.jpg');
            background-size: cover;
            background-position: center;
            background-repeat: no-repeat;
            background-attachment: fixed;
            text-align: center;
            position: relative;
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

        .button-container {
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

            .button-container {
                flex-direction: column;
                gap: 10px;
            }

            button {
                width: 100%;
                padding: 15px;
            }
        }

        .clock {
            font-size: 2em;
            color: #fff;
            background: rgba(0, 0, 0, 0.6);
            padding: 10px 20px;
            border-radius: 10px;
            margin-top: 20px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            position: absolute;
            top: 20px;
            right: 20px;
        }
    </style>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
</head>
<body>
<div class="clock" id="clock"></div>
<header>
    <h1>Main Menu</h1>
</header>
<section>
    <div class="button-container">
        <a href="/login">
            <button type="submit">Login</button>
        </a>
        <a href="/signup">
            <button type="submit">Sign Up</button>
        </a>
    </div>
</section>
<script>
    function updateTime() {
        const clockElement = document.getElementById("clock");
        clockElement.innerText = new Date().toLocaleTimeString();
    }

    updateTime();
    setInterval(updateTime, 1000);
</script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
</body>
</html>
