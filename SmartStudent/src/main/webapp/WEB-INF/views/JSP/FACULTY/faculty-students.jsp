<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Student List</title>
    <style>
        body {
            background: linear-gradient(to right, #1a1a2e, #16213e); /* Darker gradient */
            font-family: 'Segoe UI', sans-serif;
            color: white;
            margin: 0;
            padding: 20px; /* Padding around the body */
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
            text-decoration: underline;
        }

        .container {
            max-width: 1000px; /* Max width for the container */
            margin: 0 auto; /* Center the container */
            background-color: rgba(0, 0, 0, 0.5); /* Semi-transparent background */
            padding: 20px; /* Padding inside the container */
            border-radius: 8px; /* Rounded corners */
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.3); /* Shadow for depth */
        }

        .scrollable-table {
            max-height: 400px; /* Max height for scrollable area */
            overflow-y: auto; /* Scrollbar for vertical overflow */
            margin-top: 20px; /* Space above the table */
        }

        table {
            width: 100%; /* Full width for the table */
            border-collapse: collapse; /* Collapse borders */
            margin-bottom: 20px; /* Space below the table */
        }

        th, td {
            padding: 12px; /* Padding for table cells */
            text-align: left; /* Left-align text */
            border: 1px solid #ccc; /* Light border */
        }

        th {
            background-color: white; /* Header background color */
            color: black; /* Header text color */
        }

        tr:nth-child(even) {
            background-color: rgba(255, 255, 255, 0.1); /* Zebra striping */
        }

        .action-buttons {
            display: flex;
            gap: 8px; /* Space between buttons */
        }

        .error-message {
            color: red;
            margin-bottom: 20px;
            padding: 10px;
            text-align: center;
            align-items: center;
            justify-content: center;
             /* Semi-transparent error background */
        }

        form {
            display: flex; /* Flexbox for form layout */
            justify-content: space-between; /* Space between elements */
            align-items: center; /* Center align items */
            margin-bottom: 20px; /* Space below the form */
        }

        select {
            padding: 8px; /* Padding for select box */
            border: 1px solid #ccc; /* Border for select box */
            border-radius: 4px; /* Rounded corners for select */
            background-color: white; /* Background for select */
            color: black; /* Text color */
        }

        button {
            background-color: white; /* Green button */
            color: black; /* Button text color */
            padding: 10px 15px; /* Button padding */
            border: none; /* No border */
            border-radius: 4px; /* Rounded corners */
            cursor: pointer; /* Pointer on hover */
        }

        button:hover {
            background-color: #2a3e50; /* Darker green on hover */
            color: white;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Students - List</h1>

        <!-- Error Notification -->
        <c:if test="${not empty error}">
            <div class="error-message">${error}</div>
        </c:if>

        <form method="GET" action="${pageContext.request.contextPath}/faculty/students">
            <label for="division">Filter by Division:</label>
            <select id="division" name="divisionId">
                <option value="">--All--</option>
                <c:forEach var="division" items="${Divisions}">
                    <option value="${division.divisionId}"
                        <c:if test="${division.divisionId == selectedDivisionId}">selected</c:if>>
                        ${division.name}</option>
                </c:forEach>
            </select>
            <button type="submit">Search</button>
        </form>

        <div class="scrollable-table">
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Username</th>
                        <th>Email</th>
                        <th>Division</th>
                        <th>Department</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="student" items="${students}">
                        <tr>
                            <td>${student.studentId}</td>
                            <td>${student.username}</td>
                            <td>${student.email}</td>
                            <td>${student.division.name}</td>
                            <td>${student.division.department.name}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>
