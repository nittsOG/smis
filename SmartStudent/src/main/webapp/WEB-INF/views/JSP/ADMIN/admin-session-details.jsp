<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Session Details</title>
</head>
<body>
    <h1>Session Details</h1>
    <p>ID: ${session.id}</p>
    <p>Name: ${session.name}</p>
    <p>Start Date: ${session.startDate}</p>
    <p>End Date: ${session.endDate}</p>
    <a href="${pageContext.request.contextPath}/admin/sessions">Back to List</a>
    <a href="${pageContext.request.contextPath}/admin/sessions/${session.id}/edit">Edit</a>
    <a href="${pageContext.request.contextPath}/admin/sessions/${session.id}/delete">Delete</a>
</body>
</html>
