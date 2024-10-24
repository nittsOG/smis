<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Conversation</title>
    <style>
        body {

            font-family: Arial, sans-serif;
            background: linear-gradient(to right, #1a1a2e, #16213e); /* Darker gradient */
            margin: 0;
            padding: 20px;
            --border:.1rem solid rgba(0,0,0,.2);
        }

        h2 {
            color: black;
            font-family: 'Segoe UI', sans-serif;
            margin: 0;
            font-size: 2.2rem;/* Larger font size for better visibility */
            text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.5);
            margin-bottom: 20px; /* Space below the header */
            text-align: center; /* Centered title */
        }

        .main-container h2{
            border-bottom: var(--border);
            padding-bottom: 1rem;
            text-align: center;
        }

        /* Main container for all content */
        .main-container {
            max-width: 600px;
            margin: 20px auto;
            background-color: #fff;
            border-radius: 8px;
            padding: 20px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        }

        .message-container {
            display: flex;
            flex-direction: column;
        }

        .message {
            padding: 10px;
            margin: 10px 0;
            border-radius: 10px;
            max-width: 75%;
            word-wrap: break-word;
        }

        .message.faculty {
            background-color: #d4edda; /* Light green for faculty messages */
            align-self: flex-end; /* Align faculty messages to the right */
        }

        .message.student {
            background-color: #f8d7da; /* Light red for student messages */
            align-self: flex-start; /* Align student messages to the left */
        }

        .message strong {
            display: block;
            margin-bottom: 5px;
        }

        .message small {
            display: block;
            text-align: right;
            color: #666;
            font-size: 12px;
        }

        /* Form styling */
        form {
            margin-top: 20px;
        }

        textarea {
            width: 100%;
            padding: 10px;
            border-radius: 5px;
            border: 1px solid #ccc;
            font-size: 16px;
            margin-bottom: 10px;
        }

        button {
            background-color: #1a1a2e;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
        }

        button:hover {
            background-color: #2c3e50;
        }

        /* Back to Inbox styled as a button */
        .back-button {
            background-color: #e74;
            color: white;
            text-align: center;
            padding: 10px 20px;
            border-radius: 5px;
            text-decoration: none;
            font-size: 16px;
            margin-top: 20px;
        }

        .back-button:hover {
            background-color: #5a6268;
        }

        /* Responsive design */
        @media (max-width: 600px) {
            .main-container {
                padding: 15px;
            }

            h2, h3 {
                font-size: 20px;
            }

            textarea {
                font-size: 14px;
            }

            button, .back-button {
                font-size: 14px;
            }
        }
    </style>
</head>
<body>
    
    <!-- Main container for all content -->
    <div class="main-container">
        <h2>Conversation with Faculty</h2>

        <!-- Conversation Messages -->
        <div class="message-container">
            <c:forEach var="msg" items="${messages}">
                <div class="message ${msg.senderType == 'STUDENT' ? 'student' : 'faculty'}">
                    <strong>${msg.senderType}</strong>: ${msg.message} <br/>
                    <small>${msg.timestamp}</small>
                </div>
            </c:forEach>
        </div>

        <!-- Send a message form -->
        <h3>Send a Message : </h3>
        <form action="${pageContext.request.contextPath}/student/chat/send" method="post">
            <input type="hidden" name="studentId" value="${studentId}"/>
            <input type="hidden" name="facultyId" value="${facultyId}"/>
            <textarea name="message" rows="4" required></textarea><br/>
            <button type="submit">Send</button>
        </form>

        <!-- Back to Inbox button -->
        <a href="${pageContext.request.contextPath}/student/chat/inbox" class="back-button">Back to Inbox</a>
    </div>

</body>
</html>

