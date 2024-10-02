<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Student Inbox</title>
</head>
<body>
    <h2>Inbox for Student: ${student.username}</h2>
    <table border="1">
        <tr>
            <th>Faculty</th>
            <th>Last Message</th>
            <th>Date</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="msg" items="${inbox}">
            <tr>
                <td>${msg.faculty.username}</td>
                <td>${msg.message}</td>
                <td>${msg.timestamp}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/student/chat/conversation?studentId=${msg.student.studentId}&facultyId=${msg.faculty.facultyId}">View</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
