<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>New Session and Attendance</title>
    <style>
        body {
            font-family: 'Segoe UI', sans-serif; /* Set a clean font */
            background: linear-gradient(to right, #1a1a2e, #16213e); /* Darker gradient */ /* Light background */
            color: white;
            margin: 0;
            padding: 20px;
        }

        .container {
            background-color: rgba(0, 0, 0, 0.3); /* White container background */
            max-width: 500px; /* Set a max-width for the container */
            margin: 20px auto; /* Center container on the page */
            padding: 20px; /* Padding inside the container */
            border-radius: 10px; /* Rounded corners */
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); /* Add some shadow for depth */
        }

        h1 {
            font-family: 'Segoe UI', sans-serif;
            color: white;
            margin: 0;
            font-size: 2.2rem;/* Larger font size for better visibility */
            text-shadow: 1px 1px 2px rgba(0, 0, 0, 0.7), /* Main shadow */
                 0 0 25px rgba(255, 255, 255, 0.2); /* Glowing effect */
            margin-bottom: 20px; /* Space below the header */
            text-align: center; /* Centered title */
        }

        label {
            display: block; /* Make label a block element */
            margin-bottom: 5px; /* Space between label and input */
            font-weight: bold; /* Bold the labels */
        }

        select, input[type="text"], input[type="date"], input[type="time"] {
            width: 100%; /* Full width inputs */
            padding: 8px;
            margin-bottom: 15px; /* Space below inputs */
            border: 1px solid #ccc; /* Light border */
            border-radius: 5px; /* Rounded corners for inputs */
            box-sizing: border-box; /* Ensure padding and border are included in the element's total width */
        }

        input[type="submit"] {
            width: 100%; /* Full width button */
            background-color: #007bff; /* Blue button background */
            color: white; /* White text */
            padding: 10px;
            border: none; /* Remove border */
            border-radius: 5px; /* Rounded button */
            cursor: pointer; /* Pointer cursor on hover */
            font-size: 16px;
        }

        input[type="submit"]:hover {
            background-color: #2a3e50; /* Darker blue on hover */
        }
    </style>
</head>
<body>

    <div class="container">
        <h1>Create New Session & Mark Attendance</h1>
        <hr>
        <form action="${pageContext.request.contextPath}/faculty/attendance/sessions/newsession" method="post">
            <!-- Division Selection -->
            <label for="division">Division:</label>
            <select name="divisionId" id="division" required>
                <option value="">Select Division</option>
                <c:forEach var="division" items="${divisions}">
                    <option value="${division.divisionId}">${division.name}</option>
                </c:forEach>
            </select>

            <!-- Subject Selection -->
            <label for="subject">Subject:</label>
            <select name="subjectId" id="subject" required>
                <option value="">Select Subject</option>
                <c:forEach var="subject" items="${subjects}">
                    <option value="${subject.subjectId}">${subject.name}</option>
                </c:forEach>
            </select>

            <!-- Session Date -->
            <label for="sessionDate">Session Date:</label>
            <input type="date" name="sessionDate" id="sessionDate" required />

            <!-- Session Type -->
            <label for="sessionType">Session Type:</label>
            <select name="sessionType" id="sessionType" required>
                <option value="Lecture">Lecture</option>
                <option value="Lab">Lab</option>
                <option value="Seminar">Seminar</option>
            </select>

            <!-- Start Time -->
            <label for="startTime">Start Time:</label>
            <input type="time" name="startTime" id="startTime" required />

            <!-- End Time -->
            <label for="endTime">End Time:</label>
            <input type="time" name="endTime" id="endTime" required />

            <!-- Submit Button -->
            <input type="submit" value="Create Session and Mark Attendance" />
        </form>
    </div>

</body>
</html>
