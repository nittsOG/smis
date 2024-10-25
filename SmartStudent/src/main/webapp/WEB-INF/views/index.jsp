<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SmartStudent Management System</title>
     <link rel="stylesheet">  <!--Link to your external CSS file -->
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-image: url('index2.png'); /* Replace with your image path */
            background-size: cover; /* Cover the entire viewport */
            background-position: center; /* Center the image */
            margin: 0;
        }

        .container {
            text-align: center;
            padding: 20px;
           /*background-color: rgba(255, 255, 255, 0.8);/* Semi-transparent white background */
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            opacity: 0; /* Initially hidden */
            transition: opacity 1s ease; /* Fade effect */
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items:center;
            height: 300px;
        }

        h1 {
            font-size: 36px;
            color: #e74c3c;
            margin-bottom: 20px;
        }

        .login-btn {
            padding: 10px 20px;
            text-align: center;
            font-size: 30px;
            background-color: #4526c3; /* Button color */
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            display: none; /* Initially hidden */
            margin-top: 20px;
        }

        .login-btn:hover {
            background-color: #2c3e50;
        }

        .welcome-message {
            align-items: flex-start;
            font-size: 75px;
            font-style: normal;
            color: #333;
            margin-bottom: 20px;
            animation: mymove 2s ease; /* Fade in effect */
        }
        .welcome-message span{
            font-weight: bolder;
            color: #e74c3c;
        }

        @keyframes mymove {
            from { opacity: 0; }
            to { opacity: 1; }
        }
    </style>
</head>
<body>

    <div class="container">
        <div class="welcome-message">Welcome to <span>SmartStudent!</span></div>
        <button class="login-btn" id="loginBtn" onclick="window.location.href='login.html'">Login</button>
    </div>

    <script>
        // Show the container and login button after the welcome message
        setTimeout(function() {
            document.querySelector('.container').style.opacity = '1'; // Show container
            document.getElementById('loginBtn').style.display = 'block'; // Show login button
        }, 3000); // Wait 3 seconds
    </script>

</body>
</html>

<!-- <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>This is Index page</h1>
<h2><a href="login">Login</a></h2>
</body>
</html> -->
