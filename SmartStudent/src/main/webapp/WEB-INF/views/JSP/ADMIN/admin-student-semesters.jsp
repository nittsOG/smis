<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student Semesters List</title>
    <script>
        <c:if test="${not empty alert}">
            alert("${alert}");
        </c:if>
    </script>
</head>
<body>
    <h1>Student Semesters List</h1>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Student ID</th>
                <th>Semester</th>
                <th>Year</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="studentSemester" items="${studentSemesters}">
                <tr>
                    <td>${studentSemester.id}</td>
                    <td>${studentSemester.studentId}</td>
                    <td>${studentSemester.semester}</td>
                    <td>${studentSemester.year}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/admin/student-semesters/${studentSemester.id}">View</a>
                        <a href="${pageContext.request.contextPath}/admin/student-semesters/${studentSemester.id}/edit">Edit</a>
                        <a href="${pageContext.request.contextPath}/admin/student-semesters/${studentSemester.id}/delete">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="${pageContext.request.contextPath}/admin/student-semesters/new">Add New Semester</a>
</body>
</html>
