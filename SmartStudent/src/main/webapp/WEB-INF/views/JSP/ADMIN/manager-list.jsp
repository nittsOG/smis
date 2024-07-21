<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Manager List</title>
    <script>
        <c:if test="${not empty alert}">
            alert("${alert}");
        </c:if>
    </script>
</head>
<body>
    <h1>Manager List</h1>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="manager" items="${managers}">
                <tr>
                    <td>${manager.id}</td>
                    <td>${manager.name}</td>
                    <td>${manager.email}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/admin/manager/showFormForUpdate?managerId=${manager.id}">Edit</a>
                        <a href="${pageContext.request.contextPath}/admin/manager/delete?managerId=${manager.id}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="${pageContext.request.contextPath}/admin/manager/showFormForAdd">Add New Manager</a>
</body>
</html>
