<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Edit Backlog</title>
</head>
<body>
    <h1>Edit Backlog</h1>

    <form action="${pageContext.request.contextPath}/admin/backlogs/${backlog.studentId}/${backlog.subjectCode}/${backlog.semester}/edit" method="post">
        <label for="studentId">Student ID:</label>
        <input type="text" id="studentId" name="studentId" value="${backlog.studentId}" readonly /><br/>

        <label for="subjectCode">Subject Code:</label>
        <input type="text" id="subjectCode" name="subjectCode" value="${backlog.subjectCode}" readonly /><br/>

        <label for="semester">Semester:</label>
        <input type="number" id="semester" name="semester" value="${backlog.semester}" readonly /><br/>

        <label for="backlogStatus">Backlog Status:</label>
        <input type="text" id="backlogStatus" name="backlogStatus" value="${backlog.backlogStatus}" required /><br/>

        <button type="submit">Update</button>
        <a href="${pageContext.request.contextPath}/admin/backlogs">Cancel</a>
    </form>
</body>
</html>
