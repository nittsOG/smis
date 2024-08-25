<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Student Semester Subject</title>
</head>
<body>
    <h1>Edit Student Semester Subject</h1>
    <form action="${pageContext.request.contextPath}/admin/student-semester-subjects/${studentSemesterSubject.id}/edit" method="post">
        <input type="hidden" name="id" value="${studentSemesterSubject.id}" />
        <label for="studentSemesterId">Student Semester ID:</label>
        <input type="text" id="studentSemesterId" name="studentSemesterId" value="${studentSemesterSubject.studentSemesterId}" required /><br>
        <label for="subjectId">Subject ID:</label>
        <input type="text" id="subjectId" name="subjectId" value="${studentSemesterSubject.subjectId}" required /><br>
        <button type="submit">Update Semester Subject</button>
    </form>
    <a href="${pageContext.request.contextPath}/admin/student-semester-subjects">Back to List</a>
</body>
</html>
