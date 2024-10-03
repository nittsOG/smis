<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Posts in Community</title>
<style>
    .post-image {
        max-width: 400px;
        height: auto;
        display: block;
        margin: 10px auto;
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
                    <p>${post.content}</p>
                    <c:if test="${post.photoBase64 != null}">
                        <img src="data:image/jpeg;base64,${post.photoBase64}" 
                             alt="Post Image" class="post-image" />
                    </c:if>
                </td>
                <td>${post.student.username}</td>
                <td>${post.timestamp}</td>
            </tr>
        </c:forEach>
    </table>
    <p>
		<a href="${pageContext.request.contextPath}/student/community/createPost/${communityId}">Create Posts</a>
	</p>
	    <p>
		<a href="${pageContext.request.contextPath}/student/community/list">Back</a>
	</p>
</body>
</html>
