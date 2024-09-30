<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Faculty Subjects</title>
</head>
<body>

	<h2>Faculty Subjects</h2>

	<!-- Filter Form -->
	<form action="${pageContext.request.contextPath}/manager/facultySubjects"
		method="get">
		<label for="facultyId">Filter by Faculty ID:</label> <input
			type="text" id="facultyId" name="facultyId"
			value="${param.facultyId}">
		<button type="submit">Filter</button>
		<a href="${pageContext.request.contextPath}/manager/facultySubjects">Clear
			Filter</a>
	</form>

	<!-- Display Table -->
	<table border="1">
		<thead>
			<tr>
				<th>Faculty Subject ID</th>
				<th>Faculty ID</th>
				<th>Faculty Name</th>
				<th>Subject Name</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="facultySubject" items="${facultySubjects}">
				<tr>
					<td>${facultySubject.facultySubjectId}</td>
					<td>${facultySubject.faculty.facultyId}</td>
					<td>${facultySubject.faculty.username}</td>
					<td>${facultySubject.subject.name}</td>
					<td><a
						href="${pageContext.request.contextPath}/manager/facultySubjects/${facultySubject.facultySubjectId}">Details</a>
						<a
						href="${pageContext.request.contextPath}/manager/facultySubjects/${facultySubject.facultySubjectId}/edit">Edit</a>
						<a
						href="${pageContext.request.contextPath}/manager/facultySubjects/${facultySubject.facultySubjectId}/delete">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<a href="${pageContext.request.contextPath}/manager/facultySubjects/new">Add
		New Faculty Division</a>
</body>
</html>
 