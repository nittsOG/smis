<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Semester Subject</title>
</head>
<body>
    <h1>Edit Semester Subject</h1>
    <form action="${pageContext.request.contextPath}/admin/semester-subjects/${semesterSubject.id}/edit" method="post">
        <input type="hidden" name="id" value="${semesterSubject.id}" />
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="${semesterSubject.name}" required /><br>
        <label for="semester">Semester:</label>
        <select id="semester" name="semester.id" required>
            <c:forEach var="semester" items="${semesters}">
                <option value="${semester.id}" ${semesterSubject.semester.id == semester.id ? 'selected' : ''}>${semester.name}</option>
            </c:forEach>
        </select><br>
        <button type="submit">Update Semester Subject</button>
    </form>
    <a href="${pageContext.request.contextPath}/admin/semester-subjects">Back to List</a>
</body>
</html>
