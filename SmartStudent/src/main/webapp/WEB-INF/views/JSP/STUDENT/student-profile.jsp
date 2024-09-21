<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student Profile</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/STUDENT/dashboard.css">
    <style>
        /* Styling for the profile photo */
        .profile-photo {
            width: 150px;
            height: auto;
            display: block;
            margin: 10px auto;
        }
    </style>
</head>
<body>
    <!-- Sidebar Section -->
    <div id="sidebar" class="sidebar">
        <button id="close-btn" class="close-btn" onclick="toggleSidebar()"><</button>
        <a href="${pageContext.request.contextPath}/student/profile">Profile</a>
        <a href="${pageContext.request.contextPath}/student/attendance">Attendance</a>
        <a href="${pageContext.request.contextPath}/student/results">Results</a>
        <a href="${pageContext.request.contextPath}/student/timetable">Timetable</a>
        <a href="${pageContext.request.contextPath}/student/logout">Logout</a>
    </div>

    <!-- Main Content -->
    <div id="main-content" class="main-content">
        <button class="open-btn" onclick="toggleSidebar()">></button>

        <!-- Profile Information -->
        <h1>Profile</h1>

        <!-- Display Student Photo -->
        <c:choose>
            <c:when test="${photoBase64 != null}">
                <img src="data:image/jpeg;base64,${photoBase64}" alt="Student Photo" class="profile-photo" />
            </c:when>
            <c:otherwise>
                <img src="${pageContext.request.contextPath}/resources/images/default-photo.jpg" alt="Default Student Photo" class="profile-photo" />
            </c:otherwise>
        </c:choose>

        <!-- Profile Details -->
        <table class="profile-table">
            <tr>
                <th>Username:</th>
                <td>${student.username}</td>
            </tr>
            <tr>
                <th>Email:</th>
                <td>${student.email}</td>
            </tr>
            <tr>
                <th>Date of Birth:</th>
                <td>${student.dateOfBirth}</td>
            </tr>
            <tr>
                <th>Contact Number:</th>
                <td>${student.contactNumber}</td>
            </tr>
            <tr>
                <th>Guardian Name:</th>
                <td>${student.guardianName}</td>
            </tr>
            <tr>
                <th>Guardian Contact:</th>
                <td>${student.guardianContact}</td>
            </tr>
            <tr>
                <th>Nationality:</th>
                <td>${student.nationality}</td>
            </tr>
            <tr>
                <th>Enrollment Date:</th>
                <td>${student.enrollmentDate}</td>
            </tr>
            <tr>
                <th>Status:</th>
                <td>${student.status}</td>
            </tr>
            <tr>
                <th>Division:</th>
                <td>${student.division.name}</td>
            </tr>
            <tr>
                <th>Address:</th>
                <td>
                    ${student.address.street}, 
                    ${student.address.city}, 
                    ${student.address.state}, 
                    ${student.address.country} - 
                    ${student.address.zipCode}
                </td>
            </tr>
        </table>
        <a href="${pageContext.request.contextPath}/student/dashboard" class="back-link">Back to Dashboard</a>
    </div>

    <script src="${pageContext.request.contextPath}/resources/STUDENT/dashboard.js"></script>
</body>
</html>
