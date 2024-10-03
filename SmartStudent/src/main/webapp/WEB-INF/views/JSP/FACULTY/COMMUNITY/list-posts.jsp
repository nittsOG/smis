<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Posts in Community</title>
<style>
/* Styling for the images */
.post-image {
	max-width: 400px; /* Set max width for images */
	height: auto; /* Maintain aspect ratio */
	display: block; /* Make the image a block element */
	margin: 10px auto; /* Center the image */
}
</style>
</head>
<body>
	<h1>Posts in Community</h1>
	<table>
		<tr>
			<th>Post Content</th>
			<th>Posted By</th>
			<th>Attachment</th>
		</tr>
		<c:forEach var="post" items="${posts}">
			<tr>
				<td>
					<h3>Posted by: ${post.faculty.username}</h3>
					<p>${post.content}</p> <c:if test="${post.photoBase64 != null}">
						<img src="data:image/jpeg;base64,${post.photoBase64}"
							alt="Post Image" class="post-image" />
					</c:if>

					<p>Posted on: ${post.timestamp}</p>
				</td>
			</tr>
		</c:forEach>
	</table>
		<p><a href="${pageContext.request.contextPath}/faculty/community/createPost/${communityId}">Add Post</a></p>
</body>
</html>
