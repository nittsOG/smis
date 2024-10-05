<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Semester Summaries List</title>
</head>
<body>
	<h1>Semester Summaries List</h1>
	<table border="1">
		<thead>
			<tr>
				<th>Student ID</th>
				<th>Semester</th>
				<th>Total Credits</th>
				<th>Total Credit Points</th>
				<th>SGPA</th>
				<th>CGPA</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="summary" items="${semesterSummaries}">
				<tr>
					<td>${summary.studentId}</td>
					<!-- Corrected -->
					<td>${summary.semester}</td>
					<!-- Corrected -->
					<td>${summary.totalCredits}</td>
					<td>${summary.totalCreditPoints}</td>
					<td>${summary.sgpa}</td>
					<td>${summary.cgpa}</td>
					<td><a
						href="${pageContext.request.contextPath}/admin/semester-summaries/${summary.studentId}/${summary.semester}">Details</a>
						<a
						href="${pageContext.request.contextPath}/admin/semester-summaries/${summary.studentId}/${summary.semester}/edit">Edit</a>
						<a
						href="${pageContext.request.contextPath}/admin/semester-summaries/${summary.studentId}/${summary.semester}/delete">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a
		href="${pageContext.request.contextPath}/admin/semester-summaries/new">Add
		New Semester Summary</a>
	<a href="${pageContext.request.contextPath}/admin/dashboard">Back
		to Dashboard</a>
</body>
</html>
