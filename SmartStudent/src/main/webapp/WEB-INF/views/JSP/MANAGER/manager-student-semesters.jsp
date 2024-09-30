<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Student Semesters</title>
</head>
<body>
	<h2>Student Semesters</h2>

	<!-- Filter by Student -->
	<form
		action="${pageContext.request.contextPath}/manager/student-semesters"
		method="get">
		<label for="studentId">Filter by Student:</label> <select
			name="studentId" id="studentId">
			<option value="">All Students</option>
			<c:forEach var="student" items="${students}">
				<option value="${student.studentId}"
					${student.studentId == selectedStudentId ? 'selected' : ''}>
					${student.studentId} : ${student.username}</option>
			</c:forEach>
		</select>
		<button type="submit">Filter</button>
	</form>

	<table border="1">
		<tr>
			<th>ID</th>
			<th>Student</th>
			<th>Semester</th>
			<th>Actions</th>
		</tr>
		<c:forEach var="studentSemester" items="${studentSemesters}">
			<tr>
				<td>${studentSemester.studentSemesterId}</td>
				<td>${studentSemester.student.username}</td>
				<td>${studentSemester.semester.name}</td>
				<td><a
					href="${pageContext.request.contextPath}/manager/student-semesters/${studentSemester.studentSemesterId}">View</a>
					| <a
					href="${pageContext.request.contextPath}/manager/student-semesters/${studentSemester.studentSemesterId}/edit">Edit</a>
					<a
					href="${pageContext.request.contextPath}/manager/student-semesters/${studentSemester.studentSemesterId}/delete">Delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>

	<a
		href="${pageContext.request.contextPath}/manager/student-semesters/new">Add
		New Student Semester</a>
</body>
</html>
