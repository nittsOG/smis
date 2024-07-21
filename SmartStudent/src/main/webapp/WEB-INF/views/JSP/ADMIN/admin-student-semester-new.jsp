<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add New Student Semester</title>
</head>
<body>
    <h1>Add New Student Semester</h1>
    <form action="${pageContext.request.contextPath}/admin/student-semesters/new" method="post">
        <label for="studentId">Student ID:</label>
        <input type="text" id="studentId" name="studentId" required /><br>
        <label for="semester">Semester:</label>
        <input type="text" id="semester" name="semester" required /><br>
        <label for="year">Year:</label>
        <input type="text" id="year" name="year" required /><br>
        <button type="submit">Add Semester</button>
    </form>
    <a href="${pageContext.request.contextPath}/admin/student-semesters">Back to List</a>
</body>
</html>
