<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Login</title>
</head>
<body>
<h2>Admin Login</h2>
<form action="${pageContext.request.contextPath}/admin/login" method="post">
    <label for="username">Username:</label>
    <input type="text" id="username" name="username" required>
    <br>
    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required>
    <br>
    <input type="submit" value="Login">
    <c:if test="${not empty error}">
        <p style="color:red">${error}</p>
    </c:if>
</form>
</body>
</html>
