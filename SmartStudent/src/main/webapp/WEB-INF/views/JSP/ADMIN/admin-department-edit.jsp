<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Department</title>
    <script>
        <c:if test="${not empty alert}">
            alert("${alert}");
        </c:if>
    </script>
</head>
<body>
    <h1>Edit Department</h1>
    <form action="${pageContext.request.contextPath}/admin/departments/${department.getDepartmentId()}/edit" method="post">
        <input type="hidden" name="id" value="${department.id}" />
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="${department.name}" required /><br>
        <label for="description">Description:</label>
        <textarea id="description" name="description" required>${department.description}</textarea><br>
        <button type="submit">Update</button>
    </form>
    <a href="${pageContext.request.contextPath}/admin/departments">Back to List</a>
</body>
</html>
