<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Admin - Attendances</title>
</head>
<body>
    <h1>Attendances</h1>
    <a href="${pageContext.request.contextPath}/admin/attendances/new">Add New Attendance</a>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Session</th>
                <th>Student</th>
                <th>Status</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="attendance" items="${attendances}">
                <tr>
                    <td>${attendance.attendanceId}</td>
                    <td>${attendance.session.id}</td>
                    <td>${attendance.student.name}</td>
                    <td>${attendance.status}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/admin/attendances/${attendance.attendanceId}">View</a>
                        <a href="${pageContext.request.contextPath}/admin/attendances/${attendance.attendanceId}/edit">Edit</a>
                        <a href="${pageContext.request.contextPath}/admin/attendances/${attendance.attendanceId}/delete">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
