<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Edit Manager</title>
</head>
<body>
    <h2>Edit Manager</h2>

    <form method="post" action="${pageContext.request.contextPath}/admin/managers/${manager.managerId}/edit">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" value="${manager.username}" required />

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" value="${manager.password}" required />

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" value="${manager.email}" required />

        <label for="department">Department:</label>
        <select name="department.departmentId" id="department">
            <c:forEach var="dept" items="${departments}">
                <option value="${dept.departmentId}" <c:if test="${dept.departmentId == manager.department.departmentId}">selected</c:if>>${dept.name}</option>
            </c:forEach>
        </select>

        <h3>Address</h3>
        <label for="street">Street:</label>
        <input type="text" id="street" name="street" value="${manager.address.street}" />

        <label for="city">City:</label>
        <input type="text" id="city" name="city" value="${manager.address.city}" />

        <label for="state">State:</label>
        <input type="text" id="state" name="state" value="${manager.address.state}" />

        <label for="country">Country:</label>
        <input type="text" id="country" name="country" value="${manager.address.country}" />

        <label for="zipCode">Zip Code:</label>
        <input type="text" id="zipCode" name="zipCode" value="${manager.address.zipCode}" />

        <button type="submit">Save</button>
    </form>

    <a href="${pageContext.request.contextPath}/admin/managers">Back to list</a>
</body>
</html>
