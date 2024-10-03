<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Manage Community</title>
</head>
<body>
	<h2>Manage Community: ${community.name}</h2>

	<h3>Community Members</h3>
	<ul>
		<c:forEach var="member" items="${communityMembers}">
			<li>${member.studentId} : ${member.username}
				<form method="post"
					action="${pageContext.request.contextPath}/faculty/community/removeStudent"
					style="display: inline;">
					<input type="hidden" name="communityId"
						value="${community.communityId}" /> 
					<input type="hidden"
						name="studentId" value="${member.studentId}" />
					<button type="submit">Remove</button>
				</form>
			</li>
		</c:forEach>
	</ul>

	<h3>Add New Member</h3>
	<form method="post"
		action="${pageContext.request.contextPath}/faculty/community/addStudent">
		<input type="hidden" name="communityId"
			value="${community.communityId}" /> 
		<label for="studentId">Enter Student ID:</label>
		<input type="text" name="studentId" id="studentId" required />
		<button type="submit">Add Student</button>
	</form>

	<h3>Delete Community</h3>
	<form method="post"
		action="${pageContext.request.contextPath}/faculty/community/delete">
		<input type="hidden" name="communityId"
			value="${community.communityId}" />
		<button type="submit">Delete Community</button>
	</form>
	<p><a href="${pageContext.request.contextPath}/faculty/community/list">Back</a></p>
</body>
</html>
