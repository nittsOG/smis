<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student Semester Subject Details</title>
</head>
<body>
    <h1>Student Semester Subject Details</h1>
    <p>ID: ${studentSemesterSubject.id}</p>
    <p>Student Semester ID: ${studentSemesterSubject.studentSemesterId}</p>
    <p>Subject ID: ${studentSemesterSubject.subjectId}</p>
    <a href="${pageContext.request.contextPath}/admin/student-semester-subjects">Back to List</a>
    <a href="${pageContext.request.contextPath}/admin/student-semester-subjects/${studentSemesterSubject.id}/edit">Edit</a>
    <a href="${pageContext.request.contextPath}/admin/student-semester-subjects/${studentSemesterSubject.id}/delete">Delete</a>
</body>
</html>
