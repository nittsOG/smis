<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Faculty Dashboard</title>
</head>
<body>
<h1>${faculty}</h1>
<hr>
<a href="${pageContext.request.contextPath}/faculty/logout">Logout</a>
<a href="${pageContext.request.contextPath}/faculty/profile">Profile</a>
</body>
</html>
