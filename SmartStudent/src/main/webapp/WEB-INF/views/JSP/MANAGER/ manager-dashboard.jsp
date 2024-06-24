<!-- WEB-INF/jsp/MANAGER/manager-dashboard.jsp -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Manager Dashboard</title>
</head>
<body>
    <h2>Welcome, ${managerUsername}</h2>
    <p>This is the Manager Dashboard.</p>
    <form action="${pageContext.request.contextPath}/manager/logout" method="get">
        <input type="submit" value="Logout">
    </form>
</body>
</html>
