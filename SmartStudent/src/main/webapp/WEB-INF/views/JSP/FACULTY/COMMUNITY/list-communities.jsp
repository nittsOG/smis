<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Community List</title>
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
            max-width: 800px;
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
            margin-bottom: 5%;
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

        a {
            color: #007bff;
            text-decoration: none;
        }

        a:hover {
            background-color: #2a3e50;
        }

        .action-buttons {
            display: flex;
            gap: 10px;
        }

        p {
            text-align: center;
        }

        button, a {
            background-color: #007bff;
            color: white;
            padding: 10px;
            border: none;
            border-radius: 5px;
            font-size: 14px;
            cursor: pointer;
            margin-top: 2%;
            
        }

        button:hover, a:hover {
            background-color: #2a3e50;
        }
    </style>
</head>
<body>

    <div class="container">
        <h1>Your Communities</h1>
        <hr>

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
                    <td class="action-buttons">
                        <a href="${pageContext.request.contextPath}/faculty/community/posts/${community.communityId}">View Posts</a>
                        <a href="${pageContext.request.contextPath}/faculty/community/manage/${community.communityId}">Manage</a>
                    </td>
                </tr>
            </c:forEach>
        </table>

        <p><a href="${pageContext.request.contextPath}/faculty/community/create">Create Community</a></p>
    </div>

</body>
</html>
