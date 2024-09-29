<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>View Attendance</title>
    <script>
        // Function to toggle attendance status based on checkbox
        function toggleAttendanceStatus(checkbox, statusLabelId) {
            var statusLabel = document.getElementById(statusLabelId);
            if (checkbox.checked) {
                statusLabel.innerText = "Present";
            } else {
                statusLabel.innerText = "Absent";
            }
        }
    </script>
</head>
<body>
    <h2>Attendance for Session ID: ${sessionId}</h2>

    <form action="${pageContext.request.contextPath}/faculty/attendance/sessions/${sessionId}/edit" method="post">
        <table border="1">
            <thead>
                <tr>
                    <th>Student ID</th>
                    <th>Student Name</th>
                    <th>Attendance Status</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="attendance" items="${attendanceList}">
                    <tr>
                        <td>${attendance.student.studentId}</td>
                        <td>${attendance.student.username}</td>
                        <td>
                            <input type="checkbox" name="attendanceStatus_${attendance.attendanceId}" value="PRESENT"
                                   <c:if test="${attendance.status == 'PRESENT'}">checked</c:if>
                                   onclick="toggleAttendanceStatus(this, 'statusLabel_${attendance.attendanceId}')">
                            <span id="statusLabel_${attendance.attendanceId}">
                                <c:choose>
                                    <c:when test="${attendance.status == 'PRESENT'}">Present</c:when>
                                    <c:otherwise>Absent</c:otherwise>
                                </c:choose>
                            </span>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <button type="submit">Save Attendance</button>
    </form>

    <!-- Back to Sessions link -->
    <p><a href="${pageContext.request.contextPath}/faculty/attendance/sessions/map">Back to Sessions</a></p>
</body>
</html>
