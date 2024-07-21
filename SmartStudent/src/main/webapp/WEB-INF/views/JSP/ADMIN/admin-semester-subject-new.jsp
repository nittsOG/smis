<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>New Semester Subject</title>
</head>
<body>
    <h1>New Semester Subject</h1>
    <form action="${pageContext.request.contextPath}/admin/semester-subjects/new" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required /><br>
        <label for="semester">Semester:</label>
        <select id="semester" name="semester.id" required>
            <c:forEach var="semester" items="${semesters}">
                <option value="${semester.id}">${semester.name}</option>
            </c:forEach>
        </select><br>
        <button type="submit">Save Semester Subject</button>
    </form>
    <a href="${pageContext.request.contextPath}/admin/semester-subjects">Back to List</a>
</body>
</html>
