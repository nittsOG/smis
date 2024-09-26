<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>New Course</title>
</head>
<body>
    <h1>New Course</h1>
    <form action="${pageContext.request.contextPath}/admin/courses/new" method="post">

        <!-- Course Name -->
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required /><br>

        <!-- Course Description -->
        <label for="description">Description:</label>
        <textarea id="description" name="description" required></textarea><br>

        <!-- Department Dropdown -->
        <label for="department">Department:</label>
        <select id="department" name="department.departmentId" required>
            <option value="">-- Select Department --</option>
            <c:forEach var="department" items="${departments}">
                <option value="${department.departmentId}">
                    ${department.name}
                </option>
            </c:forEach>
        </select><br>

        <button type="submit">Save</button>
    </form>
    <a href="${pageContext.request.contextPath}/admin/courses">Back to List</a>
</body>
</html>
