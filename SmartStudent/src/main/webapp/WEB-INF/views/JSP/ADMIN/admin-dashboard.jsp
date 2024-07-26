<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Dashboard</title>
</head>
<body>
    <h1>Welcome, ${admin}!</h1>
    <hr>
    <ul>
        <li><a href="${pageContext.request.contextPath}/admin/students">Student List</a></li>
        <li><a href="${pageContext.request.contextPath}/admin/courses">Courses</a></li>
        <li><a href="${pageContext.request.contextPath}/admin/attendances">Attendances</a></li>
        <li><a href="${pageContext.request.contextPath}/admin/departments">Departments</a></li>
        <li><a href="${pageContext.request.contextPath}/admin/divisions">Divisions</a></li>
        <li><a href="${pageContext.request.contextPath}/admin/faculty/list">Faculty List</a></li>
        <li><a href="${pageContext.request.contextPath}/admin/facultyDivisions">Faculty Divisions</a></li>
        <li><a href="${pageContext.request.contextPath}/admin/facultySubjects">Faculty Subjects</a></li>
        <li><a href="${pageContext.request.contextPath}/admin/fees">Fees</a></li>
        <li><a href="${pageContext.request.contextPath}/admin/manager/list">Manager List</a></li>
        <li><a href="${pageContext.request.contextPath}/admin/payments">Payments</a></li>
        <li><a href="${pageContext.request.contextPath}/admin/semesters">Semesters</a></li>
        <li><a href="${pageContext.request.contextPath}/admin/semester-subjects">Semester Subjects</a></li>
        <li><a href="${pageContext.request.contextPath}/admin/student-semesters">Student Semesters</a></li>
        <li><a href="${pageContext.request.contextPath}/admin/student-semester-subjects">Student Semester Subjects</a></li>
        <li><a href="${pageContext.request.contextPath}/admin/subject/list">Subjects List</a></li>
        <li><a href="${pageContext.request.contextPath}/admin/timetable/list">Timetables</a></li>
        <li><a href="${pageContext.request.contextPath}/admin/sessions">Sessions</a></li>
        <li><a href="${pageContext.request.contextPath}/admin/backlogs">Backlogs</a></li>
        <li><a href="${pageContext.request.contextPath}/admin/semester-summaries">semester-summariess</a></li>
        <li><a href="${pageContext.request.contextPath}/admin/semester-results">Semester Results</a></li> <!-- New Link -->
    </ul>
    <hr>
    <a href="${pageContext.request.contextPath}/admin/logout">Logout</a>
</body>
</html>
