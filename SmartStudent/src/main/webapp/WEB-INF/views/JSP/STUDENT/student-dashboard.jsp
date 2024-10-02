<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Student Dashboard</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/STUDENT/dashboard.css">
<style>
/* Styling for the profile photo */
.profile-photo {
	width: 150px;
	height: auto;
	display: block;
	margin: 10px auto;
}
</style>
</head>
<body>
	<!-- Sidebar Section -->
	<div id="sidebar" class="sidebar">
		<button id="close-btn" class="close-btn" onclick="toggleSidebar()">></button>
		<!-- Updated Close Button -->
		<a href="${pageContext.request.contextPath}/student/profile">Profile</a>
		<a href="${pageContext.request.contextPath}/student/attendance">Attendance</a>
		<a href="${pageContext.request.contextPath}/student/results">Results</a>
		<a href="${pageContext.request.contextPath}/student/timetable">Timetable</a>
		<a href="${pageContext.request.contextPath}/student/fees">Fees</a> <a
			href="${pageContext.request.contextPath}/student/logout">Logout</a>
	</div>

	<!-- Main Content -->
	<div id="main-content" class="main-content">
		<button class="open-btn" onclick="toggleSidebar()"><</button>
		<!-- Updated Open Button -->
		<h1>Welcome, ${student.username}</h1>
		<c:choose>
			<c:when test="${photoBase64 != null}">
				<img src="data:image/jpeg;base64,${photoBase64}" alt="Student Photo"
					class="profile-photo" />
			</c:when>
			<c:otherwise>
				<img
					src="${pageContext.request.contextPath}/resources/images/default-photo.jpg"
					alt="Default Student Photo" class="profile-photo" />
			</c:otherwise>
		</c:choose>
		<hr>
		<p>
			<a href="${pageContext.request.contextPath}/student/profile">Go
				to profile</a>
		</p>
		<p>
			<a href="${pageContext.request.contextPath}/student/chat/inbox">Inbox</a>
		</p>
	</div>

	<script
		src="${pageContext.request.contextPath}/resources/STUDENT/dashboard.js"></script>
</body>
</html>
