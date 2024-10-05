<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Conversation</title>
    <style>
        .container {
            display: flex;
            flex-direction: column;
            max-width: 600px;
            margin: auto;
        }
        .message {
            padding: 10px;
            margin: 5px 0;
            border-radius: 5px;
            max-width: 75%;
        }
        .message.faculty {
            background-color: #d4edda; /* Light green for faculty messages */
            align-self: flex-end; /* Align faculty messages to the right */
        }
        .message.student {
            background-color: #f8d7da; /* Light red for student messages */
            align-self: flex-start; /* Align student messages to the left */
        }
    </style>
</head>
<body>
    <h2>Conversation with Faculty</h2>
    <div class="container">
        <c:forEach var="msg" items="${messages}">
            <div class="message ${msg.senderType == 'STUDENT' ? 'student' : 'faculty'}">
                <strong>${msg.senderType}</strong>: ${msg.message} <br/>
                <small>${msg.timestamp}</small>
            </div>
        </c:forEach>
    </div>

    <h3>Send a Message</h3>
    <form action="${pageContext.request.contextPath}/student/chat/send" method="post">
        <input type="hidden" name="studentId" value="${studentId}"/>
        <input type="hidden" name="facultyId" value="${facultyId}"/>
        <textarea name="message" required></textarea><br/>
        <button type="submit">Send</button>
    </form>
    <a href="${pageContext.request.contextPath}/student/chat/inbox">Back To inbox</a>
</body>
</html>
