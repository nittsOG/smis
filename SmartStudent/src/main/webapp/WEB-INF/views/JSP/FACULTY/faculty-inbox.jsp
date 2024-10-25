<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Faculty Inbox</title>
    <style>
        body {
            font-family: 'Segoe UI', sans-serif; /* Set a modern font */
            background: linear-gradient(to right, #1a1a2e, #16213e); /* Background gradient */
            color: white; /* Text color */
            margin: 0; /* Remove default margin */
            padding: 20px; /* Padding around the body */
        }

        .container {
            max-width: 800px; /* Max width for the container */
            margin: auto; /* Center the container */
            background: rgba(0, 0, 0, 0.3); /* Slightly transparent white background */
            border-radius: 10px; /* Rounded corners */
            padding: 20px; /* Padding inside the container */
            box-shadow: 0 4px 20px rgba(0, 0, 0, 0.5); /* Shadow for depth */
        }

        h2 {
            font-family: 'Segoe UI', sans-serif;
            color: white;
            margin: 0;
            font-size: 2.2rem;/* Larger font size for better visibility */
            text-shadow: 1px 1px 2px rgba(0, 0, 0, 0.7), /* Main shadow */
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

        table {
            width: 100%; /* Full width for the table */
            border-collapse: collapse; /* Collapse borders */
            margin-top: 20px; /* Space above the table */
        }

        th, td {
            padding: 10px; /* Padding inside table cells */
            text-align: left; /* Left align text */
            border: 1px solid #ccc; /* Border color */
        }

        th {
            background-color: white; /* Green background for header */
            color: black; /* Text color for header */
        }

        tr:nth-child(even) {
            background-color: rgba(255, 255, 255, 0.1); /* Light background for even rows */
        }

        a {
            color: #007bff; /* Green link color */
            text-decoration: none; /* Remove underline */
            font-weight: bold; /* Bold links */
        }

        a:hover {
            text-decoration: underline; /* Underline on hover */
        }

        .new-chat {
            text-align: center; /* Center the new chat link */
            margin-top: 20px; /* Space above the link */
        }

        .new-chat a{
            color: white;
        }

        .new-chat a:hover{
            color: red;
            text-decoration: none;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Inbox for Faculty: ${faculty.username}</h2>
        <hr>
        <table>
            <tr>
                <th>Student</th>
                <th>Last Message</th>
                <th>Date</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="msg" items="${inbox}">
                <tr>
                    <td>${msg.student.username}</td>
                    <td>${msg.message}</td>
                    <td>${msg.timestamp}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/faculty/chat/conversation?studentId=${msg.student.studentId}&facultyId=${faculty.facultyId}">View</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <div class="new-chat">
            <p><a href="${pageContext.request.contextPath}/faculty/chat/new">New Chat</a></p>
        </div>
    </div>
</body>
</html>
