<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Manager Dashboard</title>
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
                <li><a href="${pageContext.request.contextPath}/manager/students">Student List</a></li>
                <li><a href="${pageContext.request.contextPath}/manager/student-semesters">Student Semesters</a></li>
                <li><a href="${pageContext.request.contextPath}/manager/student-semester-subjects">Student Semester Subjects</a></li>
                <li><a href="${pageContext.request.contextPath}/manager/backlogs">Backlogs</a></li>
            </ul>
        </div>

<%--         <!-- Course Management -->
        <div class="section">
            <h2>Course Management</h2>
            <ul>
                <li><a href="${pageContext.request.contextPath}/manager/courses">Courses</a></li>
                <li><a href="${pageContext.request.contextPath}/manager/semester-subjects">Semester Subjects</a></li>
                <li><a href="${pageContext.request.contextPath}/manager/subjects">Subjects List</a></li>
            </ul>
        </div> --%>

        <!-- Faculty Management -->
        <div class="section">
            <h2>Faculty Management</h2>
            <ul>
                <li><a href="${pageContext.request.contextPath}/manager/faculty">Faculty List</a></li>
                <li><a href="${pageContext.request.contextPath}/manager/facultyDivisions">Faculty Divisions</a></li>
                <li><a href="${pageContext.request.contextPath}/manager/facultySubjects">Faculty Subjects</a></li>
            </ul>
        </div>

<%--         <!-- Department and Division Management -->
        <div class="section">
            <h2>Department and Division Management</h2>
            <ul>
                <li><a href="${pageContext.request.contextPath}/manager/departments">Departments</a></li>
                <li><a href="${pageContext.request.contextPath}/manager/divisions">Divisions</a></li>
            </ul>
        </div> --%>

        <!-- Attendance and Fees Management -->
        <div class="section">
            <h2>Attendance and Fees Management</h2>
            <ul>
                <li><a href="${pageContext.request.contextPath}/manager/attendances">Attendances</a></li>
                <li><a href="${pageContext.request.contextPath}/manager/fees">Fees</a></li>
            </ul>
        </div>

<%--         <!-- Manager and Payment Management -->
        <div class="section">
            <h2>Manager and Payment Management</h2>
            <ul>
                <li><a href="${pageContext.request.contextPath}/manager/managers">Manager List</a></li>
            </ul>
        </div> --%>

        <!-- Semester and Results Management -->
        <div class="section">
            <h2>Semester and Results Management</h2>
            <ul>
              <%--   <li><a href="${pageContext.request.contextPath}/manager/semesters">Semesters</a></li> --%>
                <li><a href="${pageContext.request.contextPath}/manager/semester-summaries">Semester Summaries</a></li>
                <li><a href="${pageContext.request.contextPath}/manager/semester-results">Semester Results</a></li>
            </ul>
        </div>

        <!-- Timetable and Sessions Management -->
        <div class="section">
            <h2>Timetable and Sessions Management</h2>
            <ul>
                <li><a href="${pageContext.request.contextPath}/manager/timetables">Timetables</a></li>
                <li><a href="${pageContext.request.contextPath}/manager/sessions">Sessions</a></li>
            </ul>
        </div>

        <hr>
        <a href="${pageContext.request.contextPath}/manager/logout">Logout</a>
    </div>
</body>
</html>
