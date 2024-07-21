<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Department Details</title>
    <script>
        <c:if test="${not empty alert}">
            alert("${alert}");
        </c:if>
    </script>
</head>
<body>
    <h1>Department Details</h1>
    <p>ID: ${department.getDepartmentId()}</p>
    <p>Name: ${department.name}</p>
    <p>Description: ${department.description}</p>
    <a href="${pageContext.request.contextPath}/admin/departments">Back to List</a>
</body>
</html>
