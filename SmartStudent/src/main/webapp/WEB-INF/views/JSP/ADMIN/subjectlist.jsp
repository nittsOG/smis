<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Subject List</title>
    <script>
        <c:if test="${not empty alert}">
            alert("${alert}");
        </c:if>
    </script>
</head>
<body>
    <h1>Subject List</h1>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Description</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="subject" items="${subjects}">
                <tr>
                    <td>${subject.id}</td>
                    <td>${subject.name}</td>
                    <td>${subject.description}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/admin/subject/showFormForUpdate?subjectId=${subject.id}">Edit</a>
                        <a href="${pageContext.request.contextPath}/admin/subject/delete?subjectId=${subject.id}" onclick="return confirm('Are you sure you want to delete this subject?');">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="${pageContext.request.contextPath}/admin/subject/showFormForAdd">Add New Subject</a>
</body>
</html>
