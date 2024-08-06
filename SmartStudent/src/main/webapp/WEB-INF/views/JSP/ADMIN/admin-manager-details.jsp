<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Admin - Manager Details</title>
</head>
<body>
    <h1>Manager Details</h1>
    <p>ID: ${manager.managerId}</p>
    <p>Username: ${manager.username}</p>
    <p>Email: ${manager.email}</p>
    <p>Department: ${manager.department.name}</p>
    
    <h2>Address Information</h2>
    <p>Street: ${manager.address.street}</p>
    <p>City: ${manager.address.city}</p>
    <p>State: ${manager.address.state}</p>
    <p>Country: ${manager.address.country}</p>
    <p>Zip Code: ${manager.address.zipCode}</p>
    
    <a href="${pageContext.request.contextPath}/admin/managers/${manager.managerId}/edit">Edit</a> |
    <a href="${pageContext.request.contextPath}/admin/managers">Back to List</a>
</body>
</html>
