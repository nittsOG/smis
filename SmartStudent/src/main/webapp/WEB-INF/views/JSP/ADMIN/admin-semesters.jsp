<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Semesters List</title>
    <script>
        <c:if test="${not empty alert}">
            alert("${alert}");
        </c:if>
    </script>
</head>
<body>
    <h1>Semesters List</h1>
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
            <c:forEach var="semester" items="${semesters}">
                <tr>
                    <td>${semester.semesterId}</td>
                    <td>${semester.name}</td>
                    <td>${semester.startDate}</td>
                    <td>${semester.endDate}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/admin/semesters/${semester.semesterId}">View</a>
                        <a href="${pageContext.request.contextPath}/admin/semesters/${semester.semesterId}/edit">Edit</a>
                        <a href="${pageContext.request.contextPath}/admin/semesters/${semester.semesterId}/delete">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="${pageContext.request.contextPath}/admin/semesters/new">Add New Semester</a>
</body>
</html>
