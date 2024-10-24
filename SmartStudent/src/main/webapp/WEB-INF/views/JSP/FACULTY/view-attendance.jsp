<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>View Attendance</title>
    <style>
        body {
            background: linear-gradient(to right, #1a1a2e, #16213e); /* Darker gradient */
            font-family: 'Segoe UI', sans-serif;
            color: white;
            margin: 0;
            padding: 20px; /* Padding around the body */
        }

        .container {
            max-width: 1000px; /* Max width for the container */
            margin: 0 auto; /* Center the container */
            background-color: rgba(0, 0, 0, 0.3); /* Semi-transparent background for the container */
            padding: 30px; /* Padding inside the container */
            border-radius: 8px; /* Rounded corners */
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.3);
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

        table {
            width: 100%; /* Make the table full width */
            border-collapse: collapse; /* Collapse borders */
            margin-top: 20px; /* Space above the table */
        }

        th, td {
            padding: 12px; /* Padding in table cells */
            text-align: left; /* Align text to the left */
            border: 1px solid #444; /* Darker border color */
        }

        th {
            background-color: white; /* Header background color */
            color: black; /* White text color for headers */
        }

        tbody tr:nth-child(even) {
            background-color: rgba(255, 255, 255, 0.1); /* Alternating row colors */
        }

        button {
            background-color: #007bff; /* Button color */
            color: white; /* White text color */
            border: none; /* No border */
            padding: 10px 15px; /* Padding for the button */
            border-radius: 4px; /* Rounded corners for the button */
            cursor: pointer; /* Pointer cursor on hover */
            font-size: 16px; /* Font size */
            margin-top: 20px; /* Space above the button */
            width: 100%; /* Full width for the button */
            transition: background-color 0.3s ease; /* Transition effect */
        }

        button:hover {
            background-color: #2a3e50; /* Darker shade on hover */
        }

        a {
            color: red; /* Link color */
            text-decoration: none; /* No underline */
        }

        a:hover {
            color: wheat; /* Underline on hover */
        }

        p {
            text-align: center; /* Centered paragraph */
            margin-top: 20px; /* Space above the paragraph */
        }
    </style>
    <script>
        // Function to toggle attendance status based on checkbox
        function toggleAttendanceStatus(checkbox, statusLabelId) {
            var statusLabel = document.getElementById(statusLabelId);
            if (checkbox.checked) {
                statusLabel.innerText = "Present";
            } else {
                statusLabel.innerText = "Absent";
            }
        }
    </script>
</head>
<body>
    <div class="container">
        <h2>Attendance for Session ID: ${sessionId}</h2>
        <hr>

        <form action="${pageContext.request.contextPath}/faculty/attendance/sessions/${sessionId}/edit" method="post">
            <table>
                <thead>
                    <tr>
                        <th>Student ID</th>
                        <th>Student Name</th>
                        <th>Attendance Status</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="attendance" items="${attendanceList}">
                        <tr>
                            <td>${attendance.student.studentId}</td>
                            <td>${attendance.student.username}</td>
                            <td>
                                <input type="checkbox" name="attendanceStatus_${attendance.attendanceId}" value="PRESENT"
                                       <c:if test="${attendance.status == 'PRESENT'}">checked</c:if>
                                       onclick="toggleAttendanceStatus(this, 'statusLabel_${attendance.attendanceId}')">
                                <span id="statusLabel_${attendance.attendanceId}">
                                    <c:choose>
                                        <c:when test="${attendance.status == 'PRESENT'}">Present</c:when>
                                        <c:otherwise>Absent</c:otherwise>
                                    </c:choose>
                                </span>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <button type="submit">Save Attendance</button>
        </form>

        <!-- Back to Sessions link -->
        <p><a href="${pageContext.request.contextPath}/faculty/attendance/sessions/map">Back to Sessions</a></p>
    </div>
</body>
</html>
