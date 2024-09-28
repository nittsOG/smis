<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Fee Details</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
	<h2>Fee Details</h2>

	<table border="1">
		<tr>
			<th>Fee ID:</th>
			<td>${fee.feeId}</td>
		</tr>
		<tr>
			<th>studentSemesterId:</th>
			<td>${fee.studentSemester.studentSemesterId}</td>
		</tr>
		<tr>
			<th>Student ID:</th>
			<td>${fee.studentSemester.student.studentId}</td>
		</tr>
		<tr>
			<th>Total Amount:</th>
			<td>${fee.totalAmount}</td>
		</tr>
		<tr>
			<th>Paid Amount:</th>
			<td>${fee.paidAmount}</td>
		</tr>
		<tr>
			<th>Due Date:</th>
			<td>${fee.dueDate}</td>
		</tr>
	</table>

	<a
		href="${pageContext.request.contextPath}/admin/fees/${fee.feeId}/edit">Edit</a>
	|
	<a href="${pageContext.request.contextPath}/admin/fees">Back to
		List</a>
</body>
</html>
