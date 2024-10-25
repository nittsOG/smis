<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Student Inbox</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: linear-gradient(to right, #1a1a2e, #16213e); /* Darker gradient */
            margin: 0;
            padding: 20px;
            --border:.1rem solid rgba(0,0,0,.2);
        }

        h2 {
            font-family: 'Segoe UI', sans-serif;
            color: black;
            margin: 0;
            font-size: 2.2rem;/* Larger font size for better visibility */
            text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.5);
            margin-bottom: 20px; /* Space below the header */
            text-align: center; /* Centered title */

        }

        /* Main container for all content */
        .main-container {
            max-width: 800px;
            margin: 20px auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        }

        /* Table styling */
        table {
            width: 100%;
            border-collapse: collapse;
            border-radius: 8px;
            overflow: hidden;
            box-shadow: 0 4px 20px rgba(0, 0, 0, 0.5);
            animation: slideIn 0.5s;
        }
        

        th, td {
            padding: 15px;
            text-align: center;
            border: 1px solid rgba(255, 255, 255, 0.3);
            transition: background 0.3s;
        }

        th {
            background-color: rgba(60, 60, 60, 0.8);
            color: white;
            font-size: 1.2em;
            font-weight: 600;
        }

        td {
            background-color: #f9f9f9;
        }

        a {
            text-decoration: none;
            color: #007bff;
        }

        a:hover {
            text-decoration: underline;
        }

        /* New Chat button styled */
        .new-chat-btn {
            display: block;
            text-align: center;
            padding: 10px 20px;
            background-color: #1a1a2e;
            color: white;
            border-radius: 5px;
            text-decoration: none;
            font-size: 16px;
            margin: 20px auto 0;
            max-width: 150px;
        }

        .new-chat-btn:hover {
            background-color: #2c3e50;
        }

        /* Responsive Design */
        @media (max-width: 600px) {
            .main-container {
                padding: 15px;
            }

            table, th, td {
                font-size: 14px;
            }

            th, td {
                padding: 10px;
            }

            .new-chat-btn {
                font-size: 14px;
            }
        }
    </style>
</head>
<body>

    <!-- Main container for all content -->
    <div class="main-container">
        <h2>Inbox for Student: ${student.username}</h2>

        <!-- Table with messages -->
        <table>
            <tr>
                <th>Faculty</th>
                <th>Last Message</th>
                <th>Date</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="msg" items="${inbox}">
                <tr>
                    <td>${msg.faculty.username}</td>
                    <td>${msg.message}</td>
                    <td>${msg.timestamp}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/student/chat/conversation?studentId=${msg.student.studentId}&facultyId=${msg.faculty.facultyId}">View</a>
                    </td>
                </tr>
            </c:forEach>
        </table>

        <!-- New Chat button -->
        <a href="${pageContext.request.contextPath}/student/chat/new" class="new-chat-btn">New Chat</a>
    </div>

</body>
</html>

