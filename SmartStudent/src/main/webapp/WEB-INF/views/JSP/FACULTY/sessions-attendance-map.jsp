<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Session Attendance Mapping</title>
</head>
<body>
    <h2>Select Division and Subject</h2>

    <form action="${pageContext.request.contextPath}/faculty/attendance/sessions/map" method="post">
        <label for="division">Division:</label>
        <select name="divisionId" id="division">
            <c:forEach var="division" items="${divisions}">
                <option value="${division.divisionId}">${division.name}</option>
            </c:forEach>
        </select>

        <label for="subject">Subject:</label>
        <select name="subjectId" id="subject">
            <c:forEach var="subject" items="${subjects}">
                <option value="${subject.subjectId}">${subject.name}</option>
            </c:forEach>
        </select>

        <button type="submit">Show Sessions</button>
    </form>

    <c:if test="${not empty sessionAttendanceMap}">
        <h2>Session Attendance</h2>
        <table border="1">
            <thead>
                <tr>
                    <th>Session ID</th>
                    <th>Session Date</th>
                    <th>Start Time</th>
                    <th>End Time</th>
                    <!-- <th>Attendance</th> -->
                    <th>Actions</th> <!-- New Column for View/Edit -->
                </tr>
            </thead>
            <tbody>
                <c:forEach var="entry" items="${sessionAttendanceMap}">
                    <tr>
                        <td>${entry.key.sessionId}</td>
                        <td>${entry.key.sessionDate}</td>
                        <td>${entry.key.startTime}</td>
                        <td>${entry.key.endTime}</td>
<%--                         <td>
                            <ul>
                                <c:forEach var="attendance" items="${entry.value}">
                                    <li>${attendance.student.username}: ${attendance.status}</li>
                                </c:forEach>
                            </ul>
                        </td> --%>
                        <td>
                            <!-- New "View Attendance" Button -->
                            <form action="${pageContext.request.contextPath}/faculty/attendance/sessions/${entry.key.sessionId}/view" method="get">
                                <button type="submit">View Attendance</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>
    <c:if test="${empty sessionAttendanceMap}">
        <p>No sessions available for the selected division and subject.</p>
    </c:if>
</body>
</html>
