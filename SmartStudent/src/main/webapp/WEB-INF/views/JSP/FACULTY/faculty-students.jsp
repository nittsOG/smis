<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Student List</title>
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
	<h1>Students</h1>

	<!-- Error Notification -->
	<c:if test="${not empty error}">
		<div class="error-message">${error}</div>
	</c:if>

	<form method="GET"
		action="${pageContext.request.contextPath}/faculty/students">
		<label for="division">Filter by Division:</label> <select
			id="division" name="divisionId">
			<option value="">--All--</option>
			<c:forEach var="division" items="${Divisions}">
				<option value="${division.divisionId}"
					<c:if test="${division.divisionId == selectedDivisionId}">selected</c:if>>
					${division.name}</option>
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
					<th>Division</th>
					<th>Department</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="student" items="${students}">
					<tr>
						<td>${student.studentId}</td>
						<td>${student.username}</td>
						<td>${student.email}</td>
						<td>${student.division.name}</td>
						<td>${student.division.department.name}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>
</body>
</html>
