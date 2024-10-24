<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Student Profile</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/STUDENT/dashboard.css">

    <style>
        /* Base styling */
        body {
            margin: 0;
            font-family: 'Arial', sans-serif;
            background: linear-gradient(to right, #1a1a2e, #16213e); /* Darker gradient */
            color: #fff;
        }

        /* Sidebar styling */
        .sidebar {
            width: 250px;
            height: 100vh;
            position: fixed;
            top: 0;
            left: -300px; /* Initially hidden */
            background: #0f3460; /* Dark sidebar color */
            color: #fff;
            transition: left 0.3s ease-in-out; /* Smooth transition */
            z-index: 1000;
            padding: 20px;
            padding-top: 60px; /* Space for the close button */
            box-shadow: 4px 0 15px rgba(0, 0, 0, 0.5);
        }

        .sidebar.active {
            left: 0; 
        }

        .sidebar a {
            display: flex;
            align-items: center;
            color: #fff;
            text-decoration: none;
            padding: 15px;
            margin: 10px 0;
            border-radius: 5px;
            transition: background 0.3s, transform 0.3s;
        }

        .sidebar a i {
            margin-right: 10px; /* Adds space between the icon and text */
            font-size: 18px; /* Size of the icon */
            color: #fff; /* Customize the icon color */
            transition: transform 0.3s, color 0.3s; /* Smooth transition for icon */
        }

        .sidebar a:hover {
            background: rgba(255, 255, 255, 0.2);
            transform: translateX(5px); /* Slide effect on hover */
        }

        .sidebar a:hover i {
            transform: translateX(5px); /* Slide the icon on hover */
            color: red; /* Change icon color on hover */
        }

        /* Main content */
        .main-content {
            margin-left: 0;
            transition: margin-left 0.3s ease-in-out;
            padding: 20px;
        }

        .main-content.shifted {
            margin-left: 250px; /* Shift content when sidebar is open */
        }

        .header {
            background: #0f3460;
            color: #fff;
            padding: 10px;
            display: flex;
            justify-content: center;
            align-items: center;
            position: sticky;
            top: 0;
            z-index: 999;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.3);
        }

        /* Open button at side */
        .open-btn {
            position: absolute;
            left: 15px;
            background: #1a1a2e;
            color: white;
            border: none;
            padding: 10px 15px;
            border-radius: 5px;
            cursor: pointer;
            transition: background 0.3s, transform 0.3s;
        }

        .open-btn:hover {
            background: white;
            color: #1a1a2e;
            transform: scale(1.05);
        }

        h1 {
            font-family: 'Segoe UI', sans-serif;
            color: white;
            margin: 0;
            font-size: 2.2rem;/* Larger font size for better visibility */
            text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.5);
            margin-bottom: 20px; /* Space below the header */
            text-align: center; /* Centered title */
            align-items: center;
            justify-content: center;
        }

        /* Close button with space */
        .close-btn {
            background: transparent;
            border: none;
            color: #fff;
            font-size: 30px;
            cursor: pointer;
            position: absolute;
            top: 20px;
            right: 20px;
            transition: transform 0.3s;
        }

        .close-btn:hover {
            transform: scale(1.2);
        }

        /* Profile container */
        .profile-container {
            margin-top: 30px;
            background: rgba(255, 255, 255, 0.9);
            border-radius: 10px;
            box-shadow: 0 4px 20px rgba(0, 0, 0, 0.2);
            padding: 20px;
            animation: slideIn 0.5s ease forwards;
        }

        @keyframes slideIn {
            from {
                transform: translateY(-20px);
                opacity: 0;
            }
            to {
                transform: translateY(0);
                opacity: 1;
            }
        }

        /* Profile photo */
        .photo-container {
            display: flex;
            justify-content: center;
        }

        .profile-photo {
            width: 180px;
            height: 180px;
            border-radius: 50%;
            margin-bottom: 20px;
            border: 3px solid #ffcd3c; /* Yellow border */
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.3);
            transition: transform 0.3s, border-color 0.3s;
        }

        .profile-photo:hover {
            transform: scale(1.1); /* Zoom effect */
            border-color: #ffcd3c;
        }

        /* Profile table */
        .profile-table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
            color: #333;
        }

        .profile-table th, .profile-table td {
            padding: 10px;
            border-bottom: 1px solid #ddd;
            width: 50%;
        }

        .profile-table th {
            width: 10%;
            text-align: left;
            color: #1a1a2e;
            background: rgba(25, 25, 25, 0.1);
        }

        /* Back button */
        .back-link {
            display: inline-block;
            margin: 20px auto;
            padding: 10px 20px;
            background: #1a1a2e;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            transition: background 0.3s, transform 0.3s;
        }

        .back-link:hover {
            background: white;
            color: #1a1a2e;
            transform: translateY(-2px);
        }

        /* Media queries for responsiveness */
        @media (max-width: 768px) {
            .sidebar {
                width: 200px;
            }

            .main-content.shifted {
                margin-left: 200px;
            }

            .profile-photo {
                width: 150px;
                height: 150px;
            }
        }

        @media (max-width: 480px) {
            .sidebar {
                width: 100%;
                height: auto;
                position: relative;
            }

            .main-content.shifted {
                margin-left: 0;
            }

            .profile-photo {
                width: 120px;
                height: 120px;
            }
        }
    </style>
</head>

<body>

    <!-- Sidebar Section -->
    <div id="sidebar" class="sidebar">
        <button id="close-btn" class="close-btn" onclick="toggleSidebar()">×</button>
        <div class="navbar">
            <a href="${pageContext.request.contextPath}/student/profile"><i class="fas fa-user"></i> Profile</a>
            <a href="${pageContext.request.contextPath}/student/attendance"><i class="fas fa-calendar-alt"></i> Attendance</a>
            <a href="${pageContext.request.contextPath}/student/results"><i class="fas fa-file-alt"></i> Results</a>
            <a href="${pageContext.request.contextPath}/student/timetable"><i class="fas fa-clock"></i> Timetable</a>
            <a href="${pageContext.request.contextPath}/student/fees"><i class="fas fa-dollar-sign"></i> Fees</a>
            <a href="${pageContext.request.contextPath}/student/logout"><i class="fas fa-sign-out-alt"></i> Logout</a>
        </div>
    </div>

    <!-- Main Content -->
    <div id="main-content" class="main-content">
        <div class="header">
            <button class="open-btn" onclick="toggleSidebar()">&#x2630;</button>
            <h1>Student Profile</h1>
        </div>

        <!-- Profile Information -->
        <div class="profile-container">
            <div class="photo-container">
                <!-- Student Photo -->
                <!-- <img src="/assets/photo.jpg" alt="Default Student Photo" class="profile-photo"> Replace with dynamic source as needed -->

                <c:choose>
                    <c:when test="${photoBase64 != null}">
                        <img src="data:image/jpeg;base64,${photoBase64}" alt="Student Photo" class="profile-photo">
                    </c:when>
                    <!-- <c:otherwise>
                        <img src="${pageContext.request.contextPath}/resources/images/default-photo.jpg" alt="Default Student Photo" class="profile-photo">
                    </c:otherwise>
                </c:choose> -->
            </div>

            <!-- Profile Details -->
            <table class="profile-table">
                <!-- Profile details table here -->
                <table class="profile-table">
                    <tr>
                        <th>ID:</th>
                        <td>${student.studentId}</td>
                    </tr>
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
                        <th>Gender:</th>
                        <td>${student.gender}</td>
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
                        <td>${student.address.street}, ${student.address.city}, ${student.address.state}, ${student.address.country} - ${student.address.zipCode}</td>
                    </tr>
                </table>
    
                <a href="${pageContext.request.contextPath}/student/dashboard" class="back-link">Back to Dashboard</a>
            </div>
        </div>
    </table>

        </div>
    </div>

    <script src="${pageContext.request.contextPath}/resources/STUDENT/dashboard.js"></script>
    <script>
        function toggleSidebar() {
            const sidebar = document.querySelector('.sidebar');
            const mainContent = document.querySelector('.main-content');
            sidebar.classList.toggle('active');
            mainContent.classList.toggle('shifted');
        }
    </script>

</body>
</html>

