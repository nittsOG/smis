<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Backlog Details</title>
</head>
<body>
    <h1>Backlog Details</h1>

    <table border="1">
        <tr>
            <th>Student ID</th>
            <td>${backlog.studentId}</td>
        </tr>
        <tr>
            <th>Subject Code</th>
            <td>${backlog.subjectCode}</td>
        </tr>
        <tr>
            <th>Semester</th>
            <td>${backlog.semester}</td>
        </tr>
        <tr>
            <th>Backlog Status</th>
            <td>${backlog.backlogStatus}</td>
        </tr>
    </table>

    <a href="${pageContext.request.contextPath}/manager/backlogs">Back to List</a>
    <a href="${pageContext.request.contextPath}/manager/backlogs/${backlog.studentId}/${backlog.subjectCode}/${backlog.semester}/edit">Edit</a>
</body>
</html>
