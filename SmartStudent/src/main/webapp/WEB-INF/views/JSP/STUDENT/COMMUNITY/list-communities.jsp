<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- Display list of communities -->
	<table>
		<thead>
			<tr>
				<th>Community Name</th>
				<th>Description</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="community" items="${communities}">
				<tr>
					<td>${community.name}</td>
					<td>${community.description}</td>
					<td><a
						href="${pageContext.request.contextPath}/student/community/posts/${community.communityId}">View
							Posts</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>