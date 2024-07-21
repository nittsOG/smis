<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student Semester Subjects List</title>
    <script>
        <c:if test="${not empty alert}">
            alert("${alert}");
        </c:if>
    </script>
</head>
<body>
    <h1>Student Semester Subjects List</h1>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Student Semester ID</th>
                <th>Subject ID</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="studentSemesterSubject" items="${studentSemesterSubjects}">
                <tr>
                    <td>${studentSemesterSubject.id}</td>
                    <td>${studentSemesterSubject.studentSemesterId}</td>
                    <td>${studentSemesterSubject.subjectId}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/admin/student-semester-subjects/${studentSemesterSubject.id}">View</a>
                        <a href="${pageContext.request.contextPath}/admin/student-semester-subjects/${studentSemesterSubject.id}/edit">Edit</a>
                        <a href="${pageContext.request.contextPath}/admin/student-semester-subjects/${studentSemesterSubject.id}/delete">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="${pageContext.request.contextPath}/admin/student-semester-subjects/new">Add New Semester Subject</a>
</body>
</html>
