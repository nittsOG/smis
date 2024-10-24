<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Student Fees</title>
<link rel="stylesheet" type="text/css"href="${pageContext.request.contextPath}/resources/STUDENT/dashboard.css">
<style>
    body {
        background: linear-gradient(135deg, rgba(0, 51, 102, 1), rgba(0, 102, 204, 1));
        color: #ffffff;
        font-family: 'Arial', sans-serif;
        margin: 0;
        padding: 0;
        height: 100vh; /* Full height of the viewport */
        overflow: hidden; /* Prevents scrollbar on the right side */
    }
        /* Sidebar Styling */
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

        /* Button Styling */
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

    .main-content {
        padding: 20px;
        height: 100%; /* Full height */
        background: rgba(30, 30, 30, 0.8);
        border-radius: 10px;
        box-shadow: 0 4px 20px rgba(0, 0, 0, 0.5);
        overflow-y: auto; /* Enables vertical scrolling if necessary */
        box-sizing: border-box; /* Includes padding in height */ 
        transition: margin-left 0.3s ease-in-out; /* Smooth transition *//* Smooth transition */
    }

    .main-content.shifted {
        margin-left: 250px;
    }


    h2 {
        text-align: center;
        margin-bottom: 20px;
        font-size: 2.5em;
        text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.5);
        animation: fadeIn 0.5s;
    }

    /* Responsive Styles */
    @media (max-width: 768px) {
        .sidebar {
            width: 20rem;
        }

        .main-content {
            margin-left: 20rem;
            width: calc(100% - 20rem);
        }

    }

     /* Fees Table Styles */
     .fees-table {
        width: 100%;
        border-collapse: collapse;
        border-radius: 8px;
        overflow: hidden;
        box-shadow: 0 4px 20px rgba(0, 0, 0, 0.5);
        animation: slideIn 0.5s;
        margin-bottom: 20px; /* Space between tables */
    }
    
    .fees-table th, .fees-table td {
        padding: 15px;
        text-align: center;
        border: 1px solid rgba(255, 255, 255, 0.2);
        transition: background 0.3s;
    }
    
    .fees-table th {
        background: rgba(60, 60, 60, 0.8);
        font-size: 1.2em;
    }
    
    .fees-table tr:nth-child(even) {
        background: rgba(255, 255, 255, 0.05);
    }
    
    .fees-table tr:hover {
        background: rgba(255, 255, 255, 0.1);
    }
    
    /* No Fees Found Message */
    .main-content p {
        font-size: 1.2rem;
        color: #ff4747; /* Red color */
        text-align: center;
        margin-top: 3rem;
    }

          
</style>
</head>
<body>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">

    <!-- Sidebar Section -->
    <div id="sidebar" class="sidebar">
        <span class="close-btn" onclick="toggleSidebar()">×</span>
        <!-- <div class="profile">
            <img src="${pageContext.request.contextPath}/resources/images/student-photo.jpg" class="profile-photo" alt="Profile Photo">
            <h3>${student.username}</h3>
            <span>Student</span>
        </div> -->
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
		<button class="open-btn" onclick="toggleSidebar()">&#x2630;</button>
		<!-- Open Button -->

        <!--Fees section -->
		<h2>Fees Status</h2>
		<c:choose>
			<c:when test="${not empty fees}">
				<table class="fees-table">
					<thead>
						<tr>
							<th>Semester</th>
							<th>Total Amount</th>
							<th>Paid Amount</th>
							<th>Due Date</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="fee" items="${fees}">
							<tr>
								<td>${fee.studentSemester.semester.name}</td>
								<!-- Accessing semester name via studentSemester -->
								<td>${fee.totalAmount}</td>
								<td>${fee.paidAmount}</td>
								<td>${fee.dueDate}</td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
			</c:when>
			<c:otherwise>
				<p>No fees found for this student.</p>
			</c:otherwise>
		</c:choose>

	</div>


	<script
		src="${pageContext.request.contextPath}/resources/STUDENT/dashboard.js"></script>
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

