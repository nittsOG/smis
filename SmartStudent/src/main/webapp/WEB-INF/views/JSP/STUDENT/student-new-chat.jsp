<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>New Chat</title>
</head>
<body>
    <h2>New Chat for Student: ${student.username}</h2>
    <form action="${pageContext.request.contextPath}/student/chat/send" method="post">
        <input type="hidden" name="studentId" value="${student.studentId}"/>
        <label for="facultyId">Faculty ID:</label>
        <input type="text" id="facultyId" name="facultyId" required><br/>
        <label for="message">Message:</label>
        <textarea id="message" name="message" required></textarea><br/>
        <button type="submit">Send</button>
    </form>
</body>
</html>
