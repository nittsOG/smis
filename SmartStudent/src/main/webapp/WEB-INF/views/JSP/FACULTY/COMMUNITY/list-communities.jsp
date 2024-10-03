<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Community List</title>
</head>
<body>
	<h1>Your Communities</h1>
	<table>
		<tr>
			<th>Name</th>
			<th>Description</th>
			<th>Actions</th>
		</tr>
		<c:forEach var="community" items="${communities}">
			<tr>
				<td>${community.name}</td>
				<td>${community.description}</td>
				<td><a href="${pageContext.request.contextPath}/faculty/community/posts/${community.communityId}">View Posts</a></td>
				<td><a href="${pageContext.request.contextPath}/faculty/community/manage/${community.communityId}">Manage</a></td>
			</tr>
		</c:forEach>
	</table>
	<p><a href="${pageContext.request.contextPath}/faculty/community/create">Create Community</a></p>
</body>
</html>
