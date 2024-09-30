<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Manager - Edit Attendance</title>
</head>
<body>
    <h2>Edit Attendance</h2>

    <form action="${pageContext.request.contextPath}/manager/attendances/${attendance.attendanceId}/edit" method="post">
        <label for="studentId">Student:</label>
        <label for="studentId">Student ID: ${attendance.student.studentId}</label>
        <label for="studentName">Student Name: ${attendance.student.username}</label>

        <label for="status">Status:</label>
        <select name="status" id="status">
            <option value="PRESENT" ${attendance.status == 'PRESENT' ? 'selected' : ''}>Present</option>
            <option value="ABSENT" ${attendance.status == 'ABSENT' ? 'selected' : ''}>Absent</option>
        </select>

        <button type="submit">Save</button>
    </form>
</body>
</html>
