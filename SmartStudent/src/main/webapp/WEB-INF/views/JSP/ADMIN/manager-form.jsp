<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Manager Form</title>
    <script>
        <c:if test="${not empty alert}">
            alert("${alert}");
        </c:if>
    </script>
</head>
<body>
    <h1>Manager Form</h1>
    <form action="${pageContext.request.contextPath}/admin/manager/save" method="post">
        <input type="hidden" name="id" value="${manager.id}" />
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="${manager.name}" required /><br>
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" value="${manager.email}" required /><br>
        <button type="submit">Save</button>
    </form>
    <a href="${pageContext.request.contextPath}/admin/manager/list">Back to List</a>
</body>
</html>
