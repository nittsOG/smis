<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Dashboard</title>
</head>
<body>
<h2>Admin Dashboard</h2>
<p>Welcome, ${adminUsername}!</p>
<a href="${pageContext.request.contextPath}/admin/logout">Logout</a>
</body>
</html>
