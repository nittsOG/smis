<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

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

    table {
        width: 80%;
        max-width: 900px;
        background-color: #fff;
        border-collapse: collapse;
        border-radius: 10px;
        overflow: hidden;
        box-shadow: 0 6px 12px rgba(0, 0, 0, 0.1);
    }

    thead {
        background-color: #1a1a2e;
        color: white;
        font-weight: bold;
        text-align: left;
    }

    th, td {
        padding: 15px;
        text-align: left;
        border-bottom: 1px solid #ddd;
    }

    tbody tr:hover {
        background-color: #f1f1f1;
    }

    tbody tr:nth-child(even) {
        background-color: #f9f9f9;
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

    /* Responsive Design */
    @media (max-width: 768px) {
        table {
            width: 100%;
        }

        th, td {
            padding: 10px;
            font-size: 14px;
        }
    }

</style>

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
