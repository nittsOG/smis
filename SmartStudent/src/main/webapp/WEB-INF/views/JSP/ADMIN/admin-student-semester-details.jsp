<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student Semester Details</title>
</head>
<body>
    <h1>Student Semester Details</h1>
    <p>ID: ${studentSemester.id}</p>
    <p>Student ID: ${studentSemester.studentId}</p>
    <p>Semester: ${studentSemester.semester}</p>
    <p>Year: ${studentSemester.year}</p>
    <a href="${pageContext.request.contextPath}/admin/student-semesters">Back to List</a>
    <a href="${pageContext.request.contextPath}/admin/student-semesters/${studentSemester.id}/edit">Edit</a>
    <a href="${pageContext.request.contextPath}/admin/student-semesters/${studentSemester.id}/delete">Delete</a>
</body>
</html>
