<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Department Details</title>
</head>
<body>
    <h2>Department Details</h2>
    <p>ID: ${department.departmentId}</p>
    <p>Name: ${department.name}</p>
    <p>Description: ${department.description}</p>
    <p>Field: ${department.field}</p>
    <a href="<c:url value='/admin/departments'/>">Back to List</a>
</body>
</html>
