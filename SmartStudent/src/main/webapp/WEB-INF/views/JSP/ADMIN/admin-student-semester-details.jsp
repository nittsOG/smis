<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student Semester Details</title>
</head>
<body>
    <h1>Student Semester Details</h1>
    <p>ID: ${studentSemester.studentSemesterId}</p>
    <p>Student: ${studentSemester.student.username}</p>
    <p>Semester: ${studentSemester.semester.name}</p>
    <a href="<c:url value='/admin/student-semesters' />">Back to List</a>
    <a href="<c:url value='/admin/student-semesters/${studentSemester.studentSemesterId}/edit' />">Edit</a>
</body>
</html>
