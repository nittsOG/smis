<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Semester Subject</title>
</head>
<body>
    <h2>Edit Semester Subject</h2>

    <form:form action="${pageContext.request.contextPath}/admin/semester-subjects/${semesterSubject.semesterSubjectId}/edit" method="post" modelAttribute="semesterSubject">
        <!-- Hidden field to preserve ID -->
        <form:hidden path="semesterSubjectId" />

        <!-- Dropdown for Semester -->
        <label for="semester">Semester:</label>
        <form:select path="semester.semesterId">
            <form:options items="${semesters}" itemValue="semesterId" itemLabel="name" />
        </form:select>
        <br>

        <!-- Dropdown for Subject -->
        <label for="subject">Subject:</label>
        <form:select path="subject.subjectId">
            <form:options items="${subjects}" itemValue="subjectId" itemLabel="name" />
        </form:select>
        <br>

        <!-- Submit button -->
        <button type="submit">Update</button>
    </form:form>

    <br>
    <a href="${pageContext.request.contextPath}/admin/semester-subjects">Back to List</a>
</body>
</html>
