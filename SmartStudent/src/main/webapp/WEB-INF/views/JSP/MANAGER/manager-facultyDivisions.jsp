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

    <!-- Filter Form by Faculty ID -->
    <form action="${pageContext.request.contextPath}/manager/facultyDivisions" method="get">
        <label for="facultyId">Filter by Faculty ID:</label>
        <input type="text" id="facultyId" name="facultyId" value="${param.facultyId}" />
        <button type="submit">Filter</button>
        <a href="${pageContext.request.contextPath}/manager/facultyDivisions">Clear Filter</a>
    </form>
    <br/>

    <table border="1">
        <thead>
            <tr>
                <th>Faculty Division ID</th>
                <th>Faculty Id</th>
                <th>Faculty Name</th>
                <th>Division Name</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="facultyDivision" items="${facultyDivisions}">
                <tr>
                    <td>${facultyDivision.facultyDivisionId}</td>
                    <td>${facultyDivision.faculty.facultyId}</td>
                    <td>${facultyDivision.faculty.username}</td>
                    <td>${facultyDivision.division.name}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/manager/facultyDivisions/${facultyDivision.facultyDivisionId}">Details</a>
                        <a href="${pageContext.request.contextPath}/manager/facultyDivisions/${facultyDivision.facultyDivisionId}/edit">Edit</a>
                      <%--   <a href="${pageContext.request.contextPath}/manager/facultyDivisions/${facultyDivision.facultyDivisionId}/delete">Delete</a> --%>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <!-- Add New Faculty Division Link -->
 <%--    <a href="${pageContext.request.contextPath}/manager/facultyDivisions/new">Add New Faculty Division</a> --%>
</body>
</html>
