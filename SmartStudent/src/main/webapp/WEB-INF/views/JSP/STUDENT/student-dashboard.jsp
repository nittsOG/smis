<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Dashboard</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/STUDENT/dashboard.css">
    <style>
                /* Base styling */
                body {
                    margin: 0;
                    font-family: 'Arial', sans-serif;
                    background: linear-gradient(135deg, rgba(30, 30, 30, 1), rgba(0, 51, 102, 1));
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
                    background: #0f3460;
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
        
        

h1 {
    font-size: 2.5rem;/* Larger font size for better visibility */
    text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.5);
    margin-bottom: 20px; /* Space below the header */
    text-align: center; /* Centered title */
}

/* Profile photo styling */

.profile-photo {
    width: 180px;
    height: 180px;
    border-radius: 50%;
    margin-bottom: 20px;
    border: 3px solid white; /* Yellow border */
    box-shadow: 0 2px 10px rgba(0, 0, 0, 0.3);
    transition: transform 0.3s, border-color 0.3s;
    display: flex;
    justify-content: center;
    align-items: center;
    margin: auto;
}

.profile-photo:hover {
    transform: scale(1.1); /* Zoom effect */
    border-color: red;
}

/* Button container styling */
.btn-container {
    display: flex;
    justify-content: center; /* Center the buttons */
    gap: 20px; /* Space between buttons */
    margin-top: 20px; /* Space above buttons */
}

/* Button styling */
.profile-btn, .inbox-btn {
    background: #1a1a2e; /* Button background color */
    color: #fff; /* Text color */
    border: none; /* Remove border */
    padding: 10px 20px; /* Padding for buttons */
    border-radius: 5px; /* Rounded corners */
    cursor: pointer; /* Pointer cursor */
    transition: background 0.3s, transform 0.3s; /* Transition effects */
    font-size: 1.2rem; /* Font size for buttons */
}

.profile-btn:hover, .inbox-btn:hover {
    background: rgba(255, 255, 255, 0.2); /* Light hover effect */
    transform: scale(1.05); /* Slightly enlarge on hover */
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
        <h1>Welcome, ${student.username}</h1>
        <img src="data:image/jpeg;base64,${photoBase64}" alt="Student Photo" class="profile-photo">
        <hr>
        <div class="btn-container">
            <button class="profile-btn" onclick="window.location.href='${pageContext.request.contextPath}/student/profile'">Go to Profile</button>
            <button class="inbox-btn" onclick="window.location.href='${pageContext.request.contextPath}/student/chat/inbox'">Inbox</button>
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
