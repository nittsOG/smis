<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Backlog</title>
</head>
<body>
    <h1>Edit Backlog</h1>
    <form:form action="${pageContext.request.contextPath}/admin/backlogs/${backlog.id.studentId}/${backlog.id.subjectCode}/${backlog.id.semester}/edit" method="post" modelAttribute="backlog">
        <label for="studentId">Student ID:</label>
        <form:input path="id.studentId" id="studentId" readonly="true"/><br/>
        
        <label for="subjectCode">Subject Code:</label>
        <form:input path="id.subjectCode" id="subjectCode" readonly="true"/><br/>

        <label for="semester">Semester:</label>
        <form:input path="id.semester" id="semester" readonly="true"/><br/>

        <label for="backlogStatus">Status:</label>
        <form:input path="backlogStatus" id="backlogStatus"/><br/>

        <input type="submit" value="Update Backlog"/>
    </form:form>

    <a href="${pageContext.request.contextPath}/admin/backlogs/${backlog.id.studentId}/${backlog.id.subjectCode}/${backlog.id.semester}">Back to Details</a>
    <a href="${pageContext.request.contextPath}/admin/backlogs">Back to List</a>
    <a href="${pageContext.request.contextPath}/admin/dashboard">Back to Dashboard</a>
</body>
</html>
