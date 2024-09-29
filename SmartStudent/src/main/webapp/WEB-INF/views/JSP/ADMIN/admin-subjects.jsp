<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<title>Admin - Subjects</title>
</head>
<body>
	<h1>Subjects List</h1>

	<!-- Filter by Course -->
	<form action="${pageContext.request.contextPath}/admin/subjects"
		method="get">
		<label for="courseFilter">Filter by Course:</label> <select
			name="courseId" id="courseFilter">
			<option value="">All Courses</option>
			<c:forEach var="course" items="${courses}">
				<option value="${course.courseId}"
					<c:if test="${selectedCourseId == course.courseId}">selected</c:if>>${course.name}</option>
			</c:forEach>
		</select>
		<button type="submit">Filter</button>
	</form>

	<table border="1">
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Code</th>
				<th>Description</th>
				<th>Course</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="subject" items="${subjects}">
				<tr>
					<td>${subject.subjectId}</td>
					<td>${subject.name}</td>
					<td>${subject.code}</td>
					<td>${subject.description}</td>
					<td>${subject.course.name}</td>
					<td><a
						href="${pageContext.request.contextPath}/admin/subjects/${subject.subjectId}/">View</a>
						<a
						href="${pageContext.request.contextPath}/admin/subjects/${subject.subjectId}/edit">Edit</a>
						| <a
						href="${pageContext.request.contextPath}/admin/subjects/${subject.subjectId}/delete">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	|
	<a href="${pageContext.request.contextPath}/admin/subjects//new">Add
		Subject</a>

</body>
</html>
