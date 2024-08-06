<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Divisions List</title>
</head>
<body>
	<h1>Divisions List</h1>

	<c:if test="${not empty errorMessage}">
		<div class="alert alert-danger">${errorMessage}</div>
	</c:if>

	<c:if test="${not empty successMessage}">
		<div class="alert alert-success">${successMessage}</div>
	</c:if>


	<a href="${pageContext.request.contextPath}/admin/divisions/new">Add
		New Division</a>
	<table border="1">
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="division" items="${divisions}">
				<tr>
					<td>${division.divisionId}</td>
					<td>${division.name}</td>
					<td><a
						href="${pageContext.request.contextPath}/admin/divisions/${division.divisionId}">View</a>
						<a
						href="${pageContext.request.contextPath}/admin/divisions/${division.divisionId}/edit">Edit</a>
						<a
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
