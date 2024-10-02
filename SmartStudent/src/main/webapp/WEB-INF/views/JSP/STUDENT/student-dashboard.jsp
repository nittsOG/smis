<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student Dashboard</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/STUDENT/dashboard.css">
</head>
<body>
    <!-- Sidebar Section -->
    <div id="sidebar" class="sidebar">
        <button id="close-btn" class="close-btn" onclick="toggleSidebar()">></button> <!-- Updated Close Button -->
        <a href="${pageContext.request.contextPath}/student/profile">Profile</a>
        <a href="${pageContext.request.contextPath}/student/attendance">Attendance</a>
        <a href="${pageContext.request.contextPath}/student/results">Results</a>
        <a href="${pageContext.request.contextPath}/student/timetable">Timetable</a>
        <a href="${pageContext.request.contextPath}/student/fees">Fees</a>
        <a href="${pageContext.request.contextPath}/student/logout">Logout</a>
    </div>

    <!-- Main Content -->
    <div id="main-content" class="main-content">
        <button class="open-btn" onclick="toggleSidebar()"><</button> <!-- Updated Open Button -->
        <h1>Welcome, ${student}</h1>
        <hr>
        <p><a href="${pageContext.request.contextPath}/student/profile">Go to profile</a></p>
        <p><a href="${pageContext.request.contextPath}/student/chat/inbox">Inbox</a></p>
    </div>

    <script src="${pageContext.request.contextPath}/resources/STUDENT/dashboard.js"></script>
</body>
</html>
