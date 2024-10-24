<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>New Chat</title>
    <style>
        body {
            font-family: 'Segoe UI', sans-serif; /* Set font for better readability */
            background: linear-gradient(to right, #1a1a2e, #16213e); /* Background gradient */
            color: white; /* Text color */
            margin: 0; /* Remove default margin */
            padding: 20px; /* Add padding around the body */
        }

        .container {
            max-width: 600px; /* Max width for the container */
            margin: auto; /* Center the container */
            background: rgba(0, 0, 0, 0.2); /* Slightly transparent white background */
            border-radius: 10px; /* Rounded corners */
            padding: 20px; /* Padding inside the container */
            box-shadow: 0 4px 20px rgba(0, 0, 0, 0.5); /* Shadow for depth */
        }

        h2 {
            font-family: 'Segoe UI', sans-serif;
            color: white;
            margin: 0;
            font-size: 2.2rem;/* Larger font size for better visibility */
            text-shadow: 1px 1px 2px rgba(0, 0, 0, 0.5), /* Main shadow */
                 0 0 25px rgba(255, 255, 255, 0.2); /* Glowing effect */
            margin-bottom: 20px; /* Space below the header */
            text-align: center; /* Centered title */
        }

        hr {
            border: none;
            height: 2px;
            background-color: white;
            width: 80%;
            margin: 20px auto;
        }

        label {
            display: block; /* Make labels block level */
            margin: 10px 0 5px; /* Margin for labels */
        }

        input[type="text"], textarea {
            width: 100%; /* Full width for inputs and textarea */
            padding: 10px; /* Padding inside inputs */
            border: 1px solid #ccc; /* Border color */
            border-radius: 5px; /* Rounded corners */
            margin-bottom: 15px; /* Space below inputs */
            font-size: 1rem; /* Font size for inputs */
        }

        button {
            background-color: #007bff; /* Green background for button */
            color: white; /* Text color for button */
            border: none; /* No border */
            padding: 10px 15px; /* Padding inside button */
            border-radius: 5px; /* Rounded corners */
            cursor: pointer; /* Pointer cursor on hover */
            font-size: 1rem; /* Font size for button */
            transition: background-color 0.3s; /* Smooth transition for background color */
        }

        button:hover {
            background-color: #2a3e50; /* Darker green on hover */
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>New Chat for Faculty: ${faculty.username}</h2>
        <hr>
        <form action="${pageContext.request.contextPath}/faculty/chat/send" method="post">
            <input type="hidden" name="facultyId" value="${faculty.facultyId}"/>
            <label for="studentId">Student ID:</label>
            <input type="text" id="studentId" name="studentId" required>
            <label for="message">Message:</label>
            <textarea id="message" name="message" required></textarea>
            <button type="submit">Send</button>
        </form>
    </div>
</body>
</html>

