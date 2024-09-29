<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Edit Subject</title>
</head>
<body>
    <h1>Edit Subject</h1>
    
    <form:form modelAttribute="subject" method="post" action="${pageContext.request.contextPath}/admin/subjects/${subject.subjectId}/edit">
        <!-- Hidden field for subjectId -->
        <form:hidden path="subjectId" />
        
        <label for="name">Subject Name:</label>
        <form:input path="name" id="name" /><br />

        <label for="code">Subject Code:</label>
        <form:input path="code" id="code" /><br />

        <label for="description">Description:</label>
        <form:textarea path="description" id="description" /><br />

        <label for="course">Select Course:</label>
        <form:select path="course.courseId">
            <form:options items="${courses}" itemValue="courseId" itemLabel="name" />
        </form:select><br />

        <button type="submit">Save</button>
    </form:form>
</body>
</html>
