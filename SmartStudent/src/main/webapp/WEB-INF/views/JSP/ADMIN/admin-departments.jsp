<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Departments List</title>
    <script>
        <c:if test="${not empty alert}">
            alert("${alert}");
        </c:if>
    </script>
</head>
<body>
    <h1>Departments List</h1>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Description</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="department" items="${departments}">
                <tr>
                    <td>${department.getDepartmentId()}</td>
                    <td>${department.name}</td>
                    <td>${department.description}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/admin/departments/${department.getDepartmentId()}">Details</a>
                        <a href="${pageContext.request.contextPath}/admin/departments/${department.getDepartmentId()}/edit">Edit</a>
                        <a href="${pageContext.request.contextPath}/admin/departments/${department.getDepartmentId()}/delete">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="${pageContext.request.contextPath}/admin/departments/new">Add New Department</a>
</body>
</html>
