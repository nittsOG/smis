<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Fees Management</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
	<h2>Fees List</h2>

	<!-- Filter Form -->
	<form action="${pageContext.request.contextPath}/manager/fees"
		method="get">
		<label for="studentId">Filter by Student ID:</label> <input
			type="text" id="studentId" name="studentId"
			placeholder="Enter Student ID" />
		<button type="submit">Filter</button>
	</form>

	<!-- Display fees -->
	<table border="1">
		<thead>
			<tr>
				<th>Fee ID</th>
				<th>studentSemesterId</th>
				<th>Student ID</th>
				<th>Total Amount</th>
				<th>Paid Amount</th>
				<th>Due Date</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="fee" items="${fees}">
				<tr>
					<td>${fee.feeId}</td>
					<td>${fee.studentSemester.studentSemesterId}</td>
					<td>${fee.studentSemester.student.studentId}</td>
					<td>${fee.totalAmount}</td>
					<td>${fee.paidAmount}</td>
					<td>${fee.dueDate}</td>
					<td><a
						href="${pageContext.request.contextPath}/manager/fees/${fee.feeId}">Details</a>
						| <a
						href="${pageContext.request.contextPath}/manager/fees/${fee.feeId}/edit">Edit</a>
						<%-- 						| <a
						href="${pageContext.request.contextPath}/manager/fees/${fee.feeId}/delete"
						onclick="return confirm('Are you sure?')">Delete</a></td> --%>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<%-- 	<a href="${pageContext.request.contextPath}/manager/fees/new">Create
		New Fee</a> --%>
</body>
</html>
