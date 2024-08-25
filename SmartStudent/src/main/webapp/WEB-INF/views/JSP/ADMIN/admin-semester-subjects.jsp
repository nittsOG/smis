<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Semester Subjects List</title>
    <script>
        <c:if test="${not empty alert}">
            alert("${alert}");
        </c:if>
    </script>
</head>
<body>
    <h1>Semester Subjects List</h1>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Semester</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="semesterSubject" items="${semesterSubjects}">
                <tr>
                    <td>${semesterSubject.id}</td>
                    <td>${semesterSubject.name}</td>
                    <td>${semesterSubject.semester.name}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/admin/semester-subjects/${semesterSubject.id}">View</a>
                        <a href="${pageContext.request.contextPath}/admin/semester-subjects/${semesterSubject.id}/edit">Edit</a>
                        <a href="${pageContext.request.contextPath}/admin/semester-subjects/${semesterSubject.id}/delete">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="${pageContext.request.contextPath}/admin/semester-subjects/new">Add New Semester Subject</a>
</body>
</html>
