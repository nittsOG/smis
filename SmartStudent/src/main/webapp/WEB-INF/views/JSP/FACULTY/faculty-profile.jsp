<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Faculty Profile</title>
    <style>
        body {
            background: linear-gradient(to right, #1a1a2e, #16213e); /* Darker gradient */
            font-family: 'Segoe UI', sans-serif;
            color: white;
            margin: 0;
            padding: 20px; /* Padding around the body */
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

        .container {
            max-width: 1000px; /* Max width for the container */
            margin: 0 auto; /* Center the container */
            background-color: rgba(0, 0, 0, 0.2); /* Semi-transparent background */
            padding: 30px; /* Padding inside the container */
            border-radius: 8px; /* Rounded corners */
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.3); /* Shadow for depth */
        }

        .profile-photo {
            width: 150px; /* Fixed width for the profile photo */
            height: auto;
            display: block;
            margin: 10px auto; /* Center the photo */
            border-radius: 50%; /* Circular profile photo */
            border: 2px solid #007bff; /* Border around the photo */
        }

        h1 {
            text-align: center; /* Centered heading */
            margin-top: 20px; /* Space above the heading */
            font-size: 2rem; /* Font size for the heading */
        }

        table {
            width: 100%; /* Full width for tables */
            border-collapse: collapse; /* Collapse borders */
            margin-bottom: 20px; /* Space below tables */
        }

        th, td {
            padding: 10px; /* Padding for cells */
            text-align: left; /* Left align text */
            border: 1px solid black; /* Border for table cells */
        }

        th {
            background-color: white; /* Header background color */
            color: black; /* Header text color */
        }

        strong {
            color: #ffc107; /* Highlight color for strong text */
        }

        a {
            display: inline-block; /* Inline block for better spacing */
            background-color: #007bff; /* Button color */
            color: white; /* White text color */
            padding: 10px 15px; /* Padding for buttons */
            border-radius: 4px; /* Rounded corners */
            text-decoration: none; /* No underline */
            text-align: center; /* Centered text in links */
            transition: background-color 0.3s; /* Transition for hover effect */
            margin-right: 10px; /* Space between buttons */
        }

        a:hover {
            background-color: #2a3e50; /* Darker shade on hover */
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Profile Information</h2>
        <hr>

        <!-- Display faculty photo if available -->
        <c:if test="${not empty photoBase64}">
            <img src="data:image/jpeg;base64,${photoBase64}" alt="Faculty Photo" class="profile-photo">
        </c:if>

        <h1>Faculty Details</h1>
        <table>
            <tr>
                <th>ID</th>
                <td>${faculty.facultyId}</td>
            </tr>
            <tr>
                <th>Username</th>
                <td>${faculty.username}</td>
            </tr>
            <tr>
                <th>Email</th>
                <td>${faculty.email}</td>
            </tr>
            <tr>
                <th>Department</th>
                <td>${faculty.department.name}</td>
            </tr>
            <tr>
                <th>Position</th>
                <td>${faculty.position}</td>
            </tr>
            <tr>
                <th>Date of Birth</th>
                <td><fmt:formatDate value="${faculty.dateOfBirth}" pattern="yyyy-MM-dd" /></td>
            </tr>
            <tr>
                <th>Gender</th>
                <td>${faculty.gender}</td>
            </tr>
            <tr>
                <th>Contact Number</th>
                <td>${faculty.phone}</td>
            </tr>
            <tr>
                <th>Nationality</th>
                <td>${faculty.nationality}</td>
            </tr>
        </table>

        <h1>Address Information</h1>
        <table>
            <tr>
                <th>Street</th>
                <td>${faculty.facultyAddress.street}</td>
            </tr>
            <tr>
                <th>City</th>
                <td>${faculty.facultyAddress.city}</td>
            </tr>
            <tr>
                <th>State</th>
                <td>${faculty.facultyAddress.state}</td>
            </tr>
            <tr>
                <th>Country</th>
                <td>${faculty.facultyAddress.country}</td>
            </tr>
            <tr>
                <th>Zip Code</th>
                <td>${faculty.facultyAddress.zipCode}</td>
            </tr>
        </table>

        <a href="${pageContext.request.contextPath}/faculty/profile/edit">Edit Profile</a>
        <a href="${pageContext.request.contextPath}/faculty/dashboard">Back TO Dashboard</a>
    </div>
</body>
</html>
