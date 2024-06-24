<!-- WEB-INF/jsp/FACULTY/faculty-dashboard.jsp -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Faculty Dashboard</title>
</head>
<body>
    <h2>Welcome, ${facultyUsername}</h2>
    <p>This is the Faculty Dashboard.</p>
    <form action="${pageContext.request.contextPath}/faculty/logout" method="get">
        <input type="submit" value="Logout">
    </form>
</body>
</html>
