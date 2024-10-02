<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>New Chat</title>
</head>
<body>
    <h2>New Chat for Faculty: ${faculty.username}</h2>
    <form action="${pageContext.request.contextPath}/faculty/chat/send" method="post">
        <input type="hidden" name="facultyId" value="${faculty.facultyId}"/>
        <label for="studentId">Student ID:</label>
        <input type="text" id="studentId" name="studentId" required><br/>
        <label for="message">Message:</label>
        <textarea id="message" name="message" required></textarea><br/>
        <button type="submit">Send</button>
    </form>
</body>
</html>
