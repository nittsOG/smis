<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Faculty Form</title>
    <script>
        <c:if test="${not empty alert}">
            alert("${alert}");
        </c:if>
    </script>
</head>
<body>
    <h1>${faculty.id == null ? 'Add New Faculty' : 'Edit Faculty'}</h1>
    <form action="${pageContext.request.contextPath}/admin/faculty/save" method="post">
        <input type="hidden" name="id" value="${faculty.id}" />
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="${faculty.name}" required /><br>
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" value="${faculty.email}" required /><br>
        <label for="department">Department:</label>
        <input type="text" id="department" name="department" value="${faculty.department}" required /><br>
        <button type="submit">Save</button>
    </form>
    <a href="${pageContext.request.contextPath}/admin/faculty/list">Back to List</a>
</body>
</html>
