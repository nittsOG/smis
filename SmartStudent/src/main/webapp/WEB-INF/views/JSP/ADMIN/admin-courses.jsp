<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Courses List</title>
<script>
	<c:if test="${not empty alert}">
	alert("${alert}");
	</c:if>
</script>
</head>
<body>
	<h1>Courses List</h1>

	<!-- Filter Form -->
	<form action="${pageContext.request.contextPath}/admin/courses"
		method="get">
		<label for="departmentFilter">Filter by Department:</label> <select
			id="departmentFilter" name="departmentId">
			<option value="">-- Select Department --</option>
			<c:forEach var="department" items="${departments}">
				<option value="${department.departmentId}"
					<c:if test="${param.departmentId == department.departmentId}">selected</c:if>>${department.name}</option>
			</c:forEach>
		</select>
		<button type="submit">Filter</button>
	</form>

	<table border="1">
		<thead>
			<tr>
				<th>ID</th>
				<th>Department</th>
				<th>Name</th>
				<th>Description</th>
				<th>Specialization</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="course" items="${courses}">
				<tr>
					<td>${course.courseId}</td>
					<td>${course.department.getName()}</td>
					<td>${course.name}</td>
					<td>${course.description}</td>
					<td>${course.specialization}</td>
					<td><a
						href="${pageContext.request.contextPath}/admin/courses/${course.courseId}">Details</a>
						<a
						href="${pageContext.request.contextPath}/admin/courses/${course.courseId}/edit">Edit</a>
						<a
						href="${pageContext.request.contextPath}/admin/courses/${course.courseId}/delete">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<a href="${pageContext.request.contextPath}/admin/courses/new">Add
		New Course</a>
</body>
</html>
