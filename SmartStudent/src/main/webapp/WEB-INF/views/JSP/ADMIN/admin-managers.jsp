<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Admin - Managers</title>
</head>
<body>
    <h1>Managers</h1>
    
    <form method="get" action="${pageContext.request.contextPath}/admin/managers">
        <label for="search">Search by ID:</label>
        <input type="text" name="search" id="search">
        
        <label for="department">Filter by Department:</label>
        <select name="department" id="department">
            <option value="">Select Department</option>
            <c:forEach var="dept" items="${departments}">
                <option value="${dept}">${dept}</option>
            </c:forEach>
        </select>
        
        <button type="submit">Search</button>
    </form>

    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Username</th>
                <th>Email</th>
                <th>Department</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="manager" items="${managers}">
                <tr>
                    <td>${manager.managerId}</td>
                    <td>${manager.username}</td>
                    <td>${manager.email}</td>
                    <td>${manager.department.name}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/admin/managers/${manager.managerId}">View</a> |
                        <a href="${pageContext.request.contextPath}/admin/managers/${manager.managerId}/edit">Edit</a> |
                        <a href="${pageContext.request.contextPath}/admin/managers/${manager.managerId}/delete">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
    <a href="${pageContext.request.contextPath}/admin/managers/new">Add New Manager</a>
</body>
</html>
