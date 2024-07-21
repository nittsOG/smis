<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Courses List</title>
    <script>
        <c:if test="${not empty alert}">
            alert("${alert}");
        </c:if>
    </script>
</head>
<body>
    <h1>Courses List</h1>
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
            <c:forEach var="course" items="${courses}">
                <tr>
                    <td>${course.getCourseId()}</td>
                    <td>${course.name}</td>
                    <td>${course.description}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/admin/courses/${course.getCourseId()}">Details</a>
                        <a href="${pageContext.request.contextPath}/admin/courses/${course.getCourseId()}/edit">Edit</a>
                        <a href="${pageContext.request.contextPath}/admin/courses/${course.getCourseId()}/delete">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="${pageContext.request.contextPath}/admin/courses/new">Add New Course</a>
</body>
</html>
