<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Faculty Divisions List</title>
    <script>
        <c:if test="${not empty alert}">
            alert("${alert}");
        </c:if>
    </script>
</head>
<body>
    <h1>Faculty Divisions List</h1>
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
            <c:forEach var="facultyDivision" items="${facultyDivisions}">
                <tr>
                    <td>${facultyDivision.id}</td>
                    <td>${facultyDivision.name}</td>
                    <td>${facultyDivision.description}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/admin/facultyDivisions/${facultyDivision.id}">Details</a>
                        <a href="${pageContext.request.contextPath}/admin/facultyDivisions/${facultyDivision.id}/edit">Edit</a>
                        <a href="${pageContext.request.contextPath}/admin/facultyDivisions/${facultyDivision.id}/delete">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="${pageContext.request.contextPath}/admin/facultyDivisions/new">Add New Faculty Division</a>
</body>
</html>
