<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Backlog Details</title>
</head>
<body>
    <h1>Backlog Details</h1>
    <p><strong>Student ID:</strong> ${backlog.id.studentId}</p>
    <p><strong>Subject Code:</strong> ${backlog.id.subjectCode}</p>
    <p><strong>Semester:</strong> ${backlog.id.semester}</p>
    <p><strong>Status:</strong> ${backlog.backlogStatus}</p>

    <a href="${pageContext.request.contextPath}/admin/backlogs/${backlog.id.studentId}/${backlog.id.subjectCode}/${backlog.id.semester}/edit">Edit</a>
    <a href="${pageContext.request.contextPath}/admin/backlogs/${backlog.id.studentId}/${backlog.id.subjectCode}/${backlog.id.semester}/delete">Delete</a>
    <a href="${pageContext.request.contextPath}/admin/backlogs">Back to List</a>
    <a href="${pageContext.request.contextPath}/admin/dashboard">Back to Dashboard</a>
</body>
</html>
