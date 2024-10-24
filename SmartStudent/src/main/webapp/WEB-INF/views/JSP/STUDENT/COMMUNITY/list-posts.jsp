<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Posts in Community</title>

<style>
    /* General reset */
    * {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
        font-family: 'Segoe UI', Arial, sans-serif;
    }

    body {
        background: linear-gradient(to right, #1a1a2e, #16213e); /* Darker gradient */
        min-height: 100vh;
        display: flex;
        justify-content: center;
        align-items: center;
        padding: 20px;
    }

    .container {
        background-color: white;
        padding: 30px;
        border-radius: 15px;
        box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
        width: 100%;
        max-width: 1000px;
        margin: 20px;
    }

    h1 {
        font-family: 'Segoe UI', sans-serif;
        color: black;
        margin: 0;
        font-size: 2.2rem;/* Larger font size for better visibility */
        text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.5);
        margin-bottom: 20px; /* Space below the header */
        text-align: center; /* Centered title */
    }

    table {
        width: 100%;
        border-collapse: collapse;
        border-radius: 10px;
        overflow: hidden;
        margin-bottom: 20px;
    }

    th, td {
        padding: 15px;
        text-align: left;
        border-bottom: 1px solid #ddd;
    }

    th {
        background-color: #1a1a2e;
        color: white;
        font-weight: bold;
    }

    tr:nth-child(even) {
        background-color: #f9f9f9;
    }

    tr:hover {
        background-color: #f1f1f1;
    }

    .post-image {
        max-width: 100%;
        height: auto;
        border-radius: 8px;
        display: block;
        margin: 10px 0;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
    }

    p {
        margin: 10px 0;
    }

    a {
        color: #007bff;
        text-decoration: none;
        font-weight: bold;
    }

    a:hover {
        text-decoration: underline;
        color: #0056b3;
    }

    .action-links {
        text-align: center;
        margin-top: 20px;
    }

    .action-links a {
        margin: 0 10px;
        padding: 10px 20px;
        background-color: #1e1e2a;
        color: white;
        border-radius: 5px;
        transition: background-color 0.3s ease;
    }

    .action-links a:hover {
        background-color: #2c3e50;
    }

    /* Responsive Design */
    @media (max-width: 768px) {
        .container {
            padding: 20px;
        }

        th, td {
            padding: 10px;
            font-size: 14px;
        }

        h1 {
            font-size: 1.5rem;
        }
    }

</style>
</head>
<body>

    <div class="container">
        <h1>Posts in Community</h1>

        <table>
            <thead>
                <tr>
                    <th>Post Content</th>
                    <th>Posted By</th>
                    <th>Timestamp</th>
                </tr>
            </thead>
            <tbody>
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
            </tbody>
        </table>

        <div class="action-links">
            <a href="${pageContext.request.contextPath}/student/community/createPost/${communityId}">Create Post</a>
            <a href="${pageContext.request.contextPath}/student/community/list">Back to Communities</a>
        </div>
    </div>

</body>
</html>
