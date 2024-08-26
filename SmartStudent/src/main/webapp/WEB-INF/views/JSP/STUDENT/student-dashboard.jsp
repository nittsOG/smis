<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student Dashboard</title>
</head>
<body>
    <h1>${student }</h1>
    <hr>
    <p> <a href="${pageContext.request.contextPath}/student/profile"> Go to profile</a> </p>
    <p> <a href="${pageContext.request.contextPath}/student/attendance"> Attendance</a> </p>
    <p> <a href="${pageContext.request.contextPath}/student/results"> results</a> </p>
    
<a href="${pageContext.request.contextPath}/student/logout">Logout</a>
</body>
</html>
