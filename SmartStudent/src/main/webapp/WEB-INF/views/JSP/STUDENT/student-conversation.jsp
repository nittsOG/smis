<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Conversation</title>
</head>
<body>
    <h2>Conversation with Faculty</h2>
    <table border="1">
        <tr>
            <th>Sender</th>
            <th>Message</th>
            <th>Timestamp</th>
        </tr>
        <c:forEach var="msg" items="${messages}">
            <tr>
                <td>${msg.senderType}</td>
                <td>${msg.message}</td>
                <td>${msg.timestamp}</td>
            </tr>
        </c:forEach>
    </table>

    <h3>Send a Message</h3>
    <form action="${pageContext.request.contextPath}/student/chat/send" method="post">
        <input type="hidden" name="studentId" value="${studentId}"/>
        <input type="hidden" name="facultyId" value="${facultyId}"/>
        <textarea name="message" required></textarea><br/>
        <button type="submit">Send</button>
    </form>
</body>
</html>
