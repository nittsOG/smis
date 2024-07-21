<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Sessions List</title>
    <script>
        <c:if test="${not empty alert}">
            alert("${alert}");
        </c:if>
    </script>
</head>
<body>
    <h1>Sessions List</h1>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Start Date</th>
                <th>End Date</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="session" items="${sessions}">
                <tr>
                    <td>${session.id}</td>
                    <td>${session.name}</td>
                    <td>${session.startDate}</td>
                    <td>${session.endDate}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/admin/sessions/${session.id}">View</a>
                        <a href="${pageContext.request.contextPath}/admin/sessions/${session.id}/edit">Edit</a>
                        <a href="${pageContext.request.contextPath}/admin/sessions/${session.id}/delete">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="${pageContext.request.contextPath}/admin/sessions/new">Add New Session</a>
</body>
</html>
