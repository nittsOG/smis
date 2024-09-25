<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Student Fees</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/STUDENT/dashboard.css">
</head>
<body>	
	<!-- Sidebar Section -->
	<div id="sidebar" class="sidebar">
		<button id="close-btn" class="close-btn" onclick="toggleSidebar()"><</button>
		<a href="${pageContext.request.contextPath}/student/profile">Profile</a>
		<a href="${pageContext.request.contextPath}/student/attendance">Attendance</a>
		<a href="${pageContext.request.contextPath}/student/results">Results</a>
		<a href="${pageContext.request.contextPath}/student/timetable">Timetable</a>
		<a href="${pageContext.request.contextPath}/student/fees">Fees</a> 
		<a href="${pageContext.request.contextPath}/student/logout">Logout</a>
	</div>

	<!-- Main Content -->
	<div id="main-content" class="main-content">
	<button class="open-btn" onclick="toggleSidebar()">></button> <!-- Open Button -->
	
	<h2>Attendance Summary</h2>
		<c:choose>
			<c:when test="${not empty fees}">
				<table class="fees-table">
					<thead>
						<tr>
							<th>Semester</th>
							<th>Total Amount</th>
							<th>Paid Amount</th>
							<th>Due Date</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="fee" items="${fees}">
							<tr>
								<td>${fee.semester}</td>
								<td>${fee.totalAmount}</td>
								<td>${fee.paidAmount}</td>
								<td>${fee.dueDate}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:when>
			<c:otherwise>
				<p>No fees found for this student.</p>
			</c:otherwise>
		</c:choose>

	</div>


	<script
		src="${pageContext.request.contextPath}/resources/STUDENT/dashboard.js"></script>
</body>
</html>
