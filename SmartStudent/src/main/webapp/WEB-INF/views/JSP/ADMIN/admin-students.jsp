<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Admin - Students</title>
</head>
<body>
    <h1>Students List</h1>
    <table border="1">
        <tr>
            <th>Username</th>
            <th>Email</th>
            <th>Division</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="student" items="${students}">
            <tr>
                <td>${student.username}</td>
                <td>${student.email}</td>
                <td>${student.division.name}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/admin/students/${student.studentId}">View</a>
                    <a href="${pageContext.request.contextPath}/admin/students/${student.studentId}/edit">Edit</a>
                    <a href="${pageContext.request.contextPath}/admin/students/${student.studentId}/delete" onclick="return confirm('Are you sure you want to delete this student?');">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
