<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Manager Details</title>
</head>
<body>
    <h2>Manager Details</h2>

    <p>ID: ${manager.managerId}</p>
    <p>Username: ${manager.username}</p>
    <p>Email: ${manager.email}</p>
    <p>Department: ${manager.department.name}</p>

    <h3>Address</h3>
    <c:if test="${manager.address != null}">
        <p>Street: ${manager.address.street}</p>
        <p>City: ${manager.address.city}</p>
        <p>State: ${manager.address.state}</p>
        <p>Country: ${manager.address.country}</p>
        <p>Zip Code: ${manager.address.zipCode}</p>
    </c:if>
    <c:if test="${manager.address == null}">
        <p>No address available</p>
    </c:if>

    <a href="${pageContext.request.contextPath}/admin/managers/${manager.managerId}/edit">Edit</a> |
    <a href="${pageContext.request.contextPath}/admin/managers">Back to list</a>
</body>
</html>
