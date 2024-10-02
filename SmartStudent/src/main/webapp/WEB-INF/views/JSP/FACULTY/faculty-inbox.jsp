<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Faculty Inbox</title>
</head>
<body>
    <h2>Inbox for Faculty: ${faculty.username}</h2>
    <table border="1">
        <tr>
            <th>Student</th>
            <th>Last Message</th>
            <th>Date</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="msg" items="${inbox}">
            <tr>
                <td>${msg.student.username}</td>
                <td>${msg.message}</td>
                <td>${msg.timestamp}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/faculty/chat/conversation?studentId=${msg.student.studentId}&facultyId=${faculty.facultyId}">View</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <p><a href="${pageContext.request.contextPath}/faculty/chat/new">New Chat</a></p>
</body>
</html>
