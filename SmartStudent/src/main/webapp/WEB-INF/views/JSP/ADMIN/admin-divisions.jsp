<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Divisions List</title>
</head>
<body>
	<h2>Divisions</h2>

	<form action="${pageContext.request.contextPath}/admin/divisions"
		method="get">
		<label for="departmentFilter">Filter by Department:</label> <select
			id="departmentFilter" name="department">
			<option value="">-- Select Department --</option>
			<c:forEach var="departmentOption" items="${departments}">
				<option value="${departmentOption.departmentId}"
					<c:if test="${param.department == departmentOption.departmentId}">selected</c:if>>
					${departmentOption.name}</option>
			</c:forEach>
		</select>
		<button type="submit">Filter</button>
	</form>


	<a href="${pageContext.request.contextPath}/admin/divisions/new">Add
		New Division</a>

	<table border="1">
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Department</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="division" items="${divisions}">
				<tr>
					<td>${division.divisionId}</td>
					<td>${division.name}</td>
					<td>${division.department.name}</td>
					<td><a
						href="${pageContext.request.contextPath}/admin/divisions/${division.divisionId}">View</a>
						| <a
						href="${pageContext.request.contextPath}/admin/divisions/${division.divisionId}/edit">Edit</a>
						| <a
						href="${pageContext.request.contextPath}/admin/divisions/${division.divisionId}/delete"
						onclick="return confirm('Are you sure you want to delete this division?');">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<a href="${pageContext.request.contextPath}/admin/dashboard">Back
		to Dashboard</a>
</body>
</html>
