<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Dashboard</title>
    <style>
        /* Basic styles for layout */
        body {
            font-family: Arial, sans-serif;
        }
        .container {
            width: 80%;
            margin: 0 auto;
        }
        .section {
            margin-bottom: 20px;
        }
        .section h2 {
            border-bottom: 2px solid #000;
            padding-bottom: 10px;
            margin-bottom: 10px;
        }
        .section ul {
            list-style: none;
            padding: 0;
        }
        .section ul li {
            margin-bottom: 5px;
        }
        .section ul li a {
            text-decoration: none;
            color: #007BFF;
        }
        .section ul li a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Welcome, ${admin}!</h1>
        <hr>
        
        <!-- Student Management -->
        <div class="section">
            <h2>Student Management</h2>
            <ul>
                <li><a href="${pageContext.request.contextPath}/admin/students">Student List</a></li>
                <li><a href="${pageContext.request.contextPath}/admin/student-semesters">Student Semesters</a></li>
                <li><a href="${pageContext.request.contextPath}/admin/student-semester-subjects">Student Semester Subjects</a></li>
                <li><a href="${pageContext.request.contextPath}/admin/backlogs">Backlogs</a></li>
            </ul>
        </div>

        <!-- Course Management -->
        <div class="section">
            <h2>Course Management</h2>
            <ul>
                <li><a href="${pageContext.request.contextPath}/admin/courses">Courses</a></li>
                <li><a href="${pageContext.request.contextPath}/admin/semester-subjects">Semester Subjects</a></li>
                <li><a href="${pageContext.request.contextPath}/admin/subjects">Subjects List</a></li>
            </ul>
        </div>

        <!-- Faculty Management -->
        <div class="section">
            <h2>Faculty Management</h2>
            <ul>
                <li><a href="${pageContext.request.contextPath}/admin/faculty">Faculty List</a></li>
                <li><a href="${pageContext.request.contextPath}/admin/facultyDivisions">Faculty Divisions</a></li>
                <li><a href="${pageContext.request.contextPath}/admin/facultySubjects">Faculty Subjects</a></li>
            </ul>
        </div>

        <!-- Department and Division Management -->
        <div class="section">
            <h2>Department and Division Management</h2>
            <ul>
                <li><a href="${pageContext.request.contextPath}/admin/departments">Departments</a></li>
                <li><a href="${pageContext.request.contextPath}/admin/divisions">Divisions</a></li>
            </ul>
        </div>

        <!-- Attendance and Fees Management -->
        <div class="section">
            <h2>Attendance and Fees Management</h2>
            <ul>
                <li><a href="${pageContext.request.contextPath}/admin/attendances">Attendances</a></li>
                <li><a href="${pageContext.request.contextPath}/admin/fees">Fees</a></li>
            </ul>
        </div>

        <!-- Manager and Payment Management -->
        <div class="section">
            <h2>Manager and Payment Management</h2>
            <ul>
                <li><a href="${pageContext.request.contextPath}/admin/managers">Manager List</a></li>
            </ul>
        </div>

        <!-- Semester and Results Management -->
        <div class="section">
            <h2>Semester and Results Management</h2>
            <ul>
                <li><a href="${pageContext.request.contextPath}/admin/semesters">Semesters</a></li>
                <li><a href="${pageContext.request.contextPath}/admin/semester-summaries">Semester Summaries</a></li>
                <li><a href="${pageContext.request.contextPath}/admin/semester-results">Semester Results</a></li>
            </ul>
        </div>

        <!-- Timetable and Sessions Management -->
        <div class="section">
            <h2>Timetable and Sessions Management</h2>
            <ul>
                <li><a href="${pageContext.request.contextPath}/admin/timetables">Timetables</a></li>
                <li><a href="${pageContext.request.contextPath}/admin/sessions">Sessions</a></li>
            </ul>
        </div>

        <hr>
        <a href="${pageContext.request.contextPath}/admin/logout">Logout</a>
    </div>
</body>
</html>
