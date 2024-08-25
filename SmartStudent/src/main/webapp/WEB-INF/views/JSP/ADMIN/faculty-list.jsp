<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Faculty List</title>
</head>
<body>
    <h1>Faculty List</h1>
    <a href="${pageContext.request.contextPath}/admin/faculty/showFormForAdd">Add New Faculty</a>
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
            <c:forEach var="faculty" items="${faculties}">
                <tr>
                    <td>${faculty.facultyId}</td>
                    <td>${faculty.username}</td>
                    <td>${faculty.email}</td>
                    <td>${faculty.department.name}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/admin/faculty/showFormForUpdate?facultyId=${faculty.facultyId}">Edit</a>
                        <a href="${pageContext.request.contextPath}/admin/faculty/delete?facultyId=${faculty.facultyId}"
                           onclick="return confirm('Are you sure you want to delete this faculty?');">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="${pageContext.request.contextPath}/admin/dashboard">Back to Dashboard</a>
</body>
</html>
