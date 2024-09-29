<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Semesters List</title>
</head>
<body>
    <h1>Semesters List</h1>

    <!-- Filter by Course Dropdown -->
    <form method="get" action="${pageContext.request.contextPath}/admin/semesters">
        <label for="courseId">Filter by Course:</label>
        <select id="courseId" name="courseId" onchange="this.form.submit()">
            <option value="">-- Select Course --</option>
            <c:forEach var="course" items="${courses}">
                <option value="${course.courseId}" ${selectedCourseId == course.courseId ? 'selected' : ''}>
                    ${course.name}
                </option>
            </c:forEach>
        </select>
    </form>

    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Course</th>
                <th>Start Date</th>
                <th>End Date</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="semester" items="${semesters}">
                <tr>
                    <td>${semester.semesterId}</td>
                    <td>${semester.name}</td>
                    <td>${semester.course.name}</td>
                    <td>${semester.startDate}</td>
                    <td>${semester.endDate}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/admin/semesters/${semester.semesterId}">View</a>
                        <a href="${pageContext.request.contextPath}/admin/semesters/${semester.semesterId}/edit">Edit</a>
                        <a href="${pageContext.request.contextPath}/admin/semesters/${semester.semesterId}/delete">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <a href="${pageContext.request.contextPath}/admin/semesters/new">Add New Semester</a>
</body>
</html>
