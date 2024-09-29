<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Managers</title>
    <script>
        function confirmDelete(managerId) {
            if (confirm('Are you sure you want to delete this manager?')) {
                document.getElementById('deleteForm' + managerId).submit();
            }
        }
    </script>
</head>
<body>
    <h2>Managers List</h2>

    <form method="get" action="${pageContext.request.contextPath}/admin/managers">
        <label for="managerId">Manager ID:</label>
        <input type="text" id="managerId" name="managerId" />
        
        <label for="departmentId">Department:</label>
        <select name="departmentId" id="departmentId">
            <option value="">Select Department</option>
            <c:forEach var="dept" items="${departments}">
                <option value="${dept.departmentId}">${dept.name}</option> <!-- Changed to use dept.name -->
            </c:forEach>
        </select>

        <button type="submit">Filter</button>
    </form>

    <table border="1">
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
                        <a href="${pageContext.request.contextPath}/admin/managers/${manager.managerId}">Details</a> |
                        <a href="${pageContext.request.contextPath}/admin/managers/${manager.managerId}/edit">Edit</a> |
                        <form id="deleteForm${manager.managerId}" action="${pageContext.request.contextPath}/admin/managers/delete/${manager.managerId}" method="post" style="display: inline;">
                            <button type="button" onclick="confirmDelete(${manager.managerId})">Delete</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <a href="${pageContext.request.contextPath}/admin/managers/add">Add New Manager</a>
</body>
</html>
