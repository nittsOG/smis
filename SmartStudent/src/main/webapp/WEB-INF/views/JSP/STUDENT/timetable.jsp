<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Timetable</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/STUDENT/dashboard.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <style>
       

        body {
            background: linear-gradient(135deg, rgba(0, 51, 102, 1), rgba(0, 153, 255, 1));
            color: #ffffff;
            font-family: 'Arial', sans-serif;
            margin: 0;
            padding: 0;
            height: 100vh;
            overflow: hidden;
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

        /* Main Content */
        .main-content {
            padding: 20px;
            height: 100%;
            background: rgba(30, 30, 30, 0.8);
            border-radius: 10px;
            box-shadow: 0 4px 20px rgba(0, 0, 0, 0.5);
            transition: margin-left 0.3s;
            overflow-y: auto;
            box-sizing: border-box;
        }

        .main-content.shifted {
            margin-left: 250px;
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


        h2 {
            text-align: center;
            color: white;
            font-size: 2.5em;
            font-weight: 600;
            margin-bottom: 20px;
            text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.5);
        }

        .timetable-table {
            width: 100%;
            border-collapse: collapse;
            border-radius: 8px;
            overflow: hidden;
            box-shadow: 0 4px 20px rgba(0, 0, 0, 0.5);
            animation: slideIn 0.5s;
        }

        .timetable-table th, .timetable-table td {
            padding: 15px;
            text-align: center;
            border: 1px solid rgba(255, 255, 255, 0.3);
            transition: background 0.3s;
        }

        .timetable-table th {
            background-color: rgba(60, 60, 60, 0.8);
            color: white;
            font-size: 1.2em;
            font-weight: 600;
        }

        .timetable-table tr:nth-child(even) {
            background-color: rgba(255, 255, 255, 0.05);
        }

        .timetable-table tr:hover {
            background-color: rgba(255, 255, 255, 0.1);
        }

        .timetable-table td {
            font-size: 1em;
        }

        @keyframes fadeIn {
            from { opacity: 0; }
            to { opacity: 1; }
        }

        @keyframes slideIn {
            from { transform: translateY(-20px); opacity: 0; }
            to { transform: translateY(0); opacity: 1; }
        }

        /* Responsive */
        @media screen and (max-width: 768px) {
            .sidebar {
                width: 200px;
            }

            .main-content.shifted {
                margin-left: 200px;
            }
        }

        @media screen and (max-width: 480px) {
            .sidebar {
                width: 100%;
                position: static;
            }

            .main-content {
                margin-left: 0;
            }
        }
    </style>
</head>
<body>

<div class="sidebar" id="sidebar">
    <button class="close-btn" onclick="toggleSidebar()">×</button>
    <div class="navbar">
        <a href="${pageContext.request.contextPath}/student/profile"><i class="fas fa-user"></i> Profile</a>
        <a href="${pageContext.request.contextPath}/student/attendance"><i class="fas fa-calendar-alt"></i> Attendance</a>
        <a href="${pageContext.request.contextPath}/student/results"><i class="fas fa-file-alt"></i> Results</a>
        <a href="${pageContext.request.contextPath}/student/timetable"><i class="fas fa-clock"></i> Timetable</a>
        <a href="${pageContext.request.contextPath}/student/fees"><i class="fas fa-dollar-sign"></i> Fees</a>
        <a href="${pageContext.request.contextPath}/student/logout"><i class="fas fa-sign-out-alt"></i> Logout</a>
    </div>
</div>

<div id="main-content" class="main-content">
    <button class="open-btn" onclick="toggleSidebar()">&#x2630;</button>
    <h2>Your Timetable</h2>
    <table class="timetable-table">
        <thead>
            <tr>
                <th>Day</th>
                <th>Start Time</th>
                <th>End Time</th>
                <th>Subject</th>
                <th>Faculty</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="timetable" items="${timetable}">
                <tr>
                    <td>${timetable.dayOfWeek}</td>
                    <td>${timetable.startTime}</td>
                    <td>${timetable.endTime}</td>
                    <td>${timetable.subject.name}</td>
                    <td>${timetable.faculty.username}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
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

