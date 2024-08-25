<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add New Student Semester Subject</title>
</head>
<body>
    <h1>Add New Student Semester Subject</h1>
    <form action="${pageContext.request.contextPath}/admin/student-semester-subjects/new" method="post">
        <label for="studentSemesterId">Student Semester ID:</label>
        <input type="text" id="studentSemesterId" name="studentSemesterId" required /><br>
        <label for="subjectId">Subject ID:</label>
        <input type="text" id="subjectId" name="subjectId" required /><br>
        <button type="submit">Add Semester Subject</button>
    </form>
    <a href="${pageContext.request.contextPath}/admin/student-semester-subjects">Back to List</a>
</body>
</html>
