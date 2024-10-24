<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Posts in Community</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background: linear-gradient(to right, #1a1a2e, #16213e); /* Darker gradient */
        color: white;
        margin: 0;
        padding: 20px;
    }

    .container {
        background-color: rgba(0, 0, 0, 0.3);
        max-width: 700px;
        margin: 20px auto;
        padding: 20px;
        border-radius: 10px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    }

    h1 {
        font-family: 'Segoe UI', sans-serif;
        color: white;
        margin: 0;
        font-size: 2.2rem;/* Larger font size for better visibility */
        text-shadow: 1px 1px 2px rgba(0, 0, 0, 0.7), /* Main shadow */
        0 0 25px rgba(255, 255, 255, 0.2); /* Glowing effect */
        margin-bottom: 20px; /* Space below the header */
        text-align: center; /* Centered title */
        
    }

    hr {
        border: none;
        height: 2px;
        background-color: white;
        width: 80%;
        margin: 20px auto;
    }

    table {
        width: 100%;
        border-collapse: collapse;
        margin-bottom: 20px;
    }

    th, td {
        padding: 12px;
        text-align: left;
        border-bottom: 1px solid #ddd;
    }

    th {
        background-color: #f8f8f8;
        color: black;
        font-weight: bold;
    }


    .post-content {
        padding: 10px;
    }

    .post-image {
        max-width: 400px;
        height: auto;
        display: block;
        margin: 10px auto;
    }

    .post-details {
        margin-top: 5px;
        font-size: 0.9em;
        color: #666;
    }

    .add-post {
        display: block;
        text-align: center;
        margin: 20px 0;
    }

    .add-post a {
        background-color: #007bff;
        color: white;
        padding: 10px 20px;
        border-radius: 5px;
        text-decoration: none;
        font-size: 16px;
    }

    .add-post a:hover {
        background-color: #2a3e50;
    }
</style>
</head>
<body>

    <div class="container">
        <h1>Posts in Community</h1>
        <hr>
        <table>
            <tr>
                <th>Post Content</th>
            </tr>
            <c:forEach var="post" items="${posts}">
                <tr>
                    <td class="post-content">
                        <h3>Posted by: ${post.faculty.username}</h3>
                        <p>${post.content}</p>

                        <c:if test="${post.photoBase64 != null}">
                            <img src="data:image/jpeg;base64,${post.photoBase64}"
                                alt="Post Image" class="post-image" />
                        </c:if>

                        <p class="post-details">Posted on: ${post.timestamp}</p>
                    </td>
                </tr>
            </c:forEach>
        </table>
        
        <div class="add-post">
            <a href="${pageContext.request.contextPath}/faculty/community/createPost/${communityId}">Add Post</a>
        </div>
    </div>

</body>
</html>

