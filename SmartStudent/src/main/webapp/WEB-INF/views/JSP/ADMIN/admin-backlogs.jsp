<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Backlogs List</title>
    <script>
        <c:if test="${not empty alert}">
            alert("${alert}");
        </c:if>
    </script>
</head>
<body>
    <h1>Backlogs List</h1>
    <table border="1">
        <thead>
            <tr>
                <th>Student ID</th>
                <th>Subject Code</th>
                <th>Semester</th>
                <th>Status</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="backlog" items="${backlogs}">
                <tr>
                    <td>${backlog.id.studentId}</td>
                    <td>${backlog.id.subjectCode}</td>
                    <td>${backlog.id.semester}</td>
                    <td>${backlog.backlogStatus}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/admin/backlogs/${backlog.id.studentId}/${backlog.id.subjectCode}/${backlog.id.semester}">Details</a>
                        <a href="${pageContext.request.contextPath}/admin/backlogs/${backlog.id.studentId}/${backlog.id.subjectCode}/${backlog.id.semester}/edit">Edit</a>
                        <a href="${pageContext.request.contextPath}/admin/backlogs/${backlog.id.studentId}/${backlog.id.subjectCode}/${backlog.id.semester}/delete">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="${pageContext.request.contextPath}/admin/backlogs/new">Add New Backlog</a>
    <a href="${pageContext.request.contextPath}/admin/dashboard">Back to Dashboard</a>
</body>
</html>
