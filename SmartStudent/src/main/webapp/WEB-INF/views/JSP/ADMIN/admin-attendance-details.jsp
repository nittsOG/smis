<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Attendance Details</title>
</head>
<body>
    <h2>Attendance Details</h2>

    <p><strong>Attendance ID:</strong> ${attendance.attendanceId}</p>
    <p><strong>Student:</strong> ${attendance.student.username}</p>
    <p><strong>Session Date:</strong> ${attendance.session.sessionDate}</p>
    <p><strong>Subject:</strong> ${attendance.session.subject.name}</p>
    <p><strong>Status:</strong> ${attendance.status}</p>

    <a href="${pageContext.request.contextPath}/admin/attendances/${attendance.attendanceId}/edit">Edit</a> |
    <a href="${pageContext.request.contextPath}/admin/attendances/${attendance.attendanceId}/delete">Delete</a>
</body>
</html>
