<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <title>New Backlog</title>
</head>
<body>
    <h1>New Backlog</h1>
    <form:form action="${pageContext.request.contextPath}/admin/backlogs/new" method="post" modelAttribute="backlog">
        <label for="studentId">Student ID:</label>
        <form:input path="id.studentId" id="studentId"/><br/>
        
        <label for="subjectCode">Subject Code:</label>
        <form:input path="id.subjectCode" id="subjectCode"/><br/>

        <label for="semester">Semester:</label>
        <form:input path="id.semester" id="semester"/><br/>

        <label for="backlogStatus">Status:</label>
        <form:input path="backlogStatus" id="backlogStatus"/><br/>

        <input type="submit" value="Save Backlog"/>
    </form:form>

    <a href="${pageContext.request.contextPath}/admin/backlogs">Back to List</a>
    <a href="${pageContext.request.contextPath}/admin/dashboard">Back to Dashboard</a>
</body>
</html>
