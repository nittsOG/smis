<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Student Semester</title>
</head>
<body>
    <h1>Edit Student Semester</h1>
    <form action="${pageContext.request.contextPath}/admin/student-semesters/${studentSemester.id}/edit" method="post">
        <input type="hidden" name="id" value="${studentSemester.id}" />
        <label for="studentId">Student ID:</label>
        <input type="text" id="studentId" name="studentId" value="${studentSemester.studentId}" required /><br>
        <label for="semester">Semester:</label>
        <input type="text" id="semester" name="semester" value="${studentSemester.semester}" required /><br>
        <label for="year">Year:</label>
        <input type="text" id="year" name="year" value="${studentSemester.year}" required /><br>
        <button type="submit">Update Semester</button>
    </form>
    <a href="${pageContext.request.contextPath}/admin/student-semesters">Back to List</a>
</body>
</html>
