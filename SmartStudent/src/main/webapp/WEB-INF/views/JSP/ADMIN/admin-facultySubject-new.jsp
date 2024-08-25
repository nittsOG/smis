<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>New Faculty Subject</title>
    <script>
        <c:if test="${not empty alert}">
            alert("${alert}");
        </c:if>
    </script>
</head>
<body>
    <h1>New Faculty Subject</h1>
    <form action="${pageContext.request.contextPath}/admin/facultySubjects/new" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required /><br>
        <label for="code">Code:</label>
        <input type="text" id="code" name="code" required /><br>
        <button type="submit">Save</button>
    </form>
    <a href="${pageContext.request.contextPath}/admin/facultySubjects">Back to List</a>
</body>
</html>
