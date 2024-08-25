<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Faculty Subject</title>
    <script>
        <c:if test="${not empty alert}">
            alert("${alert}");
        </c:if>
    </script>
</head>
<body>
    <h1>Edit Faculty Subject</h1>
    <form action="${pageContext.request.contextPath}/admin/facultySubjects/${facultySubject.id}/edit" method="post">
        <input type="hidden" name="id" value="${facultySubject.id}" />
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="${facultySubject.name}" required /><br>
        <label for="code">Code:</label>
        <input type="text" id="code" name="code" value="${facultySubject.code}" required /><br>
        <button type="submit">Save</button>
    </form>
    <a href="${pageContext.request.contextPath}/admin/facultySubjects">Back to List</a>
</body>
</html>
