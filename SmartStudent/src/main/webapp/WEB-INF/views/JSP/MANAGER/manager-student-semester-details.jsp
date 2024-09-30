<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Student Semester Details</title>
</head>
<body>
	<h2>Student Semester Details</h2>
	<p>studentSemesterId: ${studentSemester.studentSemesterId}</p>
	<p>Student: ${studentSemester.student.username}</p>
	<p>Semester: ${studentSemester.semester.name}</p>

	<a
		href="${pageContext.request.contextPath}/manager/student-semesters/${studentSemester.studentSemesterId}/edit">Edit</a>
	|
	<a
		href="${pageContext.request.contextPath}/manager/student-semesters/${studentSemester.studentSemesterId}/delete">Delete</a>
	|
	<a href="${pageContext.request.contextPath}/manager/student-semesters">Back
		to List</a>
</body>
</html>
