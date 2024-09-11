<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student Timetable</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/STUDENT/dashboard.css">
</head>
<body>
    <!-- Sidebar Section -->
    <div id="sidebar" class="sidebar">
        <button id="close-btn" class="close-btn" onclick="toggleSidebar()"><</button>
        <a href="${pageContext.request.contextPath}/student/profile">Profile</a>
        <a href="${pageContext.request.contextPath}/student/attendance">Attendance</a>
        <a href="${pageContext.request.contextPath}/student/results">Results</a>
        <a href="${pageContext.request.contextPath}/student/timetable">Timetable</a>
        <a href="${pageContext.request.contextPath}/student/logout">Logout</a>
    </div>

    <!-- Main Content -->
    <div id="main-content" class="main-content">
        <button class="open-btn" onclick="toggleSidebar()">></button> <!-- Open Button -->

        <h2>Your Timetable</h2>

        <table class="timetable-table">
            <thead>
                <tr>
                    <th>Day</th>
                    <th>Start Time</th>
                    <th>End Time</th>
                    <th>Subject</th>
                    <th>Faculty</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="timetable" items="${timetable}">
                    <tr>
                        <td>${timetable.dayOfWeek}</td>
                        <td>${timetable.startTime}</td>
                        <td>${timetable.endTime}</td>
                        <td>${timetable.subject.name}</td>
                        <td>${timetable.faculty.username}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

    <script src="${pageContext.request.contextPath}/resources/STUDENT/dashboard.js"></script>
</body>
</html>
