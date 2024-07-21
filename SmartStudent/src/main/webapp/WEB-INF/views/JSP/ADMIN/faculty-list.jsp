<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Faculty List</title>
    <script>
        <c:if test="${not empty alert}">
            alert("${alert}");
        </c:if>
    </script>
</head>
<body>
    <h1>Faculty List</h1>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Department</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="faculty" items="${faculties}">
                <tr>
                    <td>${faculty.id}</td>
                    <td>${faculty.name}</td>
                    <td>${faculty.email}</td>
                    <td>${faculty.department}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/admin/faculty/showFormForUpdate?facultyId=${faculty.id}">Edit</a>
                        <a href="${pageContext.request.contextPath}/admin/faculty/delete?facultyId=${faculty.id}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="${pageContext.request.contextPath}/admin/faculty/showFormForAdd">Add New Faculty</a>
</body>
</html>
