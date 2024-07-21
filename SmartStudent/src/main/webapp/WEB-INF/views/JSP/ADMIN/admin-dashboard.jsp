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
        <li><a href="${pageContext.request.contextPath}/admin/courses">courses</a></li> 
        <li><a href="${pageContext.request.contextPath}/admin/attendances">attendances</a></li>
        <li><a href="${pageContext.request.contextPath}/admin/departments">/departments</a></li>
        <li><a href="${pageContext.request.contextPath}/admin/divisions">divisions</a></li>
        <li><a href="${pageContext.request.contextPath}/admin/faculty/list">faculty/list</a></li>
        <li><a href="${pageContext.request.contextPath}/admin/facultyDivisions">facultyDivisions</a></li>
        <li><a href="${pageContext.request.contextPath}/admin/facultySubjects">facultySubjects</a></li> 
        <li><a href="${pageContext.request.contextPath}/admin/fees">fees</a></li>
        <li><a href="${pageContext.request.contextPath}/admin/manager/list">manager/list</a></li>
        <li><a href="${pageContext.request.contextPath}/admin/payments">payments</a></li>  
        <li><a href="${pageContext.request.contextPath}/admin/semesters">semesters</a></li> 
        <li><a href="${pageContext.request.contextPath}/admin/semester-subjects">semester-subjects</a></li>  
        <li><a href="${pageContext.request.contextPath}/admin/student-semesters">Student Semesters</a></li>
        <li><a href="${pageContext.request.contextPath}/admin/student-semester-subjects">Student Semester Subjects</a></li>
        <li><a href="${pageContext.request.contextPath}/admin/subject/list">Subjects/list</a></li>
        <li><a href="${pageContext.request.contextPath}/admin/timetable/list">Timetables</a></li>
        <li><a href="${pageContext.request.contextPath}/admin/sessions">Sessions</a></li>
    </ul>
    <hr>
    <a href="${pageContext.request.contextPath}/admin/logout">Logout</a>
</body>
</html>
