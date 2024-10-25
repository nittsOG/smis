<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Session Attendance Mapping</title>
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
            background-color: rgba(0, 0, 0, 0.5); /* Semi-transparent background for the container */
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

        form {
            margin: 0 auto;
            margin-bottom: 30px; /* Space below the form */
        }

        label {
            display: block;
            margin-bottom: 8px;
            color: #fff; /* White color for labels */
        }

        select {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box; /* Include padding and border in width */
            background-color: #fff; /* White background for select */
            color: #333; /* Dark color for text */
        }

        button {
            background-color: #007bff; /* Button color */
            color: white;
            border: none;
            padding: 10px;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
            width: 100%;
            transition: background-color 0.3s ease;
        }

        button:hover {
            background-color: #2a3e50; /* Darker shade on hover */
        }

        tbody form button{
            margin-top: 20%;
            align-items: center;
            justify-content: center;
        }

        table {
            width: 100%; /* Make the table full width */
            margin-top: 30px; /* Space above the table */
            border-collapse: collapse; /* Collapse borders */
        }

        th, td {
            padding: 12px;
            text-align: left;
            border: 1px solid #444; /* Darker border color */
        }

        th {
            background-color: white; /* Header background color */
            color: black;
        }

        tbody tr:nth-child(even) {
            background-color: rgba(255, 255, 255, 0.1); /* Alternating row colors */
        }

        p {
            text-align: center; /* Centered paragraph */
            color: red;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Select Division and Subject</h2>
        <hr>

        <form action="${pageContext.request.contextPath}/faculty/attendance/sessions/map" method="post">
            <label for="division">Division:</label>
            <select name="divisionId" id="division">
                <c:forEach var="division" items="${divisions}">
                    <option value="${division.divisionId}">${division.name}</option>
                </c:forEach>
            </select>

            <label for="subject">Subject:</label>
            <select name="subjectId" id="subject">
                <c:forEach var="subject" items="${subjects}">
                    <option value="${subject.subjectId}">${subject.name}</option>
                </c:forEach>
            </select>

            <button type="submit">Show Sessions</button>
        </form>

        <c:if test="${not empty sessionAttendanceMap}">
            <h2>Session Attendance</h2>
            <table>
                <thead>
                    <tr>
                        <th>Session ID</th>
                        <th>Session Date</th>
                        <th>Start Time</th>
                        <th>End Time</th>
                        <th>Actions</th> <!-- New Column for View/Edit -->
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="entry" items="${sessionAttendanceMap}">
                        <tr>
                            <td>${entry.key.sessionId}</td>
                            <td>${entry.key.sessionDate}</td>
                            <td>${entry.key.startTime}</td>
                            <td>${entry.key.endTime}</td>
                            <td>
                                <!-- New "View Attendance" Button -->
                                <form action="${pageContext.request.contextPath}/faculty/attendance/sessions/${entry.key.sessionId}/view" method="get">
                                    <button type="submit">View Attendance</button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
        
        <c:if test="${empty sessionAttendanceMap}">
            <p>No sessions available for the selected division and subject.</p>
        </c:if>

        <p><a href="${pageContext.request.contextPath}/faculty/dashboard" style="color: white;">Back to Dashboard</a></p>
    </div>
</body>
</html>

