<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Error Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8d7da;
            color: #721c24;
            padding: 20px;
        }
        .error-container {
            border: 1px solid #f5c6cb;
            background-color: #f8d7da;
            padding: 20px;
            border-radius: 5px;
        }
        h2 {
            margin-top: 0;
        }
    </style>
</head>
<body>
    <div class="error-container">
        <h2>Oops! Something went wrong.</h2>
        <p>${msg}</p> <!-- Displays the exception message -->
    </div>
</body>
</html>
