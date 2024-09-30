<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Semester Results Details</title>
</head>
<body>
    <h1>Semester Results Details</h1>
    <hr>
    <table border="1">
        <tr>
            <th>Student ID</th>
            <td>${semesterResults.studentId}</td>
        </tr>
        <tr>
            <th>Semester</th>
            <td>${semesterResults.semester}</td>
        </tr>
        <tr>
            <th>Subject Code</th>
            <td>${semesterResults.subjectCode}</td>
        </tr>
        <tr>
            <th>Subject Name</th>
            <td>${semesterResults.subjectName}</td>
        </tr>
        <tr>
            <th>Credit</th>
            <td>${semesterResults.credit}</td>
        </tr>
        <tr>
            <th>Grade</th>
            <td>${semesterResults.grade}</td>
        </tr>
        <tr>
            <th>Grade Point</th>
            <td>${semesterResults.gradePoint}</td>
        </tr>
        <tr>
            <th>Credit Point</th>
            <td>${semesterResults.creditPoint}</td>
        </tr>
    </table>
    <hr>
    <a href="${pageContext.request.contextPath}/manager/semester-results">Back to List</a>
</body>
</html>
