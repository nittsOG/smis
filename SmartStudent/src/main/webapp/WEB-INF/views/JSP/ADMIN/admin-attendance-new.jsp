<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Admin - New Attendance</title>
</head>
<body>
    <h1>New Attendance</h1>
    <form action="${pageContext.request.contextPath}/admin/attendances/new" method="post">
        <p>
            <label for="session">Session ID:</label>
            <input type="text" id="session" name="session.sessionId" />
        </p>
        <p>
            <label for="student">Student ID:</label>
            <input type="text" id="student" name="student.studentId" />
        </p>
        <p>
            <label for="status">Status:</label>
            <select id="status" name="status">
                <option value="PRESENT">Present</option>
                <option value="ABSENT">Absent</option>
                <option value="EXCUSED">EXCUSED</option>
            </select>
        </p>
        <p><input type="submit" value="Save" /></p>
    </form>
    <a href="${pageContext.request.contextPath}/admin/attendances">Back to List</a>
</body>
</html>
