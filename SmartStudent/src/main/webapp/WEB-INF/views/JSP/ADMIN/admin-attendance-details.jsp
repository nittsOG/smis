<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Admin - Attendance Details</title>
</head>
<body>
    <h1>Attendance Details</h1>
    <p>ID: ${attendance.attendanceId}</p>
    <p>Session: ${attendance.session.id}</p>
    <p>Student: ${attendance.student.name}</p>
    <p>Status: ${attendance.status}</p>
    <a href="${pageContext.request.contextPath}/admin/attendances/${attendance.attendanceId}/edit">Edit</a>
    <a href="${pageContext.request.contextPath}/admin/attendances">Back to List</a>
</body>
</html>
