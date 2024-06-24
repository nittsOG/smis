<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Dashboard</title>
</head>
<body>
    <h2>Welcome, ${studentUsername}!</h2>
    <p>This is your dashboard.</p>
    <a href="${pageContext.request.contextPath}/student/logout">Logout</a>
</body>
</html>
