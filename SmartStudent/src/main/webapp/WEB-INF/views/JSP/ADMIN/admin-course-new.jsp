<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>New Course</title>
    <script>
        <c:if test="${not empty alert}">
            alert("${alert}");
        </c:if>
    </script>
</head>
<body>
    <h1>New Course</h1>
    <form action="${pageContext.request.contextPath}/admin/courses/new" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required /><br>
        <label for="description">Description:</label>
        <textarea id="description" name="description" required></textarea><br>
        <button type="submit">Save</button>
    </form>
    <a href="${pageContext.request.contextPath}/admin/courses">Back to List</a>
</body>
</html>
