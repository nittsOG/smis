<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Admin - Edit Manager</title>
</head>
<body>
    <h1>Edit Manager</h1>
    <form action="${pageContext.request.contextPath}/admin/managers/${manager.managerId}/edit" method="post">
        <p>Username: <input type="text" name="username" value="${manager.username}" required /></p>
        <p>Password: <input type="password" name="password" value="${manager.password}" required /></p>
        <p>Email: <input type="email" name="email" value="${manager.email}" required /></p>

        <h2>Address Information</h2>
        <p>Street: <input type="text" name="address.street" value="${manager.address.street}" required /></p>
        <p>City: <input type="text" name="address.city" value="${manager.address.city}" required /></p>
        <p>State: <input type="text" name="address.state" value="${manager.address.state}" required /></p>
        <p>Country: <input type="text" name="address.country" value="${manager.address.country}" required /></p>
        <p>Zip Code: <input type="text" name="address.zipCode" value="${manager.address.zipCode}" required /></p>

        <h2>Department Information</h2>
        <p>Department: 
            <select name="department.departmentId" required>
                <c:forEach var="department" items="${departments}">
                    <option value="${department.departmentId}" ${department.departmentId == manager.department.departmentId ? 'selected' : ''}>${department.name}</option>
                </c:forEach>
            </select>
        </p>

        <button type="submit">Update</button>
    </form>
</body>
</html>
