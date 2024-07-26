<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Semester Results</title>
</head>
<body>
    <h1>Edit Semester Results</h1>
    <hr>
    <form action="${pageContext.request.contextPath}/admin/semester-results/${semesterResults.studentId}/${semesterResults.semester}/${semesterResults.subjectCode}/edit" method="post">
        <input type="hidden" name="studentId" value="${semesterResults.studentId}">
        <input type="hidden" name="semester" value="${semesterResults.semester}">
        <input type="hidden" name="subjectCode" value="${semesterResults.subjectCode}">
        <table border="1">
            <tr>
                <th>Subject Name</th>
                <td><input type="text" name="subjectName" value="${semesterResults.subjectName}" required></td>
            </tr>
            <tr>
                <th>Credit</th>
                <td><input type="text" name="credit" value="${semesterResults.credit}" required></td>
            </tr>
            <tr>
                <th>Grade</th>
                <td><input type="text" name="grade" value="${semesterResults.grade}" required></td>
            </tr>
            <tr>
                <th>Grade Point</th>
                <td><input type="text" name="gradePoint" value="${semesterResults.gradePoint}" required></td>
            </tr>
            <tr>
                <th>Credit Point</th>
                <td><input type="text" name="creditPoint" value="${semesterResults.creditPoint}" required></td>
            </tr>
        </table>
        <hr>
        <button type="submit">Update</button>
        <a href="${pageContext.request.contextPath}/admin/semester-results/${semesterResults.studentId}/${semesterResults.semester}/${semesterResults.subjectCode}">Cancel</a>
    </form>
    <hr>
    <a href="${pageContext.request.contextPath}/admin/semester-results">Back to List</a>
</body>
</html>
