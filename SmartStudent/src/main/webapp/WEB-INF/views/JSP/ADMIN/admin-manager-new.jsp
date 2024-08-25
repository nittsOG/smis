<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Admin - Add New Manager</title>
</head>
<body>
    <h1>Add New Manager</h1>
    <form action="${pageContext.request.contextPath}/admin/managers/new" method="post">
        <p>Username: <input type="text" name="username" required /></p>
        <p>Password: <input type="password" name="password" required /></p>
        <p>Email: <input type="email" name="email" required /></p>

        <h2>Address Information</h2>
        <p>Street: <input type="text" name="address.street" required /></p>
        <p>City: <input type="text" name="address.city" required /></p>
        <p>State: <input type="text" name="address.state" required /></p>
        <p>Country: <input type="text" name="address.country" required /></p>
        <p>Zip Code: <input type="text" name="address.zipCode" required /></p>

        <h2>Department Information</h2>
        <p>Department: 
            <select name="department.departmentId" required>
                <c:forEach var="department" items="${departments}">
                    <option value="${department.departmentId}">${department.name}</option>
                </c:forEach>
            </select>
        </p>

        <button type="submit">Save</button>
    </form>
</body>
</html>
