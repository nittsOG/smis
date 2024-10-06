<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Forgot Password</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/styles.css">
</head>
<body>
	<form action="${pageContext.request.contextPath}/forgot-password"
		method="post" id="forgot-password-form">
		<h2>Forgot Password</h2>
		<div class="forgot-password-wrapper"></div>
			<c:if test="${not empty error}">
				<div class="error">${error}</div>
			</c:if>
			<div class="role-container">
				<label for="role">Login as a :</label> <select id="role" name="role">
					<option value="student" ${role == 'student' ? 'selected' : ''}>Student</option>
					<option value="faculty" ${role == 'faculty' ? 'selected' : ''}>Faculty</option>
				</select>
			</div>
			<div class="input-container">
				<i class='bx bxs-id-card'></i> <input type="text" id="id" name="id"
					placeholder="ID" required>
			</div>
			<div class="input-container">
				<label for="oldPassword">Old Password:</label> <input
					type="password" id="oldPassword" name="oldPassword"
					placeholder="Enter old password" required>
			</div>
			<div class="input-container">
				<label for="newPassword">New Password:</label> <input
					type="password" id="newPassword" name="newPassword"
					placeholder="Enter new password" required>
			</div>
			<button type="submit">Change Password</button>
			<c:if test="${not empty message}">
				<div class="error">${message}</div>
			</c:if>
			<p><a href="${pageContext.request.contextPath}/login">Back To Login</a></p>
	</form>
	</div>
</body>
</html>
