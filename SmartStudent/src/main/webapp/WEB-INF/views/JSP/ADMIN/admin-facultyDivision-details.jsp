<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Faculty Division Details</title>
</head>
<body>
    <h1>Faculty Division Details</h1>
    <p>ID: ${facultyDivision.id}</p>
    <p>Name: ${facultyDivision.name}</p>
    <p>Description: ${facultyDivision.description}</p>
    <a href="${pageContext.request.contextPath}/admin/facultyDivisions">Back to List</a>
</body>
</html>
