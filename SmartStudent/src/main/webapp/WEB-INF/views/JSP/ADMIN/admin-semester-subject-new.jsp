<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add New Semester Subject</title>
</head>
<body>
    <h2>Add New Semester Subject</h2>

    <form:form method="post" modelAttribute="semesterSubject">
        <label for="semester">Semester:</label>
        <form:input path="semester.semesterId"/>

        <label for="subject">Subject:</label>
        <form:select path="subject.subjectId">
            <form:option value="">Select a subject</form:option>
            <c:forEach items="${subjects}" var="subject">
                <form:option value="${subject.subjectId}">
                    ${subject.name}
                </form:option>
            </c:forEach>
        </form:select>

        <button type="submit">Save</button>
    </form:form>

    <a href="${pageContext.request.contextPath}/admin/semester-subjects">Back to list</a>
</body>
</html>
