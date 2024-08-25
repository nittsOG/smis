<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Faculty Subjects List</title>
    <script>
        <c:if test="${not empty alert}">
            alert("${alert}");
        </c:if>
    </script>
</head>
<body>
    <h1>Faculty Subjects List</h1>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Code</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="facultySubject" items="${facultySubjects}">
                <tr>
                    <td>${facultySubject.id}</td>
                    <td>${facultySubject.name}</td>
                    <td>${facultySubject.code}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/admin/facultySubjects/${facultySubject.id}">Details</a>
                        <a href="${pageContext.request.contextPath}/admin/facultySubjects/${facultySubject.id}/edit">Edit</a>
                        <a href="${pageContext.request.contextPath}/admin/facultySubjects/${facultySubject.id}/delete">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="${pageContext.request.contextPath}/admin/facultySubjects/new">Add New Faculty Subject</a>
</body>
</html>
