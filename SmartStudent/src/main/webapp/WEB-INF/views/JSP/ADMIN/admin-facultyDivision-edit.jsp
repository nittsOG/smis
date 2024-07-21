<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Faculty Division</title>
    <script>
        <c:if test="${not empty alert}">
            alert("${alert}");
        </c:if>
    </script>
</head>
<body>
    <h1>Edit Faculty Division</h1>
    <form action="${pageContext.request.contextPath}/admin/facultyDivisions/${facultyDivision.id}/edit" method="post">
        <input type="hidden" name="id" value="${facultyDivision.id}" />
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="${facultyDivision.name}" required /><br>
        <label for="description">Description:</label>
        <input type="text" id="description" name="description" value="${facultyDivision.description}" required /><br>
        <button type="submit">Save</button>
    </form>
    <a href="${pageContext.request.contextPath}/admin/facultyDivisions">Back to List</a>
</body>
</html>
