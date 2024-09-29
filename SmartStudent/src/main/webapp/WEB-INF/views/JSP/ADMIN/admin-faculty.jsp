<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Faculty List</title>
<style>
.scrollable-table {
	max-height: 400px;
	overflow-y: scroll;
}

th, td {
	padding: 8px 12px;
}

.action-buttons {
	display: flex;
	gap: 8px;
}

.error-message {
	color: red;
	margin-bottom: 20px;
	padding: 10px;
	border: 1px solid red;
	background-color: #ffe6e6;
}
</style>
</head>
<body>
	<h1>Faculty Members</h1>

	<!-- Error Notification -->
	<c:if test="${not empty error}">
		<div class="error-message">${error}</div>
	</c:if>

	<form method="GET"
		action="${pageContext.request.contextPath}/admin/faculty">
		<label for="facultyId">Search by ID:</label> <input type="text"
			id="facultyId" name="facultyId" value="${param.facultyId}" /> <label
			for="department">Filter by Department:</label> <select
			id="department" name="department">
			<option value="">--All--</option>
			<c:forEach var="department" items="${departments}">
				<option value="${department.name}"
					<c:if test="${department.name == param.department}">selected</c:if>>${department.name}</option>
			</c:forEach>
		</select>

		<button type="submit">Search</button>
	</form>

	<div class="scrollable-table">
		<table border="1">
			<thead>
				<tr>
					<th>ID</th>
					<th>Username</th>
					<th>Email</th>
					<th>Department</th>
					<th>Position</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="faculty" items="${faculty}">
					<tr>
						<td>${faculty.facultyId}</td>
						<td>${faculty.username}</td>
						<td>${faculty.email}</td>
						<td>${faculty.department.name}</td>
						<td>${faculty.position}</td>
						<td class="action-buttons">
							<!-- View Button -->
							<form
								action="${pageContext.request.contextPath}/admin/faculty/${faculty.facultyId}"
								method="GET" style="display: inline;">
								<button type="submit">View</button>
							</form> <!-- Edit Button -->
							<form
								action="${pageContext.request.contextPath}/admin/faculty/${faculty.facultyId}/edit"
								method="GET" style="display: inline;">
								<button type="submit">Edit</button>
							</form> <!-- Delete Button -->
							<form
								action="${pageContext.request.contextPath}/admin/faculty/delete/${faculty.facultyId}"
								method="POST" style="display: inline;">
								<button type="submit"
									onclick="return confirm('Are you sure you want to delete this faculty?')">Delete</button>
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<p>
			<a href="${pageContext.request.contextPath}/admin/faculty/add">
				Add New Faculty</a>
		</p>
	</div>
</body>
</html>
