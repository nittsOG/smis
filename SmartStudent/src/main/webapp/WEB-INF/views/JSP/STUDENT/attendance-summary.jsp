<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Attendance Summary</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/STUDENT/dashboard.css">
    <style>
        body {
            background: linear-gradient(135deg, rgba(0, 51, 102, 1), rgba(0, 153, 255, 1));
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

        

        /* main content section*/
        .main-content {
            padding: 20px;
            height: 100%; /* Full height */
             /* Full width */
            background: rgba(30, 30, 30, 0.8);
            border-radius: 10px;
            box-shadow: 0 4px 20px rgba(0, 0, 0, 0.5);
            overflow-y: auto; /* Enables vertical scrolling if necessary */
            box-sizing: border-box; /* Includes padding in height */
            transition: margin-left 0.3s ease-in-out; /* Smooth transition */
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

        .attendance-table {
            width: 100%;
            border-collapse: collapse;
            border-radius: 8px;
            overflow: hidden;
            box-shadow: 0 4px 20px rgba(0, 0, 0, 0.5);
            animation: slideIn 0.5s;
            
        }

        .attendance-table th, .attendance-table td {
            padding: 15px;
            text-align: center;
            border: 1px solid rgba(255, 255, 255, 0.2);
            transition: background 0.3s;
        }

        .attendance-table th {
            background: rgba(60, 60, 60, 0.8);
            font-size: 1.2em;
        }

        .attendance-table tr:nth-child(even) {
            background: rgba(255, 255, 255, 0.05);
        }

        .attendance-table tr:hover {
            background: rgba(255, 255, 255, 0.1);
        }

        .attendance-table td {
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

        form {
            display: flex;
            justify-content: center;
            margin: 20px 0;
        }

        label {
            margin-right: 10px;
            font-size: 1.2em;
        }

        select {
            padding: 10px;
            border-radius: 5px;
            border: none;
            background-color: rgba(255, 255, 255, 0.1);
            color: rgb(10, 177, 233);
            font-size: 1em;
            transition: background 0.3s;
        }

        select:hover {
            background-color: rgba(255, 255, 255, 0.2);
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
        <button class="open-btn" onclick="toggleSidebar()">&#x2630;</button> <!-- Open Button -->
        <h2>Attendance Summary</h2>

        <!-- Semester Filter Form -->
        <form method="get" action="${pageContext.request.contextPath}/student/attendance">
            <input type="hidden" name="studentId" value="${param.studentId}">
            
            <label for="semesterId">Select Semester:</label>
            <select name="semesterId" id="semesterId" onchange="this.form.submit()">
                <option value="">-- Select Semester --</option>
                <c:forEach var="semester" items="${semesters}">
                    <option value="${semester.semester.semesterId}" 
                            <c:if test="${semester.semester.semesterId == selectedSemesterId}">selected</c:if>>
                        ${semester.semester.name}
                    </option>
                </c:forEach>
            </select>
        </form>

        <!-- Attendance Summary Table -->
        
        <c:if test="${not empty attendanceSummary}">
            <table class="attendance-table">
                <thead>
                    <tr>
                        <th>Subject Name</th>
                        <th>Subject Code</th>
                        <th>Total Present</th>
                        <th>Total Absent</th>
                        <th>Attendance Percentage</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="subjectSummary" items="${attendanceSummary}">
                        <tr>
                            <td>${subjectSummary.value.subjectName}</td>
                            <td>${subjectSummary.value.subjectCode}</td>
                            <td>${subjectSummary.value.totalPresent}</td>
                            <td>${subjectSummary.value.totalAbsent}</td>
                            <td>${subjectSummary.value.attendancePercentage}%</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
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

