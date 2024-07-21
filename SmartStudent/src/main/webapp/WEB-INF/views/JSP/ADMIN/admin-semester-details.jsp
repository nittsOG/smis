<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Semester Details</title>
</head>
<body>
    <h1>Semester Details</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <td>${semester.semesterId}</td>
        </tr>
        <tr>
            <th>Name</th>
            <td>${semester.name}</td>
        </tr>
        <tr>
            <th>Start Date</th>
            <td>${semester.startDate}</td>
        </tr>
        <tr>
            <th>End Date</th>
            <td>${semester.endDate}</td>
        </tr>
        <tr>
            <th>Duration</th>
            <td>${semester.duration}</td>
        </tr>
        <tr>
            <th>Course</th>
            <td>${semester.course.name}</td>
        </tr>
    </table>
    <a href="${pageContext.request.contextPath}/admin/semesters">Back to List</a>
</body>
</html>
