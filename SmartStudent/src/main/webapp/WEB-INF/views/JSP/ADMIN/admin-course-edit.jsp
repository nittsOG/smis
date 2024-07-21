<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Course</title>
    <script>
        <c:if test="${not empty alert}">
            alert("${alert}");
        </c:if>
    </script>
</head>
<body>
    <h1>Edit Course</h1>
    <form action="${pageContext.request.contextPath}/admin/courses/${course.id}/edit" method="post">
        <input type="hidden" name="id" value="${course.getCourseId()}" />
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="${course.name}" required /><br>
        <label for="description">Description:</label>
        <textarea id="description" name="description" required>${course.description}</textarea><br>
        <button type="submit">Update</button>
    </form>
    <a href="${pageContext.request.contextPath}/admin/courses">Back to List</a>
</body>
</html>
