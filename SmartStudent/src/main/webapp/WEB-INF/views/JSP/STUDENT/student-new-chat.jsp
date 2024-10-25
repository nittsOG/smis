<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>New Chat</title>
    <style>
        /* General Styles */
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
            background: linear-gradient(to right, #1a1a2e, #16213e); /* Darker gradient */
        }

        /* Chat Box container */
        .chat-container {
            max-width: 500px;
            margin: 20px auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            text-align: center;
        }

        h2 {
            font-family: 'Segoe UI', sans-serif;
            color: black;
            margin: 0;
            font-size: 2.2rem;/* Larger font size for better visibility */
            text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.5);
            margin-bottom: 20px; /* Space below the header */
            text-align: center; /* Centered title */
        }

        .chat-button {
            background-color: #1a1a2e;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 8px;
            cursor: pointer;
            font-size: 18px;
        }

        .chat-button:hover {
            background-color: #2c3e50;
        }

        /* Hidden form */
        .chat-form-container {
            display: none;
            margin-top: 20px;
        }

        label {
            font-weight: bold;
            display: block;
            margin-top: 10px;
        }

        input[type="text"], 
        textarea {
            width: 100%;
            padding: 10px;
            margin-top: 5px;
            border: 1px solid #ccc;
            border-radius: 4px;
            font-size: 16px;
        }

        button[type="submit"] {
            background-color: #1a1a2e;
            color: white;
            padding: 10px 20px;
            margin-top: 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
            width: 100%;
        }

        button[type="submit"]:hover {
            background-color: #2c3e50;
        }

        /* Responsive Design */
        @media (max-width: 600px) {
            body {
                padding: 10px;
            }

            h2 {
                font-size: 20px;
            }

            input[type="text"], 
            textarea {
                font-size: 14px;
            }

            button[type="submit"] {
                font-size: 14px;
            }
        }
    </style>

    <script>
        function toggleChatForm() {
            // Show form and hide chat button
            var formContainer = document.getElementById('chat-form');
            var chatButton = document.getElementById('chat-button');
            formContainer.style.display = "block";
            chatButton.style.display = "none";
        }
    </script>
</head>
<body>
    
    <!-- Chat Box Container -->
    <div class="chat-container">
        <h2>New Chat for Student: ${student.username}</h2>
        <button id="chat-button" class="chat-button" onclick="toggleChatForm()">Start Chat</button>

        <!-- Hidden Chat Form -->
        <div id="chat-form" class="chat-form-container">
            <form action="${pageContext.request.contextPath}/student/chat/send" method="post">
                <input type="hidden" name="studentId" value="${student.studentId}"/>
                <label for="facultyId">Faculty ID:</label>
                <input type="text" id="facultyId" name="facultyId" required><br/>
                <label for="message">Message:</label>
                <textarea id="message" name="message" rows="5" required></textarea><br/>
                <button type="submit">Send</button>
            </form>
        </div>
    </div>

</body>
</html>

