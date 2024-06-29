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

        .button {
            display: inline-flex;
            align-items: center;
            justify-content: center;
            padding: 15px 30px;
            border: 0;
            position: relative;
            overflow: hidden;
            border-radius: 10rem;
            transition: all 0.2s;
            font-weight: bold;
            color: rgb(37, 37, 37);
            z-index: 0;
            box-shadow: 0 0px 7px -5px rgba(0, 0, 0, 0.5);
            margin: 0 20px;
        }

        .button:hover {
            background: rgb(193, 228, 248);
            color: rgb(33, 0, 85);
        }

        .button:active {
            transform: scale(0.97);
        }

        .hoverEffect {
            position: absolute;
            bottom: 0;
            top: 0;
            left: 0;
            right: 0;
            display: flex;
            align-items: center;
            justify-content: center;
            z-index: 1;
        }

        .hoverEffect div {
            background: rgb(222, 0, 75);
            background: linear-gradient(90deg, rgba(222, 0, 75, 1) 0%, rgba(191, 70, 255, 1) 49%, rgba(0, 212, 255, 1) 100%);
            border-radius: 40rem;
            width: 10rem;
            height: 10rem;
            transition: 0.4s;
            filter: blur(20px);
            animation: effect infinite 3s linear;
            opacity: 0.5;
        }

        .button:hover .hoverEffect div {
            width: 8rem;
            height: 8rem;
        }

        @keyframes effect {

            0% {
                transform: rotate(0deg);
            }

            100% {
                transform: rotate(360deg);
            }
        }

    </style>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
</head>

<body>
<div class="clock" id="clock"></div>
<header>
    <h1>Welcome to Todo</h1>
</header>
<section>
    <div class="button-container">
        <a href="/login">
            <button class="button">
                Login
                <div class="hoverEffect">
                    <div></div>
                </div>
            </button>
        </a>
        <a href="/signup">
            <button class="button">
                Signup
                <div class="hoverEffect">
                    <div></div>
                </div>
            </button>
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
