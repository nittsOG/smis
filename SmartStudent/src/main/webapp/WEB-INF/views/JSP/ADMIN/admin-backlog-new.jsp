<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Add New Backlog</title>
</head>
<body>
    <h1>Add New Backlog</h1>

    <form action="${pageContext.request.contextPath}/admin/backlogs/new" method="post">
        <label for="studentId">Student ID:</label>
        <input type="text" id="studentId" name="studentId" required /><br/>

        <label for="subjectCode">Subject Code:</label>
        <input type="text" id="subjectCode" name="subjectCode" required /><br/>

        <label for="semester">Semester:</label>
        <input type="number" id="semester" name="semester" required /><br/>

        <label for="backlogStatus">Backlog Status:</label>
        <input type="text" id="backlogStatus" name="backlogStatus" required /><br/>

        <button type="submit">Save</button>
        <a href="${pageContext.request.contextPath}/admin/backlogs">Cancel</a>
    </form>
</body>
</html>
