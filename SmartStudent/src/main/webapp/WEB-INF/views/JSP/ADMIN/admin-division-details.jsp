<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Division Details</title>
</head>
<body>
    <h1>Division Details</h1>
    <p>ID: ${division.id}</p>
    <p>Name: ${division.name}</p>
    <a href="${pageContext.request.contextPath}/admin/divisions/${division.id}/edit">Edit</a>
    <a href="${pageContext.request.contextPath}/admin/divisions">Back to List</a>
</body>
</html>
