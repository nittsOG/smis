<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Conversation</title>
    <style>
        body {
            font-family: 'Segoe UI', sans-serif; /* Set a modern font */
            background: linear-gradient(to right, #1a1a2e, #16213e); /* Darker gradient */
            color: white; /* Dark text color */
            margin: 0; /* Remove default margin */
            padding: 20px; /* Padding around the body */
        }

        .container {
            display: flex;
            flex-direction: column;
            max-width: 800px; /* Max width for the conversation container */
            margin: auto; /* Center the container */
            background: rgba(0, 0, 0, 0.2); /* White background for the container */
            border-radius: 8px; /* Rounded corners */
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.2); /* Shadow for depth */
            padding: 20px; /* Padding inside the container */
        }

        h2 {
            font-family: 'Segoe UI', sans-serif;
            color: white;
            margin: 0;
            font-size: 2.2rem;/* Larger font size for better visibility */
            text-shadow: 1px 1px 2px rgba(0, 0, 0, 0.7), /* Main shadow */
                 0 0 25px rgba(255, 255, 255, 0.2); /* Glowing effect */
            margin-bottom: 20px; /* Space below the header */
            text-align: center; /* Centered title */
        }

        hr {
            border: none;
            height: 2px;
            background-color: white;
            width: 80%;
            margin: 20px auto;
        }

        .message {
            padding: 10px;
            margin: 5px 0;
            border-radius: 5px;
            max-width: 75%; /* Max width for messages */
            word-wrap: break-word; /* Wrap long words */
        }

        .message.faculty {
            background-color: #d4edda; /* Light green for faculty messages */
            align-self: flex-end; /* Align faculty messages to the right */
        }

        .message.student {
            background-color: #f8d7da; /* Light red for student messages */
            align-self: flex-start; /* Align student messages to the left */
        }

        h3 {
            margin-top: 20px; /* Space above the send message header */
            margin-bottom: 10px; /* Space below the send message header */
        }

        form {
            display: flex; /* Flexbox for form layout */
            flex-direction: column; /* Stack form elements vertically */
            margin-top: 10px; /* Space above the form */
        }

        textarea {
            padding: 10px; /* Padding inside the textarea */
            border-radius: 5px; /* Rounded corners */
            border: 1px solid #ccc; /* Border color */
            resize: none; /* Disable resizing */
            min-height: 100px; /* Minimum height for the textarea */
            margin-bottom: 10px; /* Space below the textarea */
        }

        button {
            padding: 10px; /* Padding inside the button */
            background-color: #007bff; /* Green background for button */
            color: white; /* White text color */
            border: none; /* Remove border */
            border-radius: 5px; /* Rounded corners */
            cursor: pointer; /* Pointer cursor on hover */
            font-size: 16px; /* Font size for button */
        }

        button:hover {
            background-color: #2a3e50; /* Darker green on hover */
        }

        a {
            text-align: center; /* Center align the back link */
            display: block; /* Make link a block element */
            margin-top: 5px; /* Space above the link */
            color: #007bff; /* Blue link color */
            text-decoration: none; /* Remove underline */
        }

        a:hover {
            color: white; /* Underline on hover */
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Conversation with Student</h2>
        <hr>
        <div class="messages">
            <c:forEach var="msg" items="${messages}">
                <div class="message ${msg.senderType == 'FACULTY' ? 'faculty' : 'student'}">
                    <strong>${msg.senderType}</strong>: ${msg.message} <br/>
                    <small>${msg.timestamp}</small>
                </div>
            </c:forEach>
        </div>

        <h3>Send a Message : </h3>
        <form action="${pageContext.request.contextPath}/faculty/chat/send" method="post">
            <input type="hidden" name="facultyId" value="${facultyId}"/>
            <input type="hidden" name="studentId" value="${studentId}"/>
            <textarea name="message" required></textarea>
            <button type="submit">Send</button>
        </form>
        <a href="${pageContext.request.contextPath}/faculty/chat/inbox">Back To Inbox</a>
    </div>
</body>
</html>
