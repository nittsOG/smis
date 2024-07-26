<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Admin - Edit Attendance</title>
</head>
<body>
    <h1>Edit Attendance</h1>
    <form action="${pageContext.request.contextPath}/admin/attendances/${attendance.attendanceId}/edit" method="post">
        <input type="hidden" name="attendanceId" value="${attendance.attendanceId}" />
        <p>
            <label for="session">Session ID:</label>
            <input type="text" id="session" name="session.id" value="${attendance.session.sessionId}" />
        </p>
        <p>
            <label for="student">Student ID:</label>
            <input type="text" id="student" name="student.id" value="${attendance.student.studentId}" />
        </p>
        <p>
            <label for="status">Status:</label>
            <select id="status" name="status">
                <option value="PRESENT" ${attendance.status == 'PRESENT' ? 'selected' : ''}>Present</option>
                <option value="ABSENT" ${attendance.status == 'ABSENT' ? 'selected' : ''}>Absent</option>
                 <option value="EXCUSED" ${attendance.status == 'EXCUSED' ? 'selected' : ''}>Absent</option>
            </select>
        </p>
        <p><input type="submit" value="Save" /></p>
    </form>
    <a href="${pageContext.request.contextPath}/admin/attendances">Back to List</a>
</body>
</html>
