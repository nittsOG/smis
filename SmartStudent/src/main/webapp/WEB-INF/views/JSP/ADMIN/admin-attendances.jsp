<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>List of Attendances</title>
</head>
<body>
    <h2>Attendances</h2>

    <!-- Filter Form -->
    <form action="${pageContext.request.contextPath}/admin/attendances" method="get">
        <label for="studentId">Student ID:</label>
        <input type="text" name="studentId" id="studentId">

        <label for="divisionId">Division ID:</label>
        <input type="text" name="divisionId" id="divisionId">

        <label for="subjectId">Subject ID:</label>
        <input type="text" name="subjectId" id="subjectId">

        <label for="date">Date:</label>
        <input type="date" name="date" id="date">

        <button type="submit">Filter</button>
    </form>

    <!-- Attendances List -->
    <table>
        <thead>
            <tr>
                <th>Attendance ID</th>
                <th>Student</th>
                <th>Session</th>
                <th>Status</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="attendance" items="${attendances}">
                <tr>
                    <td>${attendance.attendanceId}</td>
                    <td>${attendance.student.username}</td>
                    <td>${attendance.session.sessionDate} (${attendance.session.subject.name})</td>
                    <td>${attendance.status}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/admin/attendances/${attendance.attendanceId}">View</a> | 
                        <a href="${pageContext.request.contextPath}/admin/attendances/${attendance.attendanceId}/edit">Edit</a> | 
                        <a href="${pageContext.request.contextPath}/admin/attendances/${attendance.attendanceId}/delete">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
