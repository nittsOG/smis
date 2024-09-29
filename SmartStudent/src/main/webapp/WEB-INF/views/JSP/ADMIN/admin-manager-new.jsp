<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Add Manager</title>
</head>
<body>
    <h2>Add New Manager</h2>

    <form method="post" action="${pageContext.request.contextPath}/admin/managers/add">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required />

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required />

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required />

        <label for="department">Department:</label>
        <select name="department.departmentId" id="department">
            <option value="">Select Department</option>
            <c:forEach var="dept" items="${departments}">
                <option value="${dept.departmentId}">${dept.name}</option>
            </c:forEach>
        </select>

        <h3>Address</h3>
        <label for="street">Street:</label>
        <input type="text" id="street" name="street" />

        <label for="city">City:</label>
        <input type="text" id="city" name="city" />

        <label for="state">State:</label>
        <input type="text" id="state" name="state" />

        <label for="country">Country:</label>
        <input type="text" id="country" name="country" />

        <label for="zipCode">Zip Code:</label>
        <input type="text" id="zipCode" name="zipCode" />

        <button type="submit">Add</button>
    </form>

    <a href="${pageContext.request.contextPath}/admin/managers">Back to list</a>
</body>
</html>
