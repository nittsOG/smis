<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Faculty Dashboard</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: linear-gradient(to right, #1a1a2e, #16213e); /* Darker gradient */
            margin: 0;
            padding: 0;
        }

        h1 {
            font-family: 'Segoe UI', sans-serif;
            color: black;
            margin: 0;
            font-size: 2.2rem;/* Larger font size for better visibility */
            text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.5);
            margin-bottom: 20px; /* Space below the header */
            text-align: center; /* Centered title */
        }

        hr {
            border: none;
            height: 2px;
            background-color: black;
            width: 80%;
            margin: 20px auto;
        }

        .container {
            width: 80%;
            margin: 0 auto;
            max-width: 1000px;
            padding: 20px;
            background-color: white;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
            margin-top: 30px;
        }

        .menu a {
            display: block;
            text-decoration:none;
            background-color: #1a1a2e;
            color: white;
            padding: 30px;
            border: 1px solid black;
            border-radius: 5px;
            margin: 10px 0;
            text-align: center;
            transition: background-color 0.3s ease, color 0.3s ease;
        }

        .menu a:hover {
            background-color: #2a3e50;
            color: white;
        }

        .menu {
            display:grid;
            grid-template-columns: repeat(3, 1fr); /* 3 columns */
            gap: 20px; /* Space between items */
            margin-top: 20px;
        }

        .menu p {
            margin: 0;
        }

        .logout {
            text-align:center;
            margin-top: 10px;
        }

        .logout a {
            text-decoration: none;
            background-color: #dc3545;
            color: white;
            font-weight: bold;
            padding: 10px 20px;
        }

        .logout a:hover {
            background-color: #2a3e50;
            color: white ;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Welcome, ${faculty}</h1>
        <hr>
    
        <div class="menu">
            <p><a href="${pageContext.request.contextPath}/faculty/profile">Profile</a></p>
            <p><a href="${pageContext.request.contextPath}/faculty/students">Student</a></p>
            <p><a href="${pageContext.request.contextPath}/faculty/attendance/sessions/map">Attendance</a></p>
            <p><a href="${pageContext.request.contextPath}/faculty/chat/inbox">Inbox</a></p>
            <p><a href="${pageContext.request.contextPath}/faculty/community/list">Community</a></p>
        </div>

        <div class="logout">
            <p><a href="${pageContext.request.contextPath}/faculty/logout">Logout</a></p>
        </div>
    </div>
</body>
</html>
